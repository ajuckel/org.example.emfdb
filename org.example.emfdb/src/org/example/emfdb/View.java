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
		this.getViewSite().getActionBars().getMenuManager().add(
				new Action("Create EMF Columns") {
					@Override
					public void run() {
						createEMFColumns(viewer, obListContentProvider.getKnownElements());
					}
				});
		this.getViewSite().getActionBars().getMenuManager().add(
				new Action("Create Bean Columns") {
					@Override
					public void run() {
						createJavaBeanColumns(viewer, obListContentProvider.getKnownElements());
					}
				});
		for (final int count : new int[] { 100, 1000, 10000 }) {
			this.getViewSite().getActionBars().getMenuManager().add(
					new Action(String.format("%d EObjects Non-null", count)) {
						@Override
						public void run() {
							viewer.setInput(EMFProperties.list(
									AddressbookPackage.Literals.ADDRESS_BOOK__PEOPLE).observe(ab));
							ab.getPeople().addAll(Utils.createPeople(count, true));
							for(TableColumn c : viewer.getTable().getColumns()) {
								c.pack();
							}
						}
					});
			this.getViewSite().getActionBars().getMenuManager().add(
					new Action(String.format("%d EObjects Null numbers", count)) {
						@Override
						public void run() {
							viewer.setInput(EMFProperties.list(
									AddressbookPackage.Literals.ADDRESS_BOOK__PEOPLE).observe(ab));
							ab.getPeople().addAll(Utils.createPeople(count, false));
							for(TableColumn c : viewer.getTable().getColumns()) {
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
							providers[i] = new TemperatureSource(i+1);
						}
						for (final Person p : ab.getPeople()) {
							int index = (int) (Math.random() * providers.length);
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
		this.getViewSite().getActionBars().getMenuManager().add(
				new Action("Auto Update Temps") {
					@Override
					public void run() {
						for (int i = 0; i < providers.length; i++) {
							providers[i].start();
						}
					}
				});
		this.getViewSite().getActionBars().getMenuManager().add(
				new Action("Auto Update Temps") {
					@Override
					public void run() {
						for (int i = 0; i < providers.length; i++) {
							providers[i].start();
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
		viewer.setUseHashlookup(true);
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
		
		IObservableMap[] maps = Utils.createEMFObservableMapsWithIntermediate(set);
		TableViewerColumn tvc = new TableViewerColumn(viewer, SWT.LEFT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[0]));
		tvc.getColumn().setText("First Name");
		tvc.getColumn().addSelectionListener(
				new GenericPropertyColumnSorter(viewer, maps[0]));
		tvc.setEditingSupport(new MapEditingSupport(viewer, maps[0]));
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.LEFT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[1]));
		tvc.getColumn().setText("Last Name");
		tvc.getColumn().addSelectionListener(
				new GenericPropertyColumnSorter(viewer, maps[1]));
		tvc.setEditingSupport(new MapEditingSupport(viewer, maps[1]));
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[2]));
		tvc.getColumn().setText("Temp");
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[3]));
		tvc.getColumn().setText("A1");
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[4]));
		tvc.getColumn().setText("A2");
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[5]));
		tvc.getColumn().setText("A3");
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[6]));
		tvc.getColumn().setText("A4");
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[7]));
		tvc.getColumn().setText("A5");
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[8]));
		tvc.getColumn().setText("A6");
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[9]));
		tvc.getColumn().setText("A7");
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[10]));
		tvc.getColumn().setText("A8");
		tvc.getColumn().pack();

		tvc = new TableViewerColumn(viewer, SWT.RIGHT);
		tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[11]));
		tvc.getColumn().setText("A9");
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

	private List<Car> createCars(int count) {
		// createJavaBeanColumns(viewer, obListContentProvider.getKnownElements());
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
		private final int frequency;
		private double temperature;

		public TemperatureSource(int frequency) {
			this.pcs = new PropertyChangeSupport(this);
			this.frequency = frequency;
		}

		@Override
		public void run() {
			while (true) {
				tweakTemp();
				try {
					Thread.sleep((long) (Math.random() * 200.0d * frequency + 50.0d));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}

		public void tweakTemp() {
			this.setTemperature(Math.random() * 100.0d);
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