/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.addressbook.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.example.emfdb.addressbook.AddressbookFactory;
import org.example.emfdb.addressbook.PhoneNumber;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Phone Number</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PhoneNumberTest extends TestCase {

	/**
	 * The fixture for this Phone Number test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhoneNumber fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PhoneNumberTest.class);
	}

	/**
	 * Constructs a new Phone Number test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhoneNumberTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Phone Number test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PhoneNumber fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Phone Number test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhoneNumber getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AddressbookFactory.eINSTANCE.createPhoneNumber());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //PhoneNumberTest
