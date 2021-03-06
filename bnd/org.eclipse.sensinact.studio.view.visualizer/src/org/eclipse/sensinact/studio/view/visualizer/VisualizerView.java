/**
 * Copyright (c) 2019 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.view.visualizer;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.ObjectNameTypeValue;
import org.eclipse.sensinact.studio.http.messages.snamessage.ValueType;
import org.eclipse.sensinact.studio.http.messages.snamessage.attributevalueupdated.MsgAttributeValueUpdated;
import org.eclipse.sensinact.studio.http.services.client.connectionmanager.NotifDispatcher;
import org.eclipse.sensinact.studio.http.services.client.listener.NotifSubscriptionListener;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.view.visualizer.graphmanager.GraphManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * @author Etienne Gandrille
 */
public class VisualizerView implements NotifSubscriptionListener {

	private static final Logger logger = Logger.getLogger(VisualizerView.class);
	
	public static final String VIEW_ID = "org.eclipse.sensinact.studio.view.visualizer.view";
	
	private Label titleLabel = null;
	private Composite contentComposite = null;
	private Button btn = null;
	private Label msgLabel = null;
	private XYGraph xyGraph = null;
	private GraphManager graphUpdater = null;
	
	private VisualizerSettings visuSettings = null;

	private final String DEFAULT_TITLE = "";
	private final String DEFAULT_MESSAGE = "Drag and drop a resource here !";
	private final String DEFAULT_BTN_TEXT = "Listener not activated";
	
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, true));

		// Label
		GridData labelGridData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		titleLabel = new Label(parent, SWT.CENTER);
		titleLabel.setLayoutData(labelGridData);

		// Composite : place holder for visualizer
		GridData comositeGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		contentComposite = new Composite(parent, SWT.NONE);
		contentComposite.setLayoutData(comositeGridData);
		contentComposite.setLayout(new GridLayout(1, true));

		// Message Label = to be updated -->
		GridData msgGridData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		msgLabel = new Label(contentComposite, SWT.WRAP);
		msgLabel.setLayoutData(msgGridData);

		// LightweightSystem creates the bridge between SWT and draw2D
		GridData canevasData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		Canvas canvas = new Canvas(contentComposite, SWT.NONE);
		canvas.setLayoutData(canevasData);
		final LightweightSystem lws = new LightweightSystem(canvas);
	
		// create a new XY Graph.
		xyGraph = new XYGraph();
		lws.setContents(xyGraph);	
		graphUpdater = new GraphManager(xyGraph);
		
		// Button
		GridData btnGridData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		btn = new Button(parent, SWT.CENTER);
		btn.setLayoutData(btnGridData);
		btn.addMouseListener(new BtnListener());

		// DND
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		Transfer[] transferTypes = new Transfer[] { TextTransfer.getInstance() };
		DropTarget target = new DropTarget(parent, operations);
		target.setTransfer(transferTypes);
		target.addDropListener(new VisualizerDropListener(this));
		
		// set labels
		resetUI();
	}

	@PreDestroy
	public void dispose() {
	}

	void dropValidated(VisualizerSettings newSettings) throws IOException {

		// unsubscribe
		try {
			if (visuSettings != null) {
				unsubscribe(false);
			}
		} catch (IOException e) {
			logger.error("unsubscribe failed", e);
		}
		
		// subscribe
		subscribe(newSettings, true);
	}

	private void subscribe(VisualizerSettings newSettings, boolean updateUI) throws IOException {
		ResourceDescriptor resource = newSettings.getDescriptor();
		NotifDispatcher.getInstance().subscribe(this);
		this.visuSettings = newSettings;
		
		if (updateUI) {
			graphUpdater.stop();
			titleLabel.setText(resource.toString());
			msgLabel.setText("Waiting for notification...");
			btn.setText("Stop listener");
			btn.setEnabled(true);
		}
	}
	
	private void unsubscribe(boolean updateUI) throws IOException {
		NotifDispatcher.getInstance().unsubscribe(this);
		visuSettings = null;
		
		if (updateUI) {
			graphUpdater.stop();
			resetUI();
		}
	}
	
	@Override
	public void onLifecycleEvent(String gateway, List<MsgSensinact> message) {
		// do nothing
	}

	@Override
	public void onLocationEvent(String gateway, List<MsgSensinact> message) {
		// do nothing
	}
	
	@Override
	public void onIconEvent(String gateway, List<MsgSensinact> message) {
		// do nothing
	}

	@Override
	public void onValueEvent(String gateway, List<MsgSensinact> messages) {
		if (visuSettings != null) {
			ResourceDescriptor desc = visuSettings.getDescriptor();
			if (desc.getGateway().equals(gateway)) {
				for (MsgSensinact m : messages) {
					if (m instanceof MsgAttributeValueUpdated) {
						MsgAttributeValueUpdated msg = (MsgAttributeValueUpdated) m;
						if (msg.getUri().equals("/" + desc.getDevice() + "/" + desc.getService() + "/" + desc.getResource() + "/value")) {
							ObjectNameTypeValue val = msg.getNotification();
							onRelevantValue(val);
						}						
					}
				}
			}
		}
	}
	
	private void onRelevantValue(final ObjectNameTypeValue val) 
	{
		final String label = "New value: " + val.getValueAsString();
		final ValueType type = val.getType();
		final String valAsStr = val.getValueAsString();
		final ResourceDescriptor resource = visuSettings.getDescriptor();
		
		Display.getDefault().asyncExec(new Runnable() {
			public void run() 
			{
				msgLabel.setText(label);
								
				if (type == ValueType.INT) {
					int value = Integer.parseInt(valAsStr);
					updateGraph(resource, value);
				} else if (type == ValueType.LONG) {
					float value = Long.parseLong(valAsStr);
					updateGraph(resource, value);
				} else if (type == ValueType.DOUBLE) {
					double value = Double.parseDouble(valAsStr);
					updateGraph(resource, value);
				} else {
					logger.info(this.getClass().getCanonicalName() + ": Type " + type + " cannot produce chart");
				}
			}
		});
	}
		
	private void updateGraph(ResourceDescriptor resource, double value) {
		graphUpdater.start(resource);
		graphUpdater.setValue(value);
	}
	
	private void resetUI() {
		titleLabel.setText(DEFAULT_TITLE);
		msgLabel.setText(DEFAULT_MESSAGE);
		btn.setText(DEFAULT_BTN_TEXT);
		btn.setEnabled(false);
	}
	
	private class BtnListener implements MouseListener {

		private final Logger logger = Logger.getLogger(BtnListener.class);
		
		@Override
		public void mouseDoubleClick(MouseEvent e) {
		}

		@Override
		public void mouseDown(MouseEvent e) {
		}

		@Override
		public void mouseUp(MouseEvent e) {
			try {
				unsubscribe(true);
			} catch (IOException e1) {
				logger.error("Unsubscribe failed", e1);
			}
		}
	}
}
