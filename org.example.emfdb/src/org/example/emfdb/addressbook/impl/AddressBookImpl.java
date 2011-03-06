/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.addressbook.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.example.emfdb.addressbook.AddressBook;
import org.example.emfdb.addressbook.AddressbookPackage;
import org.example.emfdb.addressbook.Person;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Address Book</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.example.emfdb.addressbook.impl.AddressBookImpl#getPeople <em>
 * People</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AddressBookImpl extends EObjectImpl implements AddressBook {
    /**
     * The cached value of the '{@link #getPeople() <em>People</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPeople()
     * @generated
     * @ordered
     */
    protected EList<Person> people;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AddressBookImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AddressbookPackage.Literals.ADDRESS_BOOK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Person> getPeople() {
        if (people == null) {
            people = new EObjectContainmentEList<Person>(Person.class, this,
                    AddressbookPackage.ADDRESS_BOOK__PEOPLE);
        }
        return people;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd,
            int featureID, NotificationChain msgs) {
        switch (featureID) {
        case AddressbookPackage.ADDRESS_BOOK__PEOPLE:
            return ((InternalEList<?>) getPeople()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case AddressbookPackage.ADDRESS_BOOK__PEOPLE:
            return getPeople();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case AddressbookPackage.ADDRESS_BOOK__PEOPLE:
            getPeople().clear();
            getPeople().addAll((Collection<? extends Person>) newValue);
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
        case AddressbookPackage.ADDRESS_BOOK__PEOPLE:
            getPeople().clear();
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
        case AddressbookPackage.ADDRESS_BOOK__PEOPLE:
            return people != null && !people.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    @SuppressWarnings("serial")
    public void useIdentityEqualsList() {
        people = new EObjectContainmentEList<Person>(Person.class, this,
                AddressbookPackage.ADDRESS_BOOK__PEOPLE) {
            @Override
            public boolean equals(Object object) {
                return this == object;
            }
        };
    }

} // AddressBookImpl
