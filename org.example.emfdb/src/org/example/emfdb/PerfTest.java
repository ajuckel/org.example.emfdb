package org.example.emfdb;

import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ListToSetAdapter;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Display;
import org.example.emfdb.addressbook.AddressBook;
import org.example.emfdb.addressbook.AddressbookFactory;
import org.example.emfdb.addressbook.AddressbookPackage;
import org.example.emfdb.addressbook.Person;

public class PerfTest implements IApplication {

	public Object start(final IApplicationContext context) throws Exception {
		Display display = new Display();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				List<Person> people = Utils.createPeople(10000, true);
				AddressBook ab = AddressbookFactory.eINSTANCE
						.createAddressBook();
				IObservableList list = EMFProperties.list(
						AddressbookPackage.Literals.ADDRESS_BOOK__PEOPLE)
						.observe(ab);
				IObservableSet set = new ListToSetAdapter(list);

				IObservableMap[] maps = Utils
						.createEMFObservableMapsWithIntermediate(set);
				// In order for the maps to do something interesting when the
				// underlying data changes, we have to wire up at least one
				// listener.
				IMapChangeListener listener = new IMapChangeListener() {
					public void handleMapChange(MapChangeEvent event) {
						// I don't want to actually do anything as a result of a
						// change.
					}
				};
				for (IObservableMap map : maps) {
					map.addMapChangeListener(listener);
				}

				// Here's the expensive bit. As a result of this, the
				// databinding layer is going to allocate and wire listeners for
				// the newly added people and the properties we've indicated we
				// want bound to the UI.
				ab.getPeople().addAll(people);
			}
		});
		return Integer.valueOf(0);
	}

	public void stop() {
		// TODO Auto-generated method stub

	}

}
