/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.instrument.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.example.emfdb.instrument.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class InstrumentFactoryImpl extends EFactoryImpl implements
        InstrumentFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static InstrumentFactory init() {
        try {
            InstrumentFactory theInstrumentFactory = (InstrumentFactory) EPackage.Registry.INSTANCE
                    .getEFactory("http://example.org/instrument");
            if (theInstrumentFactory != null) {
                return theInstrumentFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new InstrumentFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public InstrumentFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case InstrumentPackage.INSTRUMENT:
            return createInstrument();
        case InstrumentPackage.PORTFOLIO:
            return createPortfolio();
        case InstrumentPackage.SCORE:
            return createScore();
        case InstrumentPackage.GREEKS:
            return createGreeks();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName()
                    + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Instrument createInstrument() {
        InstrumentImpl instrument = new InstrumentImpl();
        return instrument;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Portfolio createPortfolio() {
        PortfolioImpl portfolio = new PortfolioImpl();
        return portfolio;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Score createScore() {
        ScoreImpl score = new ScoreImpl();
        return score;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Greeks createGreeks() {
        GreeksImpl greeks = new GreeksImpl();
        return greeks;
    }

    public Greeks createGreeks(double initialValue) {
        Greeks greeks = this.createGreeks();
        greeks.setPrice(initialValue);
        greeks.setDelta(initialValue);
        greeks.setGamma(initialValue);
        greeks.setVega(initialValue);
        greeks.setTheta(initialValue);
        greeks.setRho(initialValue);
        return greeks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InstrumentPackage getInstrumentPackage() {
        return (InstrumentPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static InstrumentPackage getPackage() {
        return InstrumentPackage.eINSTANCE;
    }

} // InstrumentFactoryImpl
