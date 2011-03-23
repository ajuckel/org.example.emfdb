/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.instrument.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.example.emfdb.instrument.Greeks;
import org.example.emfdb.instrument.Instrument;
import org.example.emfdb.instrument.InstrumentFactory;
import org.example.emfdb.instrument.InstrumentPackage;
import org.example.emfdb.instrument.Portfolio;
import org.example.emfdb.instrument.Score;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class InstrumentPackageImpl extends EPackageImpl implements
        InstrumentPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass instrumentEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass portfolioEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass scoreEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass greeksEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.example.emfdb.instrument.InstrumentPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private InstrumentPackageImpl() {
        super(eNS_URI, InstrumentFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * 
     * <p>
     * This method is used to initialize {@link InstrumentPackage#eINSTANCE}
     * when that field is accessed. Clients should not invoke it directly.
     * Instead, they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static InstrumentPackage init() {
        if (isInited)
            return (InstrumentPackage) EPackage.Registry.INSTANCE
                    .getEPackage(InstrumentPackage.eNS_URI);

        // Obtain or create and register package
        InstrumentPackageImpl theInstrumentPackage = (InstrumentPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof InstrumentPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI) : new InstrumentPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theInstrumentPackage.createPackageContents();

        // Initialize created meta-data
        theInstrumentPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theInstrumentPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(InstrumentPackage.eNS_URI,
                theInstrumentPackage);
        return theInstrumentPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getInstrument() {
        return instrumentEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getInstrument_Id() {
        return (EAttribute) instrumentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getInstrument_Symbol() {
        return (EAttribute) instrumentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInstrument_Scores() {
        return (EReference) instrumentEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInstrument_Greeks() {
        return (EReference) instrumentEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getInstrument_UnderPrice() {
        return (EAttribute) instrumentEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPortfolio() {
        return portfolioEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPortfolio_Instruments() {
        return (EReference) portfolioEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getScore() {
        return scoreEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getScore_I() {
        return (EAttribute) scoreEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getScore_L() {
        return (EAttribute) scoreEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getScore_F() {
        return (EAttribute) scoreEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getScore_D() {
        return (EAttribute) scoreEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getGreeks() {
        return greeksEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGreeks_Price() {
        return (EAttribute) greeksEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGreeks_Delta() {
        return (EAttribute) greeksEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGreeks_Gamma() {
        return (EAttribute) greeksEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGreeks_Vega() {
        return (EAttribute) greeksEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGreeks_Theta() {
        return (EAttribute) greeksEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGreeks_Rho() {
        return (EAttribute) greeksEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InstrumentFactory getInstrumentFactory() {
        return (InstrumentFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to
     * have no affect on any invocation but its first. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        instrumentEClass = createEClass(INSTRUMENT);
        createEAttribute(instrumentEClass, INSTRUMENT__ID);
        createEAttribute(instrumentEClass, INSTRUMENT__SYMBOL);
        createEReference(instrumentEClass, INSTRUMENT__SCORES);
        createEReference(instrumentEClass, INSTRUMENT__GREEKS);
        createEAttribute(instrumentEClass, INSTRUMENT__UNDER_PRICE);

        portfolioEClass = createEClass(PORTFOLIO);
        createEReference(portfolioEClass, PORTFOLIO__INSTRUMENTS);

        scoreEClass = createEClass(SCORE);
        createEAttribute(scoreEClass, SCORE__I);
        createEAttribute(scoreEClass, SCORE__L);
        createEAttribute(scoreEClass, SCORE__F);
        createEAttribute(scoreEClass, SCORE__D);

        greeksEClass = createEClass(GREEKS);
        createEAttribute(greeksEClass, GREEKS__PRICE);
        createEAttribute(greeksEClass, GREEKS__DELTA);
        createEAttribute(greeksEClass, GREEKS__GAMMA);
        createEAttribute(greeksEClass, GREEKS__VEGA);
        createEAttribute(greeksEClass, GREEKS__THETA);
        createEAttribute(greeksEClass, GREEKS__RHO);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
                .getEPackage(XMLTypePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(instrumentEClass, Instrument.class, "Instrument",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getInstrument_Id(), theXMLTypePackage.getInt(), "id",
                null, 0, 1, Instrument.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getInstrument_Symbol(), theXMLTypePackage.getString(),
                "symbol", null, 0, 1, Instrument.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getInstrument_Scores(), this.getScore(), null, "scores",
                null, 0, -1, Instrument.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInstrument_Greeks(), this.getGreeks(), null,
                "greeks", null, 0, 1, Instrument.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInstrument_UnderPrice(),
                theXMLTypePackage.getDouble(), "underPrice", null, 0, 1,
                Instrument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(portfolioEClass, Portfolio.class, "Portfolio", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPortfolio_Instruments(), this.getInstrument(), null,
                "instruments", null, 0, -1, Portfolio.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(scoreEClass, Score.class, "Score", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getScore_I(), theXMLTypePackage.getInt(), "i", null, 0,
                1, Score.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScore_L(), theXMLTypePackage.getLong(), "l", null, 0,
                1, Score.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScore_F(), theXMLTypePackage.getFloat(), "f", null,
                0, 1, Score.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getScore_D(), theXMLTypePackage.getDouble(), "d", null,
                0, 1, Score.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(greeksEClass, Greeks.class, "Greeks", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGreeks_Price(), theXMLTypePackage.getDouble(),
                "price", null, 0, 1, Greeks.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGreeks_Delta(), theXMLTypePackage.getDouble(),
                "delta", null, 0, 1, Greeks.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGreeks_Gamma(), theXMLTypePackage.getDouble(),
                "gamma", null, 0, 1, Greeks.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGreeks_Vega(), theXMLTypePackage.getDouble(), "vega",
                null, 0, 1, Greeks.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGreeks_Theta(), theXMLTypePackage.getDouble(),
                "theta", null, 0, 1, Greeks.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGreeks_Rho(), theXMLTypePackage.getDouble(), "rho",
                null, 0, 1, Greeks.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // InstrumentPackageImpl
