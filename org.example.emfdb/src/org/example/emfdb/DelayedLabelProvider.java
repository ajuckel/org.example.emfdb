package org.example.emfdb;

import java.text.Format;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

public class DelayedLabelProvider extends CellLabelProvider implements
        IFontProvider, IColorProvider,
        ILabelProvider {

    private IObservableMap[]     attributeMaps;
    private final Format         format;
    protected IMapChangeListener mapChangeListener;

    public DelayedLabelProvider(IObservableMap attributeMap, Format format) {
        this(new IObservableMap[] {attributeMap}, format);
    }

    public DelayedLabelProvider(IObservableMap attributeMap) {
        this(new IObservableMap[] {attributeMap}, null);
    }

    public DelayedLabelProvider(IObservableMap[] attributeMaps) {
        this(attributeMaps, null);
    }

    public DelayedLabelProvider(IObservableMap[] attributeMaps, Format format) {
        this(attributeMaps, format, 0);
    }

    public DelayedLabelProvider(IObservableMap map, int delay) {
    	this(new IObservableMap[] {map}, null, delay);
	}

    public DelayedLabelProvider(IObservableMap[] attributeMaps, Format format, int delay) {
        System.arraycopy(attributeMaps, 0,
            this.attributeMaps = new IObservableMap[attributeMaps.length],
            0, attributeMaps.length);
        this.format = format;
        this.mapChangeListener = (delay == 0) ? getMapChangeListener() :
                getDelayedMapChangeListener(delay);
        for(IObservableMap map : attributeMaps) {
        	map.addMapChangeListener(this.mapChangeListener);
        }
    }

	@Override
    public void update(ViewerCell cell) {
        Object element = cell.getElement();
        cell.setFont(this.getFont(element));
        cell.setForeground(this.getForeground(element));
        cell.setBackground(this.getBackground(element));
        cell.setImage(this.getImage(element));
        cell.setText(this.getText(element));
    }


    // @Override
    public Font getFont(Object element) {
        // TODO Auto-generated method stub
        return null;
    }

    // @Override
    public Color getBackground(Object element) {
        // TODO Auto-generated method stub
        return null;
    }

    // @Override
    public Color getForeground(Object element) {
        return null;
    }

    // @Override
    public Image getImage(Object element) {
        // TODO Auto-generated method stub
        return null;
    }

    // @Override
    public String getText(Object element) {
        Object value = this.getValue(element);
        if (value == null) {
            return "";
        }
        if (this.format != null) {
            return this.format.format(value);
        } else {
            return value.toString();
        }
    }

    public Object getValue(Object element) {
        return this.attributeMaps[0].get(element);
    }

    protected IMapChangeListener getMapChangeListener() {
        return new IMapChangeListener() {
            public void handleMapChange(MapChangeEvent event) {
                Set<?> affectedElements = event.diff.getChangedKeys();
                LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
                              DelayedLabelProvider.this, affectedElements
                                          .toArray());
                fireLabelProviderChanged(newEvent);
            }
        };
    }

    protected IMapChangeListener getDelayedMapChangeListener(int delay) {
        return new DelayedMapChangeListener(delay);
    }

    /**
     * An IMapChangeListener that also acts as a Runnable to be scheduled. 
     * @author tjuckel
     */
    protected class DelayedMapChangeListener implements IMapChangeListener, Runnable {
        private final int         delay;
        private final Set<Object> affectedElements;
        private boolean           scheduled = false;

        public DelayedMapChangeListener(int delay) {
            this.delay = delay;
            this.affectedElements = new HashSet<Object>();
        }

        @SuppressWarnings("unchecked")
        public void handleMapChange(MapChangeEvent event) {
            synchronized (this.affectedElements) {
                this.affectedElements.addAll(event.diff.getChangedKeys());
                if (!scheduled) {
                    DelayedLabelProvider.this.attributeMaps[0].getRealm().timerExec(delay, this);
                    scheduled = true;
                }
            }
        }

        public void run() {
            // It's important to block out the work appropriately.  Obtain the set of objects to be
            // updated, clear the hash and set scheduled to false while holding the lock.  Then 
            // release, so that further updates may be properly scheduled while we're notifying listeners.
            Set<Object> elements = null;
            synchronized (this.affectedElements) {
                elements = new HashSet<Object>(this.affectedElements);
                this.affectedElements.clear();
                this.scheduled = false;
            }

            LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
                DelayedLabelProvider.this, elements.toArray());
            fireLabelProviderChanged(newEvent);
        }
    }
}
