package org.example.emfdb;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.example.emfdb.addressbook.AddressBook;
import org.example.emfdb.addressbook.AddressbookFactory;
import org.example.emfdb.addressbook.AddressbookPackage;
import org.example.emfdb.addressbook.Person;
import org.example.emfdb.addressbook.PhoneNumber;

public class View extends ViewPart {
	public static final String ID = "org.example.emfdb.view";

	private TableViewer viewer;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.VIRTUAL);
		ObservableListContentProvider cp = new ObservableListContentProvider();
		viewer.setContentProvider(cp);

		createColumns(viewer, cp.getKnownElements());
		
		final AddressBook ab = AddressbookFactory.eINSTANCE.createAddressBook();
		viewer.setInput(EMFProperties.list(AddressbookPackage.Literals.ADDRESS_BOOK__PEOPLE)
				.observe(ab));
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);
		
		
		this.getViewSite().getActionBars().getMenuManager().add(new Action() {
			@Override
			public String getText() {
				return "Clear List";
			}
			@Override
			public void run() {
				ab.getPeople().clear();
			}
		});
		for( final int count : new int[] { 100, 1000, 10000 } ) {
			this.getViewSite().getActionBars().getMenuManager().add(new Action() {
				@Override
				public String getText() {
					return String.format("%d Non-null", count);
				}
				@Override
				public void run() {
					List<Person> people = createPeople(count, true);
					ab.getPeople().addAll(people);
				}
			});
			this.getViewSite().getActionBars().getMenuManager().add(new Action() {
				@Override
				public String getText() {
					return String.format("%d Null numbers", count);
				}
				@Override
				public void run() {
					List<Person> people = createPeople(count, false);
					ab.getPeople().addAll(people);
				}
			});
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	private void createColumns(TableViewer viewer, IObservableSet set) {
		TableViewerColumn tvc = new TableViewerColumn(viewer, SWT.LEFT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(
				EMFProperties.value(AddressbookPackage.Literals.PERSON__FIRST_NAME)
				.observeDetail(set)));
		tvc.getColumn().setText("First Name");
		tvc.getColumn().pack();
		
		tvc = new TableViewerColumn(viewer, SWT.LEFT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(
				EMFProperties.value(AddressbookPackage.Literals.PERSON__LAST_NAME)
				.observeDetail(set)));
		tvc.getColumn().setText("Last Name");
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.LEFT);
		IObservableMap map = EMFProperties.value(AddressbookPackage.Literals.PERSON__PHONE_NUMBER).observeDetail(set);
		map = EMFProperties.value(AddressbookPackage.Literals.PHONE_NUMBER__NUMBER).observeDetail(map);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
		tvc.getColumn().setText("Phone Number");
		tvc.getColumn().pack();
	}

	private List<Person> createPeople(int count, boolean includePhoneNumber) {
		List<Person> people = new ArrayList<Person>(count);
		for( int i = 0; i < count; i++ ) {
			Person p = AddressbookFactory.eINSTANCE.createPerson();
			p.setFirstName("John");
			p.setLastName("Doe");
			PhoneNumber number = AddressbookFactory.eINSTANCE.createPhoneNumber();
			number.setNumber("(111)222-3333");
			p.setPhoneNumber(includePhoneNumber ? number : null);
			people.add(p);
		}
		return people;
	}
}