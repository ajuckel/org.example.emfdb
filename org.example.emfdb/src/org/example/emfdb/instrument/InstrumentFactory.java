/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.instrument;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.example.emfdb.instrument.InstrumentPackage
 * @generated
 */
public interface InstrumentFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    InstrumentFactory eINSTANCE = org.example.emfdb.instrument.impl.InstrumentFactoryImpl
            .init();

    /**
     * Returns a new object of class '<em>Instrument</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Instrument</em>'.
     * @generated
     */
    Instrument createInstrument();

    /**
     * Returns a new object of class '<em>Portfolio</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Portfolio</em>'.
     * @generated
     */
    Portfolio createPortfolio();

    /**
     * Returns a new object of class '<em>Score</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Score</em>'.
     * @generated
     */
    Score createScore();

    /**
     * Returns a new object of class '<em>Greeks</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Greeks</em>'.
     * @generated
     */
    Greeks createGreeks();

    /**
     * Returns a new object of class '<em>Greeks</em>', with values initialized
     * to initialValue. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Greeks</em>'.
     * @generated NOT
     */
    Greeks createGreeks(double initialValue);

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    InstrumentPackage getInstrumentPackage();

} // InstrumentFactory
