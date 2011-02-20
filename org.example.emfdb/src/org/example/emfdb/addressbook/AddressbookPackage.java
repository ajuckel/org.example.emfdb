/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.addressbook;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.example.emfdb.addressbook.AddressbookFactory
 * @model kind="package"
 * @generated
 */
public interface AddressbookPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "addressbook";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://example.org/addressbook";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ab";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AddressbookPackage eINSTANCE = org.example.emfdb.addressbook.impl.AddressbookPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.example.emfdb.addressbook.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.emfdb.addressbook.impl.PersonImpl
	 * @see org.example.emfdb.addressbook.impl.AddressbookPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LAST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Phone Numbers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PHONE_NUMBERS = 2;

	/**
	 * The feature id for the '<em><b>Scores</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SCORES = 3;

	/**
	 * The feature id for the '<em><b>Temperature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__TEMPERATURE = 4;

	/**
	 * The feature id for the '<em><b>Garbage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__GARBAGE = 5;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.example.emfdb.addressbook.impl.PhoneNumberImpl <em>Phone Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.emfdb.addressbook.impl.PhoneNumberImpl
	 * @see org.example.emfdb.addressbook.impl.AddressbookPackageImpl#getPhoneNumber()
	 * @generated
	 */
	int PHONE_NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHONE_NUMBER__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHONE_NUMBER__PRIORITY = 1;

	/**
	 * The number of structural features of the '<em>Phone Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHONE_NUMBER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.example.emfdb.addressbook.impl.AddressBookImpl <em>Address Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.emfdb.addressbook.impl.AddressBookImpl
	 * @see org.example.emfdb.addressbook.impl.AddressbookPackageImpl#getAddressBook()
	 * @generated
	 */
	int ADDRESS_BOOK = 2;

	/**
	 * The feature id for the '<em><b>People</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_BOOK__PEOPLE = 0;

	/**
	 * The number of structural features of the '<em>Address Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_BOOK_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.example.emfdb.addressbook.impl.ScoreImpl <em>Score</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.emfdb.addressbook.impl.ScoreImpl
	 * @see org.example.emfdb.addressbook.impl.AddressbookPackageImpl#getScore()
	 * @generated
	 */
	int SCORE = 3;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__I = 0;

	/**
	 * The feature id for the '<em><b>L</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__L = 1;

	/**
	 * The feature id for the '<em><b>F</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__F = 2;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__D = 3;

	/**
	 * The number of structural features of the '<em>Score</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_FEATURE_COUNT = 4;


	/**
	 * The meta object id for the '{@link org.example.emfdb.addressbook.impl.GarbageImpl <em>Garbage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.emfdb.addressbook.impl.GarbageImpl
	 * @see org.example.emfdb.addressbook.impl.AddressbookPackageImpl#getGarbage()
	 * @generated
	 */
	int GARBAGE = 4;

	/**
	 * The feature id for the '<em><b>A1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARBAGE__A1 = 0;

	/**
	 * The feature id for the '<em><b>A2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARBAGE__A2 = 1;

	/**
	 * The feature id for the '<em><b>A3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARBAGE__A3 = 2;

	/**
	 * The feature id for the '<em><b>A4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARBAGE__A4 = 3;

	/**
	 * The feature id for the '<em><b>A5</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARBAGE__A5 = 4;

	/**
	 * The feature id for the '<em><b>A6</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARBAGE__A6 = 5;

	/**
	 * The feature id for the '<em><b>A7</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARBAGE__A7 = 6;

	/**
	 * The feature id for the '<em><b>A8</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARBAGE__A8 = 7;

	/**
	 * The feature id for the '<em><b>A9</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARBAGE__A9 = 8;

	/**
	 * The number of structural features of the '<em>Garbage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GARBAGE_FEATURE_COUNT = 9;


	/**
	 * Returns the meta object for class '{@link org.example.emfdb.addressbook.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see org.example.emfdb.addressbook.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Person#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.example.emfdb.addressbook.Person#getFirstName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Person#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.example.emfdb.addressbook.Person#getLastName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_LastName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.example.emfdb.addressbook.Person#getPhoneNumbers <em>Phone Numbers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Phone Numbers</em>'.
	 * @see org.example.emfdb.addressbook.Person#getPhoneNumbers()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_PhoneNumbers();

	/**
	 * Returns the meta object for the reference list '{@link org.example.emfdb.addressbook.Person#getScores <em>Scores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scores</em>'.
	 * @see org.example.emfdb.addressbook.Person#getScores()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Scores();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Person#getTemperature <em>Temperature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temperature</em>'.
	 * @see org.example.emfdb.addressbook.Person#getTemperature()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Temperature();

	/**
	 * Returns the meta object for the reference '{@link org.example.emfdb.addressbook.Person#getGarbage <em>Garbage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Garbage</em>'.
	 * @see org.example.emfdb.addressbook.Person#getGarbage()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Garbage();

	/**
	 * Returns the meta object for class '{@link org.example.emfdb.addressbook.PhoneNumber <em>Phone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Phone Number</em>'.
	 * @see org.example.emfdb.addressbook.PhoneNumber
	 * @generated
	 */
	EClass getPhoneNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.PhoneNumber#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see org.example.emfdb.addressbook.PhoneNumber#getNumber()
	 * @see #getPhoneNumber()
	 * @generated
	 */
	EAttribute getPhoneNumber_Number();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.PhoneNumber#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.example.emfdb.addressbook.PhoneNumber#getPriority()
	 * @see #getPhoneNumber()
	 * @generated
	 */
	EAttribute getPhoneNumber_Priority();

	/**
	 * Returns the meta object for class '{@link org.example.emfdb.addressbook.AddressBook <em>Address Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Book</em>'.
	 * @see org.example.emfdb.addressbook.AddressBook
	 * @generated
	 */
	EClass getAddressBook();

	/**
	 * Returns the meta object for the containment reference list '{@link org.example.emfdb.addressbook.AddressBook#getPeople <em>People</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>People</em>'.
	 * @see org.example.emfdb.addressbook.AddressBook#getPeople()
	 * @see #getAddressBook()
	 * @generated
	 */
	EReference getAddressBook_People();

	/**
	 * Returns the meta object for class '{@link org.example.emfdb.addressbook.Score <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Score</em>'.
	 * @see org.example.emfdb.addressbook.Score
	 * @generated
	 */
	EClass getScore();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Score#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>I</em>'.
	 * @see org.example.emfdb.addressbook.Score#getI()
	 * @see #getScore()
	 * @generated
	 */
	EAttribute getScore_I();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Score#getL <em>L</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L</em>'.
	 * @see org.example.emfdb.addressbook.Score#getL()
	 * @see #getScore()
	 * @generated
	 */
	EAttribute getScore_L();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Score#getF <em>F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>F</em>'.
	 * @see org.example.emfdb.addressbook.Score#getF()
	 * @see #getScore()
	 * @generated
	 */
	EAttribute getScore_F();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Score#getD <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>D</em>'.
	 * @see org.example.emfdb.addressbook.Score#getD()
	 * @see #getScore()
	 * @generated
	 */
	EAttribute getScore_D();

	/**
	 * Returns the meta object for class '{@link org.example.emfdb.addressbook.Garbage <em>Garbage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Garbage</em>'.
	 * @see org.example.emfdb.addressbook.Garbage
	 * @generated
	 */
	EClass getGarbage();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Garbage#getA1 <em>A1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A1</em>'.
	 * @see org.example.emfdb.addressbook.Garbage#getA1()
	 * @see #getGarbage()
	 * @generated
	 */
	EAttribute getGarbage_A1();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Garbage#getA2 <em>A2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A2</em>'.
	 * @see org.example.emfdb.addressbook.Garbage#getA2()
	 * @see #getGarbage()
	 * @generated
	 */
	EAttribute getGarbage_A2();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Garbage#getA3 <em>A3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A3</em>'.
	 * @see org.example.emfdb.addressbook.Garbage#getA3()
	 * @see #getGarbage()
	 * @generated
	 */
	EAttribute getGarbage_A3();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Garbage#getA4 <em>A4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A4</em>'.
	 * @see org.example.emfdb.addressbook.Garbage#getA4()
	 * @see #getGarbage()
	 * @generated
	 */
	EAttribute getGarbage_A4();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Garbage#getA5 <em>A5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A5</em>'.
	 * @see org.example.emfdb.addressbook.Garbage#getA5()
	 * @see #getGarbage()
	 * @generated
	 */
	EAttribute getGarbage_A5();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Garbage#getA6 <em>A6</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A6</em>'.
	 * @see org.example.emfdb.addressbook.Garbage#getA6()
	 * @see #getGarbage()
	 * @generated
	 */
	EAttribute getGarbage_A6();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Garbage#getA7 <em>A7</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A7</em>'.
	 * @see org.example.emfdb.addressbook.Garbage#getA7()
	 * @see #getGarbage()
	 * @generated
	 */
	EAttribute getGarbage_A7();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Garbage#getA8 <em>A8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A8</em>'.
	 * @see org.example.emfdb.addressbook.Garbage#getA8()
	 * @see #getGarbage()
	 * @generated
	 */
	EAttribute getGarbage_A8();

	/**
	 * Returns the meta object for the attribute '{@link org.example.emfdb.addressbook.Garbage#getA9 <em>A9</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A9</em>'.
	 * @see org.example.emfdb.addressbook.Garbage#getA9()
	 * @see #getGarbage()
	 * @generated
	 */
	EAttribute getGarbage_A9();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AddressbookFactory getAddressbookFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.example.emfdb.addressbook.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.emfdb.addressbook.impl.PersonImpl
		 * @see org.example.emfdb.addressbook.impl.AddressbookPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__FIRST_NAME = eINSTANCE.getPerson_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__LAST_NAME = eINSTANCE.getPerson_LastName();

		/**
		 * The meta object literal for the '<em><b>Phone Numbers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__PHONE_NUMBERS = eINSTANCE.getPerson_PhoneNumbers();

		/**
		 * The meta object literal for the '<em><b>Scores</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__SCORES = eINSTANCE.getPerson_Scores();

		/**
		 * The meta object literal for the '<em><b>Temperature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__TEMPERATURE = eINSTANCE.getPerson_Temperature();

		/**
		 * The meta object literal for the '<em><b>Garbage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__GARBAGE = eINSTANCE.getPerson_Garbage();

		/**
		 * The meta object literal for the '{@link org.example.emfdb.addressbook.impl.PhoneNumberImpl <em>Phone Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.emfdb.addressbook.impl.PhoneNumberImpl
		 * @see org.example.emfdb.addressbook.impl.AddressbookPackageImpl#getPhoneNumber()
		 * @generated
		 */
		EClass PHONE_NUMBER = eINSTANCE.getPhoneNumber();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHONE_NUMBER__NUMBER = eINSTANCE.getPhoneNumber_Number();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHONE_NUMBER__PRIORITY = eINSTANCE.getPhoneNumber_Priority();

		/**
		 * The meta object literal for the '{@link org.example.emfdb.addressbook.impl.AddressBookImpl <em>Address Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.emfdb.addressbook.impl.AddressBookImpl
		 * @see org.example.emfdb.addressbook.impl.AddressbookPackageImpl#getAddressBook()
		 * @generated
		 */
		EClass ADDRESS_BOOK = eINSTANCE.getAddressBook();

		/**
		 * The meta object literal for the '<em><b>People</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDRESS_BOOK__PEOPLE = eINSTANCE.getAddressBook_People();

		/**
		 * The meta object literal for the '{@link org.example.emfdb.addressbook.impl.ScoreImpl <em>Score</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.emfdb.addressbook.impl.ScoreImpl
		 * @see org.example.emfdb.addressbook.impl.AddressbookPackageImpl#getScore()
		 * @generated
		 */
		EClass SCORE = eINSTANCE.getScore();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE__I = eINSTANCE.getScore_I();

		/**
		 * The meta object literal for the '<em><b>L</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE__L = eINSTANCE.getScore_L();

		/**
		 * The meta object literal for the '<em><b>F</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE__F = eINSTANCE.getScore_F();

		/**
		 * The meta object literal for the '<em><b>D</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE__D = eINSTANCE.getScore_D();

		/**
		 * The meta object literal for the '{@link org.example.emfdb.addressbook.impl.GarbageImpl <em>Garbage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.emfdb.addressbook.impl.GarbageImpl
		 * @see org.example.emfdb.addressbook.impl.AddressbookPackageImpl#getGarbage()
		 * @generated
		 */
		EClass GARBAGE = eINSTANCE.getGarbage();

		/**
		 * The meta object literal for the '<em><b>A1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GARBAGE__A1 = eINSTANCE.getGarbage_A1();

		/**
		 * The meta object literal for the '<em><b>A2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GARBAGE__A2 = eINSTANCE.getGarbage_A2();

		/**
		 * The meta object literal for the '<em><b>A3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GARBAGE__A3 = eINSTANCE.getGarbage_A3();

		/**
		 * The meta object literal for the '<em><b>A4</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GARBAGE__A4 = eINSTANCE.getGarbage_A4();

		/**
		 * The meta object literal for the '<em><b>A5</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GARBAGE__A5 = eINSTANCE.getGarbage_A5();

		/**
		 * The meta object literal for the '<em><b>A6</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GARBAGE__A6 = eINSTANCE.getGarbage_A6();

		/**
		 * The meta object literal for the '<em><b>A7</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GARBAGE__A7 = eINSTANCE.getGarbage_A7();

		/**
		 * The meta object literal for the '<em><b>A8</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GARBAGE__A8 = eINSTANCE.getGarbage_A8();

		/**
		 * The meta object literal for the '<em><b>A9</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GARBAGE__A9 = eINSTANCE.getGarbage_A9();

	}

} //AddressbookPackage
