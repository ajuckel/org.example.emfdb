package org.example.emfdb;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellNavigationStrategy;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.jface.viewers.TableViewerFocusCellManager;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import org.example.emfdb.addressbook.AddressBook;
import org.example.emfdb.addressbook.AddressbookFactory;
import org.example.emfdb.addressbook.AddressbookPackage;
import org.example.emfdb.addressbook.Person;
import org.example.emfdb.addressbook.PhoneNumber;
import org.example.emfdb.beans.Car;
import org.example.emfdb.beans.Truck;

public class View extends ViewPart {
	public static final String ID = "org.example.emfdb.view";

	private final AddressBook ab = AddressbookFactory.eINSTANCE
			.createAddressBook();

	private TableViewer viewer;
	private ObservableListContentProvider obListContentProvider;
	private boolean usingSwtVirtual = false;
	private Composite parent = null;
	private final TemperatureSource[] providers = new TemperatureSource[10];

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		this.parent = parent;

		obListContentProvider = new ObservableListContentProvider();
		viewer = initViewer();

		this.getViewSite().getActionBars().getMenuManager().add(
				new Action("Toggle Virtual", IAction.AS_CHECK_BOX) {

					@Override
					public void run() {
						usingSwtVirtual = !usingSwtVirtual;
						this.setChecked(usingSwtVirtual);

						disposeViewer(viewer);
						ab.getPeople().clear();
						obListContentProvider = new ObservableListContentProvider();
						viewer = initViewer();
						viewer.getControl().setVisible(true);
						viewer.getControl().update();
					}
				});
		this.getViewSite().getActionBars().getMenuManager().add(
				new Action("Clear List") {
					@Override
					public void run() {
						ab.getPeople().clear();
					}
				});

		for (final int count : new int[] { 100, 1000, 10000 }) {
			this.getViewSite().getActionBars().getMenuManager().add(
					new Action(String.format("%d EObjects Non-null", count)) {
						@Override
						public void run() {
							List<Person> people = createPeople(count, true);
							ab.getPeople().addAll(people);
							for (TableColumn c : viewer.getTable().getColumns()) {
								c.pack();
							}
						}
					});
			this.getViewSite().getActionBars().getMenuManager().add(
					new Action(String.format("%d EObjects Null numbers", count)) {
						@Override
						public void run() {
							List<Person> people = createPeople(count, false);
							ab.getPeople().addAll(people);
							for (TableColumn c : viewer.getTable().getColumns()) {
								c.pack();
							}
						}
					});
			this.getViewSite().getActionBars().getMenuManager().add(
					new Action(String.format("%d Beans", count)) {
						@Override
						public void run() {
							createCars(count);
							for(TableColumn c : viewer.getTable().getColumns()) {
								c.pack();
							}
						}
					});
		}

		this.getViewSite().getActionBars().getMenuManager().add(
				new Action("Bind Temps") {
					@Override
					public void run() {
						for (int i = 0; i < providers.length; i++) {
							providers[i] = new TemperatureSource();
							providers[i].start();
						}
						for (final Person p : ab.getPeople()) {
							int index = (int) (Math.random() * 10);
							providers[index]
									.addPropertyChangeListener(new PropertyChangeListener() {
										public void propertyChange(
												PropertyChangeEvent evt) {
											p.setTemperature(((Double) evt
													.getNewValue())
													.doubleValue());
										}
									});
						}
					}
				});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private TableViewer initViewer() {
		int style = SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION;
		if (this.usingSwtVirtual)
			style |= SWT.VIRTUAL;
		viewer = new TableViewer(this.parent, style);
		viewer.setContentProvider(obListContentProvider);
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);

		setupNavigation(viewer);
		
