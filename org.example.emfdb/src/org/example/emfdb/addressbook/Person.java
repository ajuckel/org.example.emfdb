/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.addressbook;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.emfdb.addressbook.Person#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.example.emfdb.addressbook.Person#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.example.emfdb.addressbook.Person#getPhoneNumber <em>Phone Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.emfdb.addressbook.AddressbookPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.example.emfdb.addressbook.AddressbookPackage#getPerson_FirstName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.example.emfdb.addressbook.Person#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see org.example.emfdb.addressbook.AddressbookPackage#getPerson_LastName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link org.example.emfdb.addressbook.Person#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Phone Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone Number</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone Number</em>' containment reference.
	 * @see #setPhoneNumber(PhoneNumber)
	 * @see org.example.emfdb.addressbook.AddressbookPackage#getPerson_PhoneNumber()
	 * @model containment="true"
	 * @generated
	 */
	PhoneNumber getPhoneNumber();

	/**
	 * Sets the value of the '{@link org.example.emfdb.addressbook.Person#getPhoneNumber <em>Phone Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone Number</em>' containment reference.
	 * @see #getPhoneNumber()
	 * @generated
	 */
	void setPhoneNumber(PhoneNumber value);

} // Person
