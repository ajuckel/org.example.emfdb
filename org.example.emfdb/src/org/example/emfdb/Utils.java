package org.example.emfdb;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.example.emfdb.addressbook.AddressbookFactory;
import org.example.emfdb.addressbook.AddressbookPackage;
import org.example.emfdb.addressbook.Person;
import org.example.emfdb.addressbook.PhoneNumber;

public class Utils {
	public static List<Person> createPeople(int count, boolean includePhoneNumber) {
		List<Person> people = new ArrayList<Person>(count);
		for (int i = 0; i < count; i++) {
			Person p = AddressbookFactory.eINSTANCE.createPerson();
			p.setFirstName(Double.toString(Math.random()));
			p.setLastName(Double.toString(Math.random()));
			PhoneNumber number = AddressbookFactory.eINSTANCE
					.createPhoneNumber();
			number.setNumber(Double.toString(Math.random()));
			p.getPhoneNumbers().add(number);
			p.setGarbage(AddressbookFactory.eINSTANCE
					.createGarbage());
			people.add(p);
		}
		return people;		
	}

	public static IObservableMap[] createEMFObservableMapsWithIntermediate(IObservableSet set) {
		IObservableMap garbageMap = EMFProperties.value(AddressbookPackage.Literals.PERSON__GARBAGE)
			.observeDetail(set);
		return new IObservableMap[] {
			EMFProperties.value(AddressbookPackage.Literals.PERSON__FIRST_NAME)
				.observeDetail(set),
			EMFProperties.value(AddressbookPackage.Literals.PERSON__LAST_NAME)
				.observeDetail(set),
			EMFProperties.value(AddressbookPackage.Literals.PERSON__TEMPERATURE)
				.observeDetail(set),
			EMFProperties.value(AddressbookPackage.Literals.GARBAGE__A1)
				.observeDetail(garbageMap),
			EMFProperties.value(AddressbookPackage.Literals.GARBAGE__A2)
				.observeDetail(garbageMap),
			EMFProperties.value(AddressbookPackage.Literals.GARBAGE__A3)
				.observeDetail(garbageMap),
			EMFProperties.value(AddressbookPackage.Literals.GARBAGE__A4)
				.observeDetail(garbageMap),
			EMFProperties.value(AddressbookPackage.Literals.GARBAGE__A5)
				.observeDetail(garbageMap),
			EMFProperties.value(AddressbookPackage.Literals.GARBAGE__A6)
				.observeDetail(garbageMap),
			EMFProperties.value(AddressbookPackage.Literals.GARBAGE__A7)
				.observeDetail(garbageMap),
			EMFProperties.value(AddressbookPackage.Literals.GARBAGE__A8)
				.observeDetail(garbageMap),
			EMFProperties.value(AddressbookPackage.Literals.GARBAGE__A9)
				.observeDetail(garbageMap)
		};
	}

	public static IObservableMap[] createEMFObservableMaps(IObservableSet set) {
		return new IObservableMap[] {
			EMFProperties.value(AddressbookPackage.Literals.PERSON__FIRST_NAME)
				.observeDetail(set),
			EMFProperties.value(AddressbookPackage.Literals.PERSON__LAST_NAME)
				.observeDetail(set),
			EMFProperties.value(AddressbookPackage.Literals.PERSON__TEMPERATURE)
				.observeDetail(set),
			EMFProperties.value(FeaturePath.fromList(
					AddressbookPackage.Literals.PERSON__GARBAGE,
					AddressbookPackage.Literals.GARBAGE__A1))
				.observeDetail(set),
			EMFProperties.value(FeaturePath.fromList(
					AddressbookPackage.Literals.PERSON__GARBAGE,
					AddressbookPackage.Literals.GARBAGE__A2))
				.observeDetail(set),
			EMFProperties.value(FeaturePath.fromList(
					AddressbookPackage.Literals.PERSON__GARBAGE,
					AddressbookPackage.Literals.GARBAGE__A3))
				.observeDetail(set),
			EMFProperties.value(FeaturePath.fromList(
					AddressbookPackage.Literals.PERSON__GARBAGE,
					AddressbookPackage.Literals.GARBAGE__A4))
				.observeDetail(set),
			EMFProperties.value(FeaturePath.fromList(
					AddressbookPackage.Literals.PERSON__GARBAGE,
					AddressbookPackage.Literals.GARBAGE__A5))
				.observeDetail(set),
			EMFProperties.value(FeaturePath.fromList(
					AddressbookPackage.Literals.PERSON__GARBAGE,
					AddressbookPackage.Literals.GARBAGE__A6))
				.observeDetail(set),
			EMFProperties.value(FeaturePath.fromList(
					AddressbookPackage.Literals.PERSON__GARBAGE,
					AddressbookPackage.Literals.GARBAGE__A7))
				.observeDetail(set),
			EMFProperties.value(FeaturePath.fromList(
					AddressbookPackage.Literals.PERSON__GARBAGE,
					AddressbookPackage.Literals.GARBAGE__A8))
				.observeDetail(set),
			EMFProperties.value(FeaturePath.fromList(
					AddressbookPackage.Literals.PERSON__GARBAGE,
					AddressbookPackage.Literals.GARBAGE__A9))
				.observeDetail(set),
		};
	}
}
