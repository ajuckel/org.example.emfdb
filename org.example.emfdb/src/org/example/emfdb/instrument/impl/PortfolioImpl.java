/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.instrument.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.example.emfdb.instrument.Instrument;
import org.example.emfdb.instrument.InstrumentPackage;
import org.example.emfdb.instrument.Portfolio;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Portfolio</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.example.emfdb.instrument.impl.PortfolioImpl#getInstruments
 * <em>Instruments</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PortfolioImpl extends EObjectImpl implements Portfolio {
    /**
     * The cached value of the '{@link #getInstruments() <em>Instruments</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getInstruments()
     * @generated
     * @ordered
     */
    protected EList<Instrument> instruments;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PortfolioImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InstrumentPackage.Literals.PORTFOLIO;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Instrument> getInstruments() {
        if (instruments == null) {
            instruments = new EObjectContainmentEList<Instrument>(
                    Instrument.class, this,
                    InstrumentPackage.PORTFOLIO__INSTRUMENTS);
        }
        return instruments;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd,
            int featureID, NotificationChain msgs) {
        switch (featureID) {
        case InstrumentPackage.PORTFOLIO__INSTRUMENTS:
            return ((InternalEList<?>) getInstruments()).basicRemove(otherEnd,
                    msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case InstrumentPackage.PORTFOLIO__INSTRUMENTS:
            return getInstruments();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case InstrumentPackage.PORTFOLIO__INSTRUMENTS:
            getInstruments().clear();
            getInstruments()
                    .addAll((Collection<? extends Instrument>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case InstrumentPackage.PORTFOLIO__INSTRUMENTS:
            getInstruments().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case InstrumentPackage.PORTFOLIO__INSTRUMENTS:
            return instruments != null && !instruments.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    @SuppressWarnings("serial")
    public void useIdentityEqualsList() {
        instruments = new EObjectContainmentEList<Instrument>(Instrument.class,
                this, InstrumentPackage.PORTFOLIO__INSTRUMENTS) {
            @Override
            public boolean equals(Object object) {
                return this == object;
            }
        };
    }
} // PortfolioImpl
