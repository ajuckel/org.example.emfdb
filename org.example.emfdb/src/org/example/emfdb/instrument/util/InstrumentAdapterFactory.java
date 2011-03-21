/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.instrument.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.example.emfdb.instrument.*;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see org.example.emfdb.instrument.InstrumentPackage
 * @generated
 */
public class InstrumentAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static InstrumentPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public InstrumentAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = InstrumentPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This implementation returns <code>true</code> if
     * the object is either the model's package or is an instance object of the
     * model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InstrumentSwitch<Adapter> modelSwitch = new InstrumentSwitch<Adapter>() {
        @Override
        public Adapter caseInstrument(Instrument object) {
            return createInstrumentAdapter();
        }

        @Override
        public Adapter casePortfolio(Portfolio object) {
            return createPortfolioAdapter();
        }

        @Override
        public Adapter caseScore(Score object) {
            return createScoreAdapter();
        }

        @Override
        public Adapter caseGreeks(Greeks object) {
            return createGreeksAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.example.emfdb.instrument.Instrument <em>Instrument</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.example.emfdb.instrument.Instrument
     * @generated
     */
    public Adapter createInstrumentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.example.emfdb.instrument.Portfolio <em>Portfolio</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.example.emfdb.instrument.Portfolio
     * @generated
     */
    public Adapter createPortfolioAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.example.emfdb.instrument.Score <em>Score</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.example.emfdb.instrument.Score
     * @generated
     */
    public Adapter createScoreAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.example.emfdb.instrument.Greeks <em>Greeks</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.example.emfdb.instrument.Greeks
     * @generated
     */
    public Adapter createGreeksAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This
     * default implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // InstrumentAdapterFactory
