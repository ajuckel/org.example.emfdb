/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.instrument;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Portfolio</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.example.emfdb.instrument.Portfolio#getInstruments <em>
 * Instruments</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.example.emfdb.instrument.InstrumentPackage#getPortfolio()
 * @model
 * @generated
 */
public interface Portfolio extends EObject {
    /**
     * Returns the value of the '<em><b>Instruments</b></em>' containment
     * reference list. The list contents are of type
     * {@link org.example.emfdb.instrument.Instrument}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instruments</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Instruments</em>' containment reference
     *         list.
     * @see org.example.emfdb.instrument.InstrumentPackage#getPortfolio_Instruments()
     * @model containment="true"
     * @generated
     */
    EList<Instrument> getInstruments();

} // Portfolio
