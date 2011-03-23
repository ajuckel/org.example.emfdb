/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.instrument.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.example.emfdb.instrument.Greeks;
import org.example.emfdb.instrument.Instrument;
import org.example.emfdb.instrument.InstrumentPackage;
import org.example.emfdb.instrument.Score;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Instrument</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.example.emfdb.instrument.impl.InstrumentImpl#getId <em>Id
 * </em>}</li>
 * <li>{@link org.example.emfdb.instrument.impl.InstrumentImpl#getSymbol <em>
 * Symbol</em>}</li>
 * <li>{@link org.example.emfdb.instrument.impl.InstrumentImpl#getScores <em>
 * Scores</em>}</li>
 * <li>{@link org.example.emfdb.instrument.impl.InstrumentImpl#getGreeks <em>
 * Greeks</em>}</li>
 * <li>{@link org.example.emfdb.instrument.impl.InstrumentImpl#getUnderPrice
 * <em>Under Price</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class InstrumentImpl extends EObjectImpl implements Instrument {
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final int ID_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected int id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getSymbol() <em>Symbol</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSymbol()
     * @generated
     * @ordered
     */
    protected static final String SYMBOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSymbol()
     * @generated
     * @ordered
     */
    protected String symbol = SYMBOL_EDEFAULT;

    /**
     * The cached value of the '{@link #getScores() <em>Scores</em>}' reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getScores()
     * @generated
     * @ordered
     */
    protected EList<Score> scores;

    /**
     * The cached value of the '{@link #getGreeks() <em>Greeks</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGreeks()
     * @generated
     * @ordered
     */
    protected Greeks greeks;

    /**
     * The default value of the '{@link #getUnderPrice() <em>Under Price</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getUnderPrice()
     * @generated
     * @ordered
     */
    protected static final double UNDER_PRICE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getUnderPrice() <em>Under Price</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getUnderPrice()
     * @generated
     * @ordered
     */
    protected double underPrice = UNDER_PRICE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InstrumentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InstrumentPackage.Literals.INSTRUMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setId(int newId) {
        int oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InstrumentPackage.INSTRUMENT__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSymbol(String newSymbol) {
        String oldSymbol = symbol;
        symbol = newSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InstrumentPackage.INSTRUMENT__SYMBOL, oldSymbol, symbol));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Score> getScores() {
        if (scores == null) {
            scores = new EObjectResolvingEList<Score>(Score.class, this,
                    InstrumentPackage.INSTRUMENT__SCORES);
        }
        return scores;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Greeks getGreeks() {
        if (greeks != null && greeks.eIsProxy()) {
            InternalEObject oldGreeks = (InternalEObject) greeks;
            greeks = (Greeks) eResolveProxy(oldGreeks);
            if (greeks != oldGreeks) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            InstrumentPackage.INSTRUMENT__GREEKS, oldGreeks,
                            greeks));
            }
        }
        return greeks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Greeks basicGetGreeks() {
        return greeks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setGreeks(Greeks newGreeks) {
        Greeks oldGreeks = greeks;
        greeks = newGreeks;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InstrumentPackage.INSTRUMENT__GREEKS, oldGreeks, greeks));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getUnderPrice() {
        return underPrice;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setUnderPrice(double newUnderPrice) {
        double oldUnderPrice = underPrice;
        underPrice = newUnderPrice;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InstrumentPackage.INSTRUMENT__UNDER_PRICE, oldUnderPrice,
                    underPrice));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case InstrumentPackage.INSTRUMENT__ID:
            return getId();
        case InstrumentPackage.INSTRUMENT__SYMBOL:
            return getSymbol();
        case InstrumentPackage.INSTRUMENT__SCORES:
            return getScores();
        case InstrumentPackage.INSTRUMENT__GREEKS:
            if (resolve)
                return getGreeks();
            return basicGetGreeks();
        case InstrumentPackage.INSTRUMENT__UNDER_PRICE:
            return getUnderPrice();
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
        case InstrumentPackage.INSTRUMENT__ID:
            setId((Integer) newValue);
            return;
        case InstrumentPackage.INSTRUMENT__SYMBOL:
            setSymbol((String) newValue);
            return;
        case InstrumentPackage.INSTRUMENT__SCORES:
            getScores().clear();
            getScores().addAll((Collection<? extends Score>) newValue);
            return;
        case InstrumentPackage.INSTRUMENT__GREEKS:
            setGreeks((Greeks) newValue);
            return;
        case InstrumentPackage.INSTRUMENT__UNDER_PRICE:
            setUnderPrice((Double) newValue);
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
        case InstrumentPackage.INSTRUMENT__ID:
            setId(ID_EDEFAULT);
            return;
        case InstrumentPackage.INSTRUMENT__SYMBOL:
            setSymbol(SYMBOL_EDEFAULT);
            return;
        case InstrumentPackage.INSTRUMENT__SCORES:
            getScores().clear();
            return;
        case InstrumentPackage.INSTRUMENT__GREEKS:
            setGreeks((Greeks) null);
            return;
        case InstrumentPackage.INSTRUMENT__UNDER_PRICE:
            setUnderPrice(UNDER_PRICE_EDEFAULT);
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
        case InstrumentPackage.INSTRUMENT__ID:
            return id != ID_EDEFAULT;
        case InstrumentPackage.INSTRUMENT__SYMBOL:
            return SYMBOL_EDEFAULT == null ? symbol != null : !SYMBOL_EDEFAULT
                    .equals(symbol);
        case InstrumentPackage.INSTRUMENT__SCORES:
            return scores != null && !scores.isEmpty();
        case InstrumentPackage.INSTRUMENT__GREEKS:
            return greeks != null;
        case InstrumentPackage.INSTRUMENT__UNDER_PRICE:
            return underPrice != UNDER_PRICE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (id: ");
        result.append(id);
        result.append(", symbol: ");
        result.append(symbol);
        result.append(", underPrice: ");
        result.append(underPrice);
        result.append(')');
        return result.toString();
    }

} // InstrumentImpl
