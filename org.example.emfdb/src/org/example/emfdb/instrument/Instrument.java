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
 * <em><b>Instrument</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.example.emfdb.instrument.Instrument#getId <em>Id</em>}</li>
 * <li>{@link org.example.emfdb.instrument.Instrument#getSymbol <em>Symbol</em>}
 * </li>
 * <li>{@link org.example.emfdb.instrument.Instrument#getScores <em>Scores</em>}
 * </li>
 * <li>{@link org.example.emfdb.instrument.Instrument#getGreeks <em>Greeks</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see org.example.emfdb.instrument.InstrumentPackage#getInstrument()
 * @model
 * @generated
 */
public interface Instrument extends EObject {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(int)
     * @see org.example.emfdb.instrument.InstrumentPackage#getInstrument_Id()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '
     * {@link org.example.emfdb.instrument.Instrument#getId <em>Id</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(int value);

    /**
     * Returns the value of the '<em><b>Symbol</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Symbol</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Symbol</em>' attribute.
     * @see #setSymbol(String)
     * @see org.example.emfdb.instrument.InstrumentPackage#getInstrument_Symbol()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getSymbol();

    /**
     * Sets the value of the '
     * {@link org.example.emfdb.instrument.Instrument#getSymbol <em>Symbol</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Symbol</em>' attribute.
     * @see #getSymbol()
     * @generated
     */
    void setSymbol(String value);

    /**
     * Returns the value of the '<em><b>Scores</b></em>' reference list. The
     * list contents are of type {@link org.example.emfdb.instrument.Score}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Scores</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Scores</em>' reference list.
     * @see org.example.emfdb.instrument.InstrumentPackage#getInstrument_Scores()
     * @model
     * @generated
     */
    EList<Score> getScores();

    /**
     * Returns the value of the '<em><b>Greeks</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Greeks</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Greeks</em>' reference.
     * @see #setGreeks(Greeks)
     * @see org.example.emfdb.instrument.InstrumentPackage#getInstrument_Greeks()
     * @model
     * @generated
     */
    Greeks getGreeks();

    /**
     * Sets the value of the '
     * {@link org.example.emfdb.instrument.Instrument#getGreeks <em>Greeks</em>}
     * ' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Greeks</em>' reference.
     * @see #getGreeks()
     * @generated
     */
    void setGreeks(Greeks value);

} // Instrument
