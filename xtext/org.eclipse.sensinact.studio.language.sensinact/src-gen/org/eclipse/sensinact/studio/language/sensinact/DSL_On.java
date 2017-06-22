/**
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
/**
 * generated by Xtext 2.9.1
 */
package org.eclipse.sensinact.studio.language.sensinact;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSL On</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sensinact.studio.language.sensinact.DSL_On#getTriggers <em>Triggers</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sensinact.studio.language.sensinact.SensinactPackage#getDSL_On()
 * @model
 * @generated
 */
public interface DSL_On extends EObject
{
  /**
   * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.sensinact.studio.language.sensinact.DSL_REF_CONDITION}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Triggers</em>' containment reference list.
   * @see org.eclipse.sensinact.studio.language.sensinact.SensinactPackage#getDSL_On_Triggers()
   * @model containment="true"
   * @generated
   */
  EList<DSL_REF_CONDITION> getTriggers();

} // DSL_On
