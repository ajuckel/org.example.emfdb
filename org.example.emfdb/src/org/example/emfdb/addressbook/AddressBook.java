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
 * A representation of the model object '<em><b>Address Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.emfdb.addressbook.AddressBook#getPeople <em>People</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.emfdb.addressbook.AddressbookPackage#getAddressBook()
 * @model
 * @generated
 */
public interface AddressBook extends EObject {
	/**
	 * Returns the value of the '<em><b>People</b></em>' containment reference list.
	 * The list contents are of type {@link org.example.emfdb.addressbook.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>People</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>People</em>' containment reference list.
	 * @see org.example.emfdb.addressbook.AddressbookPackage#getAddressBook_People()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getPeople();

} // AddressBook