		return viewer;
	}

	private void setupNavigation(final TableViewer v) {
		CellNavigationStrategy naviStrat = new CellNavigationStrategy() {

			public ViewerCell findSelectedCell(ColumnViewer viewer,
					ViewerCell currentSelectedCell, Event event) {
				ViewerCell cell = super.findSelectedCell(viewer, currentSelectedCell, event);
				
				if( cell != null ) {
					v.getTable().showColumn(v.getTable().getColumn(cell.getColumnIndex()));
				}
				
				return cell;
			}
			
		};
		
		TableViewerFocusCellManager focusCellManager = new TableViewerFocusCellManager(v,new FocusCellOwnerDrawHighlighter(v),naviStrat);
		
		ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(v) {
			protected boolean isEditorActivationEvent(
					ColumnViewerEditorActivationEvent event) {
				return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
						|| event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
						|| (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR)
						|| event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
			}
		};
		
		TableViewerEditor.create(v, focusCellManager, actSupport, ColumnViewerEditor.TABBING_HORIZONTAL
				| ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
				| ColumnViewerEditor.TABBING_VERTICAL | ColumnViewerEditor.KEYBOARD_ACTIVATION);
		
		v.getColumnViewerEditor().addEditorActivationListener(new ColumnViewerEditorActivationListener() {

			public void afterEditorActivated(
					ColumnViewerEditorActivationEvent event) {
				
			}

			public void afterEditorDeactivated(
					ColumnViewerEditorDeactivationEvent event) {
				
			}

			public void beforeEditorActivated(
					ColumnViewerEditorActivationEvent event) {
				ViewerCell cell = (ViewerCell) event.getSource();
				v.getTable().showColumn(v.getTable().getColumn(cell.getColumnIndex()));
			}

			public void beforeEditorDeactivated(
					ColumnViewerEditorDeactivationEvent event) {
				
			}
			
		});
	}

	private void disposeViewer(TableViewer viewer) {
		for (TableColumn col : viewer.getTable().getColumns()) {
			col.dispose();
		}
		viewer.setInput(null);
		viewer.getControl().dispose();
	}

	private class MapEditingSupport extends EditingSupport {
		private CellEditor editor;
		private IObservableMap map;
		
		public MapEditingSupport(ColumnViewer viewer, IObservableMap map) {
			this(viewer, map, new TextCellEditor((Composite)viewer.getControl()));
		}

		public MapEditingSupport(ColumnViewer viewer, IObservableMap map, CellEditor editor) {
			super(viewer);
			this.editor = editor;
			this.map = map;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return editor;
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected Object getValue(Object element) {
			return map.get(element);
		}

		@Override
		protected void setValue(Object element, Object value) {
		}
		
	}
	private void createEMFColumns(final TableViewer viewer, final IObservableSet set) {
		clearColumns(viewer);
		IObservableMap map = EMFProperties.value(
				AddressbookPackage.Literals.PERSON__FIRST_NAME).observeDetail(
				set);
		TableViewerColumn tvc = new TableViewerColumn(viewer, SWT.LEFT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
		tvc.getColumn().setText("First Name");
		tvc.getColumn().addSelectionListener(
				new GenericPropertyColumnSorter(viewer, map));
		tvc.setEditingSupport(new MapEditingSupport(viewer, map));
		tvc.getColumn().pack();

		map = EMFProperties
				.value(AddressbookPackage.Literals.PERSON__LAST_NAME)
				.observeDetail(set);
		tvc = new TableViewerColumn(viewer, SWT.LEFT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
		tvc.getColumn().setText("Last Name");
		tvc.getColumn().addSelectionListener(
				new GenericPropertyColumnSorter(viewer, map));
		tvc.setEditingSupport(new MapEditingSupport(viewer, map));
		tvc.getColumn().pack();

		map = EMFProperties.value(
				AddressbookPackage.Literals.PERSON__TEMPERATURE).observeDetail(
				set);
		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new DelayedLabelProvider(map, 2000));
		tvc.getColumn().setText("Temp");
		tvc.getColumn().pack();
	}

	private void createJavaBeanColumns(TableViewer viewer, IObservableSet set) {
		clearColumns(viewer);
		IObservableMap map = BeanProperties.value("make", String.class)
			.observeDetail(set);
		TableViewerColumn tvc = new TableViewerColumn(viewer, SWT.LEFT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
		tvc.getColumn().setText("Make");
		tvc.getColumn().addSelectionListener(
				new GenericPropertyColumnSorter(viewer, map));
		tvc.getColumn().pack();

		map = BeanProperties.value("model", String.class)
				.observeDetail(set);
		tvc = new TableViewerColumn(viewer, SWT.LEFT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
		tvc.getColumn().setText("Model");
		tvc.getColumn().addSelectionListener(
				new GenericPropertyColumnSorter(viewer, map));
		tvc.getColumn().pack();

		map = BeanProperties.value("doors", int.class) 
			.observeDetail(set);
		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new DelayedLabelProvider(map, 2000));
		tvc.getColumn().setText("Doors");
		tvc.getColumn().pack();

		map = BeanProperties.value("loadCapacity", int.class) 
			.observeDetail(set);
		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new DelayedLabelProvider(map, 2000));
		tvc.getColumn().setText("Load Capacity");
		tvc.getColumn().pack();
	}

	private void clearColumns(TableViewer viewer) {
		for(int i = 0; i < viewer.getTable().getColumnCount(); i++ ) {
			viewer.getTable().remove(i);
		}
	}

	private List<Person> createPeople(int count, boolean includePhoneNumber) {
		createEMFColumns(viewer, obListContentProvider.getKnownElements());
		viewer.setInput(EMFProperties.list(
				AddressbookPackage.Literals.ADDRESS_BOOK__PEOPLE).observe(ab));
		
		List<Person> people = new ArrayList<Person>(count);
		for (int i = 0; i < count; i++) {
			Person p = AddressbookFactory.eINSTANCE.createPerson();
			p.setFirstName(Double.toString(Math.random()));
			p.setLastName(Double.toString(Math.random()));
			PhoneNumber number = AddressbookFactory.eINSTANCE
					.createPhoneNumber();
			number.setNumber(Double.toString(Math.random()));
			p.getPhoneNumbers().add(number);
			people.add(p);
		}
		return people;
	}
	
	private List<Car> createCars(int count) {
		createJavaBeanColumns(viewer, obListContentProvider.getKnownElements());
		List<Car> cars = new ArrayList<Car>(count);
		for( int i = 0; i < count; i++ ) {
			if( i % 10 == 0 ) {
				cars.add(new Truck());
			} else {
				cars.add(new Car());
			}
		}
		viewer.setInput(new WritableList(cars, Car.class));
		return cars;
	}

	public class TemperatureSource extends Thread {
		private final PropertyChangeSupport pcs;
		private double temperature;

		public TemperatureSource() {
			this.pcs = new PropertyChangeSupport(this);
		}

		@Override
		public void run() {
			while (true) {
				this.setTemperature(Math.random() * 100.0d);
				try {
					Thread.sleep((long) (Math.random() * 10.0d + 10.0d));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}

		public double getTemperature() {
			return temperature;
		}

		public void setTemperature(double temperature) {
			double oldValue = this.temperature;
			this.temperature = temperature;
			this.pcs.firePropertyChange("temperature",
					Double.valueOf(oldValue), Double.valueOf(temperature));
		}

		public void addPropertyChangeListener(PropertyChangeListener listener) {
			pcs.addPropertyChangeListener(listener);
		}

		public void removePropertyChangeListener(PropertyChangeListener listener) {
			pcs.removePropertyChangeListener(listener);
		}

		public void addPropertyChangeListener(String propertyName,
				PropertyChangeListener listener) {
			pcs.addPropertyChangeListener(propertyName, listener);
		}

		public void removePropertyChangeListener(String propertyName,
				PropertyChangeListener listener) {
			pcs.removePropertyChangeListener(propertyName, listener);
		}
	}
}