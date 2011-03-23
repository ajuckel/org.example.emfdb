package org.example.emfdb;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;
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
import org.example.emfdb.beans.Car;
import org.example.emfdb.beans.Truck;
import org.example.emfdb.instrument.Instrument;
import org.example.emfdb.instrument.InstrumentFactory;
import org.example.emfdb.instrument.InstrumentPackage;
import org.example.emfdb.instrument.Portfolio;

public class View extends ViewPart {
    public static final String ID = "org.example.emfdb.view";

    private final Portfolio portfolio = InstrumentFactory.eINSTANCE
            .createPortfolio();

    private TableViewer viewer;
    private ObservableListContentProvider obListContentProvider;
    private boolean usingSwtVirtual = true;
    private Composite parent = null;
    private final PriceSource[] providers = new PriceSource[10];
    private final int[] providerAssignments = new int[providers.length];

    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    public void createPartControl(Composite parent) {
        this.parent = parent;

        obListContentProvider = new ObservableListContentProvider();
        viewer = initViewer();
        for (int i = 0; i < providers.length; i++) {
            providers[i] = new PriceSource(i + 1);
        }

        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("Toggle Virtual", IAction.AS_CHECK_BOX) {
                    @Override
                    public void run() {
                        usingSwtVirtual = !usingSwtVirtual;
                        this.setChecked(usingSwtVirtual);

                        disposeViewer(viewer);
                        portfolio.getInstruments().clear();
                        obListContentProvider = new ObservableListContentProvider();
                        viewer = initViewer();
                        viewer.getControl().setVisible(true);
                        viewer.getControl().update();
                    }

                    @Override
                    public boolean isChecked() {
                        return usingSwtVirtual;
                    }
                });
        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("Clear List") {
                    @Override
                    public void run() {
                        portfolio.getInstruments().clear();
                    }
                });
        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("Create EMF Columns") {
                    @Override
                    public void run() {
                        createEMFColumns(viewer, Utils
                                .createEMFObservableMaps(obListContentProvider
                                        .getKnownElements()));
                    }
                });
        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("Create EMF Columns w/ Intermediate") {
                    @Override
                    public void run() {
                        createEMFColumns(
                                viewer,
                                Utils.createEMFObservableMapsWithIntermediate(obListContentProvider
                                        .getKnownElements()));
                    }
                });
        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("Create EMF Columns w/o Leaf Listening") {
                    @Override
                    public void run() {
                        createEMFColumns(
                                viewer,
                                Utils.createEMFObservableMapsWithoutLeafListening(obListContentProvider
                                        .getKnownElements()));
                    }
                });
        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("" + "Bean Columns") {
                    @Override
                    public void run() {
                        createJavaBeanColumns(viewer,
                                obListContentProvider.getKnownElements());
                    }
                });
        for (final int count : new int[] { 100, 1000, 10000 }) {
            this.getViewSite().getActionBars().getMenuManager()
                    .add(new Action(String.format("%d Instruments", count)) {
                        @Override
                        public void run() {
                            viewer.setInput(EMFProperties
                                    .list(InstrumentPackage.Literals.PORTFOLIO__INSTRUMENTS)
                                    .observe(portfolio));
                            Date start = new Date();
                            portfolio.getInstruments().addAll(
                                    Utils.createInstruments(count));
                            for (TableColumn c : viewer.getTable().getColumns()) {
                                c.pack();
                            }
                            Date end = new Date();
                            System.out.printf("Bound in %d milliseconds.\n",
                                    end.getTime() - start.getTime());
                        }
                    });
            this.getViewSite().getActionBars().getMenuManager()
                    .add(new Action(String.format("%d Beans", count)) {
                        @Override
                        public void run() {
                            createCars(count);
                            for (TableColumn c : viewer.getTable().getColumns()) {
                                c.pack();
                            }
                        }
                    });
        }

        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("Bind Under Price") {
                    public void run() {
                        for (final Instrument inst : portfolio.getInstruments()) {
                            providers[0]
                                    .addPropertyChangeListener(new PropertyChangeListener() {
                                        public void propertyChange(
                                                PropertyChangeEvent evt) {
                                            inst.setUnderPrice(((Double) evt
                                                    .getNewValue())
                                                    .doubleValue());
                                        }
                                    });
                        }
                    }
                });
        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("Bind Prices to Greeks Update") {
                    @Override
                    public void run() {
                        for (final Instrument inst : portfolio.getInstruments()) {
                            int index = (int) (Math.random() * providers.length);
                            providerAssignments[index]++;
                            providers[index]
                                    .addPropertyChangeListener(new PropertyChangeListener() {
                                        public void propertyChange(
                                                PropertyChangeEvent evt) {
                                            double newPrice = ((Double) evt
                                                    .getNewValue())
                                                    .doubleValue();
                                            inst.setGreeks(InstrumentFactory.eINSTANCE
                                                    .createGreeks(newPrice));
                                        }
                                    });
                        }
                    }
                });
        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("Bind Prices to Greeks Property Updates") {
                    @Override
                    public void run() {
                        for (final Instrument inst : portfolio.getInstruments()) {
                            int index = (int) (Math.random() * providers.length);
                            providerAssignments[index]++;
                            providers[index]
                                    .addPropertyChangeListener(new PropertyChangeListener() {
                                        public void propertyChange(
                                                PropertyChangeEvent evt) {
                                            double newPrice = ((Double) evt
                                                    .getNewValue())
                                                    .doubleValue();
                                            inst.getGreeks().setAllValues(
                                                    newPrice);
                                        }
                                    });
                        }
                    }
                });
        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("Start Auto Update") {
                    @Override
                    public void run() {
                        for (int i = 0; i < providers.length; i++) {
                            providers[i].startAutoUpdate();
                        }
                    }
                });
        this.getViewSite().getActionBars().getMenuManager()
                .add(new Action("Stop Auto Update") {
                    @Override
                    public void run() {
                        for (int i = 0; i < providers.length; i++) {
                            providers[i].stopAutoUpdate();
                        }
                    }
                });
        for (int i = 0; i < providers.length; i++) {
            final int providerIndex = i;
            this.getViewSite().getActionBars().getMenuManager()
                    .add(new Action("Single Update Source " + i) {
                        @Override
                        public void run() {
                            if (providers[providerIndex] == null) {
                                throw new RuntimeException(
                                        "Call Bind Prices first!");
                            }

                            Date start = new Date();
                            providers[providerIndex].tweakPrice();
                            Date end = new Date();
                            System.out.printf(
                                    "Bound %d elements in %d milliseconds.\n",
                                    providerAssignments[providerIndex],
                                    end.getTime() - start.getTime());
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
        int style = SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.FULL_SELECTION;
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
                ViewerCell cell = super.findSelectedCell(viewer,
                        currentSelectedCell, event);

                if (cell != null) {
                    v.getTable().showColumn(
                            v.getTable().getColumn(cell.getColumnIndex()));
                }

                return cell;
            }

        };

        TableViewerFocusCellManager focusCellManager = new TableViewerFocusCellManager(
                v, new FocusCellOwnerDrawHighlighter(v), naviStrat);

        ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(
                v) {
            protected boolean isEditorActivationEvent(
                    ColumnViewerEditorActivationEvent event) {
                return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
                        || event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
                        || (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR)
                        || event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
            }
        };

        TableViewerEditor.create(v, focusCellManager, actSupport,
                ColumnViewerEditor.TABBING_HORIZONTAL
                        | ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
                        | ColumnViewerEditor.TABBING_VERTICAL
                        | ColumnViewerEditor.KEYBOARD_ACTIVATION);

        v.getColumnViewerEditor().addEditorActivationListener(
                new ColumnViewerEditorActivationListener() {

                    public void afterEditorActivated(
                            ColumnViewerEditorActivationEvent event) {
                    }

                    public void afterEditorDeactivated(
                            ColumnViewerEditorDeactivationEvent event) {
                    }

                    public void beforeEditorActivated(
                            ColumnViewerEditorActivationEvent event) {
                        ViewerCell cell = (ViewerCell) event.getSource();
                        v.getTable().showColumn(
                                v.getTable().getColumn(cell.getColumnIndex()));
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
            this(viewer, map, new TextCellEditor(
                    (Composite) viewer.getControl()));
        }

        public MapEditingSupport(ColumnViewer viewer, IObservableMap map,
                CellEditor editor) {
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

    private void createEMFColumns(final TableViewer viewer,
            IObservableMap[] maps) {
        clearColumns(viewer);

        TableViewerColumn tvc = new TableViewerColumn(viewer, SWT.LEFT);
        tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[0]));
        tvc.getColumn().setText("ID");
        tvc.getColumn().addSelectionListener(
                new GenericPropertyColumnSorter(viewer, maps[0]));
        tvc.setEditingSupport(new MapEditingSupport(viewer, maps[0]));
        tvc.getColumn().pack();

        tvc = new TableViewerColumn(viewer, SWT.LEFT);
        tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[1]));
        tvc.getColumn().setText("Symbol");
        tvc.getColumn().addSelectionListener(
                new GenericPropertyColumnSorter(viewer, maps[1]));
        tvc.setEditingSupport(new MapEditingSupport(viewer, maps[1]));
        tvc.getColumn().pack();

        tvc = new TableViewerColumn(viewer, SWT.RIGHT);
        tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[2]));
        tvc.getColumn().setText("Under Price");
        tvc.getColumn().addSelectionListener(
                new GenericPropertyColumnSorter(viewer, maps[2]));
        tvc.setEditingSupport(new MapEditingSupport(viewer, maps[1]));
        tvc.getColumn().pack();

        tvc = new TableViewerColumn(viewer, SWT.RIGHT);
        tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[3]));
        tvc.getColumn().setText("Price");
        tvc.getColumn().pack();

        tvc = new TableViewerColumn(viewer, SWT.RIGHT);
        tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[4]));
        tvc.getColumn().setText("Delta");
        tvc.getColumn().pack();

        tvc = new TableViewerColumn(viewer, SWT.RIGHT);
        tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[5]));
        tvc.getColumn().setText("Gamma");
        tvc.getColumn().pack();

        tvc = new TableViewerColumn(viewer, SWT.RIGHT);
        tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[6]));
        tvc.getColumn().setText("Vega");
        tvc.getColumn().pack();

        tvc = new TableViewerColumn(viewer, SWT.RIGHT);
        tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[7]));
        tvc.getColumn().setText("Theta");
        tvc.getColumn().pack();

        tvc = new TableViewerColumn(viewer, SWT.RIGHT);
        tvc.setLabelProvider(new ObservableMapCellLabelProvider(maps[8]));
        tvc.getColumn().setText("Rho");
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

        map = BeanProperties.value("model", String.class).observeDetail(set);
        tvc = new TableViewerColumn(viewer, SWT.LEFT);
        tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
        tvc.getColumn().setText("Model");
        tvc.getColumn().addSelectionListener(
                new GenericPropertyColumnSorter(viewer, map));
        tvc.getColumn().pack();

        map = BeanProperties.value("doors", int.class).observeDetail(set);
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
        for (int i = 0; i < viewer.getTable().getColumnCount(); i++) {
            viewer.getTable().remove(i);
        }
    }

    private List<Car> createCars(int count) {
        // createJavaBeanColumns(viewer,
        // obListContentProvider.getKnownElements());
        List<Car> cars = new ArrayList<Car>(count);
        for (int i = 0; i < count; i++) {
            if (i % 10 == 0) {
                cars.add(new Truck());
            } else {
                cars.add(new Car());
            }
        }
        viewer.setInput(new WritableList(cars, Car.class));
        return cars;
    }

    public class PriceSource extends Thread {
        private final PropertyChangeSupport pcs;
        private final int frequency;
        private double price;
        private volatile boolean shouldFire = true;

        public PriceSource(int frequency) {
            this.pcs = new PropertyChangeSupport(this);
            this.frequency = frequency;
        }

        @Override
        public void run() {
            while (true) {
                if (shouldFire)
                    tweakPrice();
                try {
                    Thread.sleep((long) (Math.random() * 200.0d * frequency + 50.0d));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void startAutoUpdate() {
            this.shouldFire = true;
            if (!this.isAlive())
                this.start();
        }

        public void stopAutoUpdate() {
            this.shouldFire = false;
        }

        public void tweakPrice() {
            this.setPrice(Math.random() * 100.0d);
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double temperature) {
            double oldValue = this.price;
            this.price = temperature;
            this.pcs.firePropertyChange("price", Double.valueOf(oldValue),
                    Double.valueOf(temperature));
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