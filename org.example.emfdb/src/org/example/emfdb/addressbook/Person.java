/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.addressbook;

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link org.example.emfdb.addressbook.Person#getPhoneNumbers <em>Phone Numbers</em>}</li>
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
	 * Returns the value of the '<em><b>Phone Numbers</b></em>' containment reference list.
	 * The list contents are of type {@link org.example.emfdb.addressbook.PhoneNumber}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone Numbers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone Numbers</em>' containment reference list.
	 * @see org.example.emfdb.addressbook.AddressbookPackage#getPerson_PhoneNumbers()
	 * @model containment="true"
	 * @generated
	 */
	EList<PhoneNumber> getPhoneNumbers();

} // Person
