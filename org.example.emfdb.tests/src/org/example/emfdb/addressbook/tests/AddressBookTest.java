/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.addressbook.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.example.emfdb.addressbook.AddressBook;
import org.example.emfdb.addressbook.AddressbookFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Address Book</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AddressBookTest extends TestCase {

	/**
	 * The fixture for this Address Book test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddressBook fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AddressBookTest.class);
	}

	/**
	 * Constructs a new Address Book test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressBookTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Address Book test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AddressBook fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Address Book test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddressBook getFixture() {
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
		setFixture(AddressbookFactory.eINSTANCE.createAddressBook());
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

} //AddressBookTest
