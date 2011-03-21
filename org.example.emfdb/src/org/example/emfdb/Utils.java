package org.example.emfdb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.IStaleListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.internal.EMFValueProperty;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.example.emfdb.instrument.Instrument;
import org.example.emfdb.instrument.InstrumentFactory;
import org.example.emfdb.instrument.InstrumentPackage;

@SuppressWarnings("restriction")
public class Utils {
    public static List<Instrument> createInstruments(int count) {
        List<Instrument> instruments = new ArrayList<Instrument>(count);
        for (int i = 0; i < count; i++) {
            Instrument inst = InstrumentFactory.eINSTANCE.createInstrument();
            inst.setId(i + 1);
            inst.setSymbol("Inst:" + i);
            inst.setGreeks(InstrumentFactory.eINSTANCE.createGreeks());
            instruments.add(inst);
        }
        return instruments;
    }

    public static IObservableMap[] createEMFObservableMapsWithIntermediate(
            IObservableSet set) {
        IObservableMap garbageMap = EMFProperties.value(
                InstrumentPackage.Literals.INSTRUMENT__GREEKS).observeDetail(
                set);
        return new IObservableMap[] {
                EMFProperties.value(InstrumentPackage.Literals.INSTRUMENT__ID)
                        .observeDetail(set),
                EMFProperties.value(
                        InstrumentPackage.Literals.INSTRUMENT__SYMBOL)
                        .observeDetail(set),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__PRICE)
                        .observeDetail(garbageMap),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__DELTA)
                        .observeDetail(garbageMap),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__GAMMA)
                        .observeDetail(garbageMap),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__VEGA)
                        .observeDetail(garbageMap),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__THETA)
                        .observeDetail(garbageMap),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__RHO)
                        .observeDetail(garbageMap) };
    }

    public static IObservableMap[] createEMFObservableMapsWithoutLeafListening(
            IObservableSet set) {
        IObservableMap garbageMap = EMFProperties.value(
                InstrumentPackage.Literals.INSTRUMENT__GREEKS).observeDetail(
                set);
        return new IObservableMap[] {
                EMFProperties.value(InstrumentPackage.Literals.INSTRUMENT__ID)
                        .observeDetail(set),
                EMFProperties.value(
                        InstrumentPackage.Literals.INSTRUMENT__SYMBOL)
                        .observeDetail(set),

                new EMFPartialListeningMapDecorator(garbageMap,
                        InstrumentPackage.Literals.GREEKS__PRICE),
                new EMFPartialListeningMapDecorator(garbageMap,
                        InstrumentPackage.Literals.GREEKS__DELTA),
                new EMFPartialListeningMapDecorator(garbageMap,
                        InstrumentPackage.Literals.GREEKS__GAMMA),
                new EMFPartialListeningMapDecorator(garbageMap,
                        InstrumentPackage.Literals.GREEKS__VEGA),
                new EMFPartialListeningMapDecorator(garbageMap,
                        InstrumentPackage.Literals.GREEKS__THETA),
                new EMFPartialListeningMapDecorator(garbageMap,
                        InstrumentPackage.Literals.GREEKS__RHO) };
    }

    public static IObservableMap[] createEMFObservableMaps(IObservableSet set) {
        return new IObservableMap[] {
                EMFProperties.value(InstrumentPackage.Literals.INSTRUMENT__ID)
                        .observeDetail(set),
                EMFProperties.value(
                        InstrumentPackage.Literals.INSTRUMENT__SYMBOL)
                        .observeDetail(set),
                EMFProperties.value(
                        FeaturePath.fromList(
                                InstrumentPackage.Literals.INSTRUMENT__GREEKS,
                                InstrumentPackage.Literals.GREEKS__PRICE))
                        .observeDetail(set),
                EMFProperties.value(
                        FeaturePath.fromList(
                                InstrumentPackage.Literals.INSTRUMENT__GREEKS,
                                InstrumentPackage.Literals.GREEKS__DELTA))
                        .observeDetail(set),
                EMFProperties.value(
                        FeaturePath.fromList(
                                InstrumentPackage.Literals.INSTRUMENT__GREEKS,
                                InstrumentPackage.Literals.GREEKS__GAMMA))
                        .observeDetail(set),
                EMFProperties.value(
                        FeaturePath.fromList(
                                InstrumentPackage.Literals.INSTRUMENT__GREEKS,
                                InstrumentPackage.Literals.GREEKS__VEGA))
                        .observeDetail(set),
                EMFProperties.value(
                        FeaturePath.fromList(
                                InstrumentPackage.Literals.INSTRUMENT__GREEKS,
                                InstrumentPackage.Literals.GREEKS__THETA))
                        .observeDetail(set),
                EMFProperties.value(
                        FeaturePath.fromList(
                                InstrumentPackage.Literals.INSTRUMENT__GREEKS,
                                InstrumentPackage.Literals.GREEKS__RHO))
                        .observeDetail(set) };
    }

    @SuppressWarnings("rawtypes")
    private static class EMFPartialListeningMapDecorator implements
            IObservableMap {
        private IObservableMap delegateMap;
        private IValueProperty valueProperty;

        public EMFPartialListeningMapDecorator(IObservableMap delegateMap,
                EStructuralFeature feature) {
            this.delegateMap = delegateMap;
            this.valueProperty = new EMFValueProperty(feature);
        }

        public Object getKeyType() {
            return delegateMap.getKeyType();
        }

        public Realm getRealm() {
            return delegateMap.getRealm();
        }

        public Object getValueType() {
            return valueProperty.getValueType();
        }

        public void addChangeListener(IChangeListener listener) {
            delegateMap.addChangeListener(listener);
        }

        public void addMapChangeListener(IMapChangeListener listener) {
            delegateMap.addMapChangeListener(listener);
        }

        public boolean isEmpty() {
            return delegateMap.isEmpty();
        }

        public Object get(Object key) {
            Object source = delegateMap.get(key);
            if (source != null) {
                return valueProperty.getValue(source);
            } else {
                return null;
            }
        }

        public Object put(Object key, Object value) {
            Object source = delegateMap.get(key);
            Object oldValue = valueProperty.getValue(source);
            valueProperty.setValue(source, value);
            return oldValue;
        }

        public void addStaleListener(IStaleListener listener) {
            delegateMap.addStaleListener(listener);
        }

        public Set keySet() {
            return delegateMap.keySet();
        }

        public Set entrySet() {
            return delegateMap.entrySet();
        }

        public boolean equals(Object o) {
            if (o instanceof EMFPartialListeningMapDecorator) {
                EMFPartialListeningMapDecorator otherMapDecorator = (EMFPartialListeningMapDecorator) o;
                return delegateMap.equals(otherMapDecorator.delegateMap)
                        && valueProperty
                                .equals(otherMapDecorator.valueProperty);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return delegateMap.hashCode() + 17 * valueProperty.hashCode();
        }

        public boolean isStale() {
            return delegateMap.isStale();
        }

        public void addDisposeListener(IDisposeListener listener) {
            delegateMap.addDisposeListener(listener);
        }

        public void clear() {
            delegateMap.clear();
        }

        public boolean containsKey(Object key) {
            return delegateMap.containsKey(key);
        }

        public boolean containsValue(Object value) {
            if (value == null) {
                return false;
            }
            // This is going to be SLOOOW. Hopefully it's not used often.
            for (Object o : this.delegateMap.entrySet()) {
                @SuppressWarnings("unchecked")
                Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) o;
                if (value.equals(valueProperty.getValue(entry.getValue()))) {
                    return true;
                }
            }
            return false;
        }

        public boolean isDisposed() {
            return delegateMap.isDisposed();
        }

        public void dispose() {
            delegateMap.dispose();
        }

        public void putAll(Map arg0) {
            if (arg0 == null)
                return;
            // I think we break from API a bit here, because we expect after
            // this is run that
            // every value from the input map will exist in this map.
            // Unfortunately, if a value
            // isn't already supplied for the entry key, I won't have any way to
            // generate that
            // intermediate value.
            for (Object o : arg0.entrySet()) {
                @SuppressWarnings("unchecked")
                Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) o;
                Object source = this.get(entry.getKey());
                if (source != null) {
                    valueProperty.setValue(source, entry.getValue());
                }
            }
        }

        public void removeMapChangeListener(IMapChangeListener listener) {
            delegateMap.removeMapChangeListener(listener);
        }

        public int size() {
            return delegateMap.size();
        }

        public void removeChangeListener(IChangeListener listener) {
            delegateMap.removeChangeListener(listener);
        }

        public Object remove(Object key) {
            return delegateMap.remove(key);
        }

        public Collection values() {
            Collection keys = delegateMap.values();
            Collection<Object> values = new ArrayList<Object>(keys.size());
            for (Object key : keys) {
                values.add(valueProperty.getValue(key));
            }
            return values;
        }

        public void removeStaleListener(IStaleListener listener) {
            delegateMap.removeStaleListener(listener);
        }

        public void removeDisposeListener(IDisposeListener listener) {
            delegateMap.removeDisposeListener(listener);
        }
    }
}
