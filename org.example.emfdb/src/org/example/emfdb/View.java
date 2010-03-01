package org.example.emfdb;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import org.example.emfdb.addressbook.AddressBook;
import org.example.emfdb.addressbook.AddressbookFactory;
import org.example.emfdb.addressbook.AddressbookPackage;
import org.example.emfdb.addressbook.Person;
import org.example.emfdb.addressbook.PhoneNumber;

public class View extends ViewPart {
	public static final String ID = "org.example.emfdb.view";

	private final AddressBook ab = AddressbookFactory.eINSTANCE.createAddressBook();

	private TableViewer viewer;
	private ObservableListContentProvider obListContentProvider;
	private boolean usingSwtVirtual = false;
	private Composite parent = null;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		this.parent = parent;

		obListContentProvider = new ObservableListContentProvider();
		viewer = initViewer();
		
		this.getViewSite().getActionBars().getMenuManager().add(new Action("Toggle Virtual", IAction.AS_CHECK_BOX) {
			
			@Override
			public void run() {
				usingSwtVirtual = ! usingSwtVirtual;
				this.setChecked(usingSwtVirtual);
				
				disposeViewer(viewer);
				ab.getPeople().clear();
				obListContentProvider = new ObservableListContentProvider();
				viewer = initViewer();
				viewer.getControl().setVisible(true);
				viewer.getControl().update();
			}
		});
		this.getViewSite().getActionBars().getMenuManager().add(new Action("Clear List") {
			@Override
			public void run() {
				ab.getPeople().clear();
			}
		});
		this.getViewSite().getActionBars().getMenuManager().add(new Action("Remove Number Col") {
			@Override
			public void run() {
				removeNumberColumn(viewer, obListContentProvider.getKnownElements());
			}
		});
		this.getViewSite().getActionBars().getMenuManager().add(new Action("Add Number Col") {
			@Override
			public void run() {
				addNumberColumn(viewer, obListContentProvider.getKnownElements());
				viewer.refresh();
			}
		});
		for( final int count : new int[] { 100, 1000, 10000 } ) {
			this.getViewSite().getActionBars().getMenuManager().add(new Action(String.format("%d Non-null", count)) {
				@Override
				public void run() {
					List<Person> people = createPeople(count, true);
					ab.getPeople().addAll(people);
				}
			});
			this.getViewSite().getActionBars().getMenuManager().add(new Action(String.format("%d Null numbers", count)) {
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

	private TableViewer initViewer() {
		int style = SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL;
		if( this.usingSwtVirtual ) style |= SWT.VIRTUAL;
		viewer = new TableViewer(this.parent, style);
		viewer.setContentProvider(obListContentProvider);
		createColumns(viewer, obListContentProvider.getKnownElements());
		
		viewer.setInput(EMFProperties.list(AddressbookPackage.Literals.ADDRESS_BOOK__PEOPLE)
				.observe(ab));
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);

		return viewer;
	}
	
	private void disposeViewer(TableViewer viewer) {
		for( TableColumn col : viewer.getTable().getColumns() ) {
			col.dispose();
		}
		viewer.setInput(null);
		viewer.getControl().dispose();
	}

	private void createColumns(TableViewer viewer, IObservableSet set) {
		IObservableMap map = EMFProperties.value(AddressbookPackage.Literals.PERSON__FIRST_NAME)
			.observeDetail(set); 
		TableViewerColumn tvc = new TableViewerColumn(viewer, SWT.LEFT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
		tvc.getColumn().setText("First Name");
		tvc.getColumn().addSelectionListener(new GenericPropertyColumnSorter(viewer, map));
		tvc.getColumn().pack();
		
		map = EMFProperties.value(AddressbookPackage.Literals.PERSON__LAST_NAME)
			.observeDetail(set);
		tvc = new TableViewerColumn(viewer, SWT.LEFT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
		tvc.getColumn().setText("Last Name");
		tvc.getColumn().addSelectionListener(new GenericPropertyColumnSorter(viewer, map));
		tvc.getColumn().pack();
		
		this.addNumberColumn(viewer, set);
	}
	
	private void addNumberColumn(TableViewer viewer, IObservableSet set) {
		TableViewerColumn tvc = new TableViewerColumn(viewer, SWT.LEFT);
		IObservableMap map = EMFProperties.value(AddressbookPackage.Literals.PERSON__PHONE_NUMBERS).observeDetail(set);
		// AddressbookPackage.Literals.PHONE_NUMBER__NUMBER)).observeDetail(set);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
		tvc.getColumn().setText("Phone Number");
		tvc.getColumn().addSelectionListener(new GenericPropertyColumnSorter(viewer, map));
		tvc.getColumn().pack();
	}

	private void removeNumberColumn(TableViewer viewer, IObservableSet set) {
		
	}
	
	private List<Person> createPeople(int count, boolean includePhoneNumber) {
		List<Person> people = new ArrayList<Person>(count);
		for( int i = 0; i < count; i++ ) {
			Person p = AddressbookFactory.eINSTANCE.createPerson();
			p.setFirstName(Double.toString(Math.random()));
			p.setLastName(Double.toString(Math.random()));
			PhoneNumber number = AddressbookFactory.eINSTANCE.createPhoneNumber();
			number.setNumber(Double.toString(Math.random()));
			p.getPhoneNumbers().add(number);
			people.add(p);
		}
		return people;
	}
}