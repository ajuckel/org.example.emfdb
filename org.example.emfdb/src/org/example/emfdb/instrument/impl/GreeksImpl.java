/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.instrument.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.example.emfdb.instrument.Greeks;
import org.example.emfdb.instrument.InstrumentPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Greeks</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.example.emfdb.instrument.impl.GreeksImpl#getPrice <em>Price
 * </em>}</li>
 * <li>{@link org.example.emfdb.instrument.impl.GreeksImpl#getDelta <em>Delta
 * </em>}</li>
 * <li>{@link org.example.emfdb.instrument.impl.GreeksImpl#getGamma <em>Gamma
 * </em>}</li>
 * <li>{@link org.example.emfdb.instrument.impl.GreeksImpl#getVega <em>Vega
 * </em>}</li>
 * <li>{@link org.example.emfdb.instrument.impl.GreeksImpl#getTheta <em>Theta
 * </em>}</li>
 * <li>{@link org.example.emfdb.instrument.impl.GreeksImpl#getRho <em>Rho</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GreeksImpl extends EObjectImpl implements Greeks {
    /**
     * The default value of the '{@link #getPrice() <em>Price</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPrice()
     * @generated
     * @ordered
     */
    protected static final double PRICE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPrice()
     * @generated
     * @ordered
     */
    protected double price = PRICE_EDEFAULT;

    /**
     * The default value of the '{@link #getDelta() <em>Delta</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDelta()
     * @generated
     * @ordered
     */
    protected static final double DELTA_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getDelta() <em>Delta</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDelta()
     * @generated
     * @ordered
     */
    protected double delta = DELTA_EDEFAULT;

    /**
     * The default value of the '{@link #getGamma() <em>Gamma</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGamma()
     * @generated
     * @ordered
     */
    protected static final double GAMMA_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getGamma() <em>Gamma</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGamma()
     * @generated
     * @ordered
     */
    protected double gamma = GAMMA_EDEFAULT;

    /**
     * The default value of the '{@link #getVega() <em>Vega</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVega()
     * @generated
     * @ordered
     */
    protected static final double VEGA_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getVega() <em>Vega</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVega()
     * @generated
     * @ordered
     */
    protected double vega = VEGA_EDEFAULT;

    /**
     * The default value of the '{@link #getTheta() <em>Theta</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTheta()
     * @generated
     * @ordered
     */
    protected static final double THETA_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getTheta() <em>Theta</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTheta()
     * @generated
     * @ordered
     */
    protected double theta = THETA_EDEFAULT;

    /**
     * The default value of the '{@link #getRho() <em>Rho</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRho()
     * @generated
     * @ordered
     */
    protected static final double RHO_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getRho() <em>Rho</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRho()
     * @generated
     * @ordered
     */
    protected double rho = RHO_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected GreeksImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return InstrumentPackage.Literals.GREEKS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getPrice() {
        return price;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPrice(double newPrice) {
        double oldPrice = price;
        price = newPrice;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InstrumentPackage.GREEKS__PRICE, oldPrice, price));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getDelta() {
        return delta;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDelta(double newDelta) {
        double oldDelta = delta;
        delta = newDelta;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InstrumentPackage.GREEKS__DELTA, oldDelta, delta));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getGamma() {
        return gamma;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setGamma(double newGamma) {
        double oldGamma = gamma;
        gamma = newGamma;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InstrumentPackage.GREEKS__GAMMA, oldGamma, gamma));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getVega() {
        return vega;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setVega(double newVega) {
        double oldVega = vega;
        vega = newVega;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InstrumentPackage.GREEKS__VEGA, oldVega, vega));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getTheta() {
        return theta;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTheta(double newTheta) {
        double oldTheta = theta;
        theta = newTheta;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InstrumentPackage.GREEKS__THETA, oldTheta, theta));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getRho() {
        return rho;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRho(double newRho) {
        double oldRho = rho;
        rho = newRho;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    InstrumentPackage.GREEKS__RHO, oldRho, rho));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case InstrumentPackage.GREEKS__PRICE:
            return getPrice();
        case InstrumentPackage.GREEKS__DELTA:
            return getDelta();
        case InstrumentPackage.GREEKS__GAMMA:
            return getGamma();
        case InstrumentPackage.GREEKS__VEGA:
            return getVega();
        case InstrumentPackage.GREEKS__THETA:
            return getTheta();
        case InstrumentPackage.GREEKS__RHO:
            return getRho();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case InstrumentPackage.GREEKS__PRICE:
            setPrice((Double) newValue);
            return;
        case InstrumentPackage.GREEKS__DELTA:
            setDelta((Double) newValue);
            return;
        case InstrumentPackage.GREEKS__GAMMA:
            setGamma((Double) newValue);
            return;
        case InstrumentPackage.GREEKS__VEGA:
            setVega((Double) newValue);
            return;
        case InstrumentPackage.GREEKS__THETA:
            setTheta((Double) newValue);
            return;
        case InstrumentPackage.GREEKS__RHO:
            setRho((Double) newValue);
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
        case InstrumentPackage.GREEKS__PRICE:
            setPrice(PRICE_EDEFAULT);
            return;
        case InstrumentPackage.GREEKS__DELTA:
            setDelta(DELTA_EDEFAULT);
            return;
        case InstrumentPackage.GREEKS__GAMMA:
            setGamma(GAMMA_EDEFAULT);
            return;
        case InstrumentPackage.GREEKS__VEGA:
            setVega(VEGA_EDEFAULT);
            return;
        case InstrumentPackage.GREEKS__THETA:
            setTheta(THETA_EDEFAULT);
            return;
        case InstrumentPackage.GREEKS__RHO:
            setRho(RHO_EDEFAULT);
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
        case InstrumentPackage.GREEKS__PRICE:
            return price != PRICE_EDEFAULT;
        case InstrumentPackage.GREEKS__DELTA:
            return delta != DELTA_EDEFAULT;
        case InstrumentPackage.GREEKS__GAMMA:
            return gamma != GAMMA_EDEFAULT;
        case InstrumentPackage.GREEKS__VEGA:
            return vega != VEGA_EDEFAULT;
        case InstrumentPackage.GREEKS__THETA:
            return theta != THETA_EDEFAULT;
        case InstrumentPackage.GREEKS__RHO:
            return rho != RHO_EDEFAULT;
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
        result.append(" (price: ");
        result.append(price);
        result.append(", delta: ");
        result.append(delta);
        result.append(", gamma: ");
        result.append(gamma);
        result.append(", vega: ");
        result.append(vega);
        result.append(", theta: ");
        result.append(theta);
        result.append(", rho: ");
        result.append(rho);
        result.append(')');
        return result.toString();
    }

} // GreeksImpl
