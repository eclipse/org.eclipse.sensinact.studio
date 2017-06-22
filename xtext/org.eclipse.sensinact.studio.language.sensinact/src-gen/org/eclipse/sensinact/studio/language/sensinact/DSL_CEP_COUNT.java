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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSL CEP COUNT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_COUNT#getRef <em>Ref</em>}</li>
 *   <li>{@link org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_COUNT#getWindow <em>Window</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sensinact.studio.language.sensinact.SensinactPackage#getDSL_CEP_COUNT()
 * @model
 * @generated
 */
public interface DSL_CEP_COUNT extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(DSL_REF_CONDITION)
   * @see org.eclipse.sensinact.studio.language.sensinact.SensinactPackage#getDSL_CEP_COUNT_Ref()
   * @model containment="true"
   * @generated
   */
  DSL_REF_CONDITION getRef();

  /**
   * Sets the value of the '{@link org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_COUNT#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(DSL_REF_CONDITION value);

  /**
   * Returns the value of the '<em><b>Window</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Window</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Window</em>' containment reference.
   * @see #setWindow(DSL_CEP_DURATION)
   * @see org.eclipse.sensinact.studio.language.sensinact.SensinactPackage#getDSL_CEP_COUNT_Window()
   * @model containment="true"
   * @generated
   */
  DSL_CEP_DURATION getWindow();

  /**
   * Sets the value of the '{@link org.eclipse.sensinact.studio.language.sensinact.DSL_CEP_COUNT#getWindow <em>Window</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Window</em>' containment reference.
   * @see #getWindow()
   * @generated
   */
  void setWindow(DSL_CEP_DURATION value);

} // DSL_CEP_COUNT
