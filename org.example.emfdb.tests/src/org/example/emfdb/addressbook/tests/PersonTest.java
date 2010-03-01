/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.addressbook.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.list.IListProperty;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFProperties;
import org.example.emfdb.AggregationProperties;
import org.example.emfdb.addressbook.AddressbookFactory;
import org.example.emfdb.addressbook.AddressbookPackage;
import org.example.emfdb.addressbook.Person;
import org.example.emfdb.addressbook.PhoneNumber;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PersonTest extends TestCase {

	private static final Realm DEFAULT_REALM = new Realm() {
		@Override
		public boolean isCurrent() {
			return true;
		}
	};

	/**
	 * The fixture for this Person test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Person fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PersonTest.class);
	}

	/**
	 * Constructs a new Person test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Person test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Person fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Person test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Person getFixture() {
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
		setFixture(AddressbookFactory.eINSTANCE.createPerson());
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
	
	public void testListToValue() {
		fixture.setFirstName("Foo");
		fixture.setLastName("Bar");

		PhoneNumber number = AddressbookFactory.eINSTANCE.createPhoneNumber();
		number.setNumber("(123)456-7890");
		
		fixture.getPhoneNumbers().add(number);
		
		IListProperty listProp = EMFProperties.list(AddressbookPackage.Literals.PERSON__PHONE_NUMBERS);
		IValueProperty aggrValue = AggregationProperties.count(listProp);
		
		IObservableValue value = aggrValue.observe(DEFAULT_REALM, fixture);
		assertEquals(1, value.getValue());

		final int[] changeCount = new int[] { 0 };
		value.addChangeListener(new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				changeCount[0]++;
			}
		});
		
		assertEquals(0, changeCount[0]);
		PhoneNumber number2 = AddressbookFactory.eINSTANCE.createPhoneNumber();
		number2.setNumber("(111)222-3333");
		fixture.getPhoneNumbers().add(number2);
		assertEquals(2, value.getValue());
		assertEquals(1, changeCount[0]);
	}
} //PersonTest
