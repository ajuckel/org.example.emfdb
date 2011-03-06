/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.addressbook.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.example.emfdb.addressbook.AddressBook;
import org.example.emfdb.addressbook.AddressbookFactory;
import org.example.emfdb.addressbook.AddressbookPackage;
import org.example.emfdb.addressbook.Garbage;
import org.example.emfdb.addressbook.Person;
import org.example.emfdb.addressbook.PhoneNumber;
import org.example.emfdb.addressbook.Score;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class AddressbookPackageImpl extends EPackageImpl implements
        AddressbookPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass personEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass phoneNumberEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass addressBookEClass = null;

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
    private EClass garbageEClass = null;

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
     * @see org.example.emfdb.addressbook.AddressbookPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private AddressbookPackageImpl() {
        super(eNS_URI, AddressbookFactory.eINSTANCE);
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
     * This method is used to initialize {@link AddressbookPackage#eINSTANCE}
     * when that field is accessed. Clients should not invoke it directly.
     * Instead, they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static AddressbookPackage init() {
        if (isInited)
            return (AddressbookPackage) EPackage.Registry.INSTANCE
                    .getEPackage(AddressbookPackage.eNS_URI);

        // Obtain or create and register package
        AddressbookPackageImpl theAddressbookPackage = (AddressbookPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof AddressbookPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI) : new AddressbookPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theAddressbookPackage.createPackageContents();

        // Initialize created meta-data
        theAddressbookPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theAddressbookPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(AddressbookPackage.eNS_URI,
                theAddressbookPackage);
        return theAddressbookPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPerson() {
        return personEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPerson_FirstName() {
        return (EAttribute) personEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPerson_LastName() {
        return (EAttribute) personEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPerson_PhoneNumbers() {
        return (EReference) personEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPerson_Scores() {
        return (EReference) personEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPerson_Temperature() {
        return (EAttribute) personEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPerson_Garbage() {
        return (EReference) personEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPhoneNumber() {
        return phoneNumberEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPhoneNumber_Number() {
        return (EAttribute) phoneNumberEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPhoneNumber_Priority() {
        return (EAttribute) phoneNumberEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getAddressBook() {
        return addressBookEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getAddressBook_People() {
        return (EReference) addressBookEClass.getEStructuralFeatures().get(0);
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
    public EClass getGarbage() {
        return garbageEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGarbage_A1() {
        return (EAttribute) garbageEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGarbage_A2() {
        return (EAttribute) garbageEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGarbage_A3() {
        return (EAttribute) garbageEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGarbage_A4() {
        return (EAttribute) garbageEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGarbage_A5() {
        return (EAttribute) garbageEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGarbage_A6() {
        return (EAttribute) garbageEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGarbage_A7() {
        return (EAttribute) garbageEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGarbage_A8() {
        return (EAttribute) garbageEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getGarbage_A9() {
        return (EAttribute) garbageEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AddressbookFactory getAddressbookFactory() {
        return (AddressbookFactory) getEFactoryInstance();
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
        personEClass = createEClass(PERSON);
        createEAttribute(personEClass, PERSON__FIRST_NAME);
        createEAttribute(personEClass, PERSON__LAST_NAME);
        createEReference(personEClass, PERSON__PHONE_NUMBERS);
        createEReference(personEClass, PERSON__SCORES);
        createEAttribute(personEClass, PERSON__TEMPERATURE);
        createEReference(personEClass, PERSON__GARBAGE);

        phoneNumberEClass = createEClass(PHONE_NUMBER);
        createEAttribute(phoneNumberEClass, PHONE_NUMBER__NUMBER);
        createEAttribute(phoneNumberEClass, PHONE_NUMBER__PRIORITY);

        addressBookEClass = createEClass(ADDRESS_BOOK);
        createEReference(addressBookEClass, ADDRESS_BOOK__PEOPLE);

        scoreEClass = createEClass(SCORE);
        createEAttribute(scoreEClass, SCORE__I);
        createEAttribute(scoreEClass, SCORE__L);
        createEAttribute(scoreEClass, SCORE__F);
        createEAttribute(scoreEClass, SCORE__D);

        garbageEClass = createEClass(GARBAGE);
        createEAttribute(garbageEClass, GARBAGE__A1);
        createEAttribute(garbageEClass, GARBAGE__A2);
        createEAttribute(garbageEClass, GARBAGE__A3);
        createEAttribute(garbageEClass, GARBAGE__A4);
        createEAttribute(garbageEClass, GARBAGE__A5);
        createEAttribute(garbageEClass, GARBAGE__A6);
        createEAttribute(garbageEClass, GARBAGE__A7);
        createEAttribute(garbageEClass, GARBAGE__A8);
        createEAttribute(garbageEClass, GARBAGE__A9);
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
        initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPerson_FirstName(), theXMLTypePackage.getString(),
                "firstName", null, 0, 1, Person.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPerson_LastName(), theXMLTypePackage.getString(),
                "lastName", null, 0, 1, Person.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getPerson_PhoneNumbers(), this.getPhoneNumber(), null,
                "phoneNumbers", null, 0, -1, Person.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPerson_Scores(), this.getScore(), null, "scores",
                null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPerson_Temperature(), theXMLTypePackage.getDouble(),
                "temperature", null, 0, 1, Person.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getPerson_Garbage(), this.getGarbage(), null, "garbage",
                null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(phoneNumberEClass, PhoneNumber.class, "PhoneNumber",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPhoneNumber_Number(), theXMLTypePackage.getString(),
                "number", null, 0, 1, PhoneNumber.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPhoneNumber_Priority(), theXMLTypePackage.getInt(),
                "priority", null, 0, 1, PhoneNumber.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(addressBookEClass, AddressBook.class, "AddressBook",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAddressBook_People(), this.getPerson(), null,
                "people", null, 0, -1, AddressBook.class, !IS_TRANSIENT,
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

        initEClass(garbageEClass, Garbage.class, "Garbage", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGarbage_A1(), theXMLTypePackage.getString(), "a1",
                null, 0, 1, Garbage.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGarbage_A2(), theXMLTypePackage.getString(), "a2",
                null, 0, 1, Garbage.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGarbage_A3(), theXMLTypePackage.getString(), "a3",
                null, 0, 1, Garbage.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGarbage_A4(), theXMLTypePackage.getString(), "a4",
                null, 0, 1, Garbage.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGarbage_A5(), theXMLTypePackage.getString(), "a5",
                null, 0, 1, Garbage.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGarbage_A6(), theXMLTypePackage.getString(), "a6",
                null, 0, 1, Garbage.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGarbage_A7(), theXMLTypePackage.getString(), "a7",
                null, 0, 1, Garbage.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGarbage_A8(), theXMLTypePackage.getString(), "a8",
                null, 0, 1, Garbage.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getGarbage_A9(), theXMLTypePackage.getString(), "a9",
                null, 0, 1, Garbage.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // AddressbookPackageImpl
