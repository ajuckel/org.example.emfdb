/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.instrument;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Greeks</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.example.emfdb.instrument.Greeks#getPrice <em>Price</em>}</li>
 * <li>{@link org.example.emfdb.instrument.Greeks#getDelta <em>Delta</em>}</li>
 * <li>{@link org.example.emfdb.instrument.Greeks#getGamma <em>Gamma</em>}</li>
 * <li>{@link org.example.emfdb.instrument.Greeks#getVega <em>Vega</em>}</li>
 * <li>{@link org.example.emfdb.instrument.Greeks#getTheta <em>Theta</em>}</li>
 * <li>{@link org.example.emfdb.instrument.Greeks#getRho <em>Rho</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.example.emfdb.instrument.InstrumentPackage#getGreeks()
 * @model
 * @generated
 */
public interface Greeks extends EObject {
    /**
     * Returns the value of the '<em><b>Price</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Price</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Price</em>' attribute.
     * @see #setPrice(double)
     * @see org.example.emfdb.instrument.InstrumentPackage#getGreeks_Price()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Double"
     * @generated
     */
    double getPrice();

    /**
     * Sets the value of the '
     * {@link org.example.emfdb.instrument.Greeks#getPrice <em>Price</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Price</em>' attribute.
     * @see #getPrice()
     * @generated
     */
    void setPrice(double value);

    /**
     * Returns the value of the '<em><b>Delta</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Delta</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Delta</em>' attribute.
     * @see #setDelta(double)
     * @see org.example.emfdb.instrument.InstrumentPackage#getGreeks_Delta()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Double"
     * @generated
     */
    double getDelta();

    /**
     * Sets the value of the '
     * {@link org.example.emfdb.instrument.Greeks#getDelta <em>Delta</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Delta</em>' attribute.
     * @see #getDelta()
     * @generated
     */
    void setDelta(double value);

    /**
     * Returns the value of the '<em><b>Gamma</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gamma</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Gamma</em>' attribute.
     * @see #setGamma(double)
     * @see org.example.emfdb.instrument.InstrumentPackage#getGreeks_Gamma()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Double"
     * @generated
     */
    double getGamma();

    /**
     * Sets the value of the '
     * {@link org.example.emfdb.instrument.Greeks#getGamma <em>Gamma</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Gamma</em>' attribute.
     * @see #getGamma()
     * @generated
     */
    void setGamma(double value);

    /**
     * Returns the value of the '<em><b>Vega</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Vega</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Vega</em>' attribute.
     * @see #setVega(double)
     * @see org.example.emfdb.instrument.InstrumentPackage#getGreeks_Vega()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Double"
     * @generated
     */
    double getVega();

    /**
     * Sets the value of the '
     * {@link org.example.emfdb.instrument.Greeks#getVega <em>Vega</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Vega</em>' attribute.
     * @see #getVega()
     * @generated
     */
    void setVega(double value);

    /**
     * Returns the value of the '<em><b>Theta</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Theta</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Theta</em>' attribute.
     * @see #setTheta(double)
     * @see org.example.emfdb.instrument.InstrumentPackage#getGreeks_Theta()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Double"
     * @generated
     */
    double getTheta();

    /**
     * Sets the value of the '
     * {@link org.example.emfdb.instrument.Greeks#getTheta <em>Theta</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Theta</em>' attribute.
     * @see #getTheta()
     * @generated
     */
    void setTheta(double value);

    /**
     * Returns the value of the '<em><b>Rho</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rho</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Rho</em>' attribute.
     * @see #setRho(double)
     * @see org.example.emfdb.instrument.InstrumentPackage#getGreeks_Rho()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Double"
     * @generated
     */
    double getRho();

    /**
     * Sets the value of the '{@link org.example.emfdb.instrument.Greeks#getRho
     * <em>Rho</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Rho</em>' attribute.
     * @see #getRho()
     * @generated
     */
    void setRho(double value);

} // Greeks
