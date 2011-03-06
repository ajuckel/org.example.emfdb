package org.example.emfdb;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;
import org.example.emfdb.GenericValueFetcher;

public class GenericPropertyColumnSorter extends ViewerComparator implements
        SelectionListener {
    private final ColumnViewer viewer;

    private enum Results {
        LESS_THAN(-1), EQUAL(0), GREATER_THAN(1);

        private final int value;

        Results(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    private final GenericValueFetcher fetcher;
    private boolean sortOrderReversed = false;

    public GenericPropertyColumnSorter(ColumnViewer viewer,
            IObservableMap observableMap) {
        this.viewer = viewer;
        this.fetcher = new GenericValueFetcher(observableMap);
    }

    public void widgetDefaultSelected(SelectionEvent e) {
        widgetSelected(e);
    }

    public void widgetSelected(SelectionEvent e) {
        // we need to set the comparator to null first to let the viewer class
        // take notice
        // that sort() has to be called again upon setting this object as
        // current comparator
        this.viewer.setComparator(null);
        this.viewer.setComparator(this);

        // change sort order
        sortOrderReversed = !sortOrderReversed;

        Table t = (Table) this.viewer.getControl();
        t.setSortDirection(sortOrderReversed ? SWT.UP : SWT.DOWN);
        t.setSortColumn(t.getColumn(0));

    }

    @Override
    @SuppressWarnings("unchecked")
    public int compare(Viewer viewer, Object o1, Object o2) {
        if (!(o1 instanceof EObject) || !(o2 instanceof EObject)) {
            throw new IllegalArgumentException(
                    "Both parameters must be EObjects (unless one is null).");
        } else {
            final Object v1 = this.fetcher.getValue((EObject) o1);
            final Object v2 = this.fetcher.getValue((EObject) o2);

            if (null == v2) {
                return Results.LESS_THAN.getValue();
            } else if (null == v1) {
                return Results.GREATER_THAN.getValue();
            } else {
                if (v1 instanceof Comparable<?>) {
                    return (sortOrderReversed ? -1 : 1)
                            * ((Comparable<Object>) v1).compareTo(v2);
                } else {
                    // fallback to default impl
                    return super.compare(viewer, v1, v2);
                }
            }
        }
    }
}
