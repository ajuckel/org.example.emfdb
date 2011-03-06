package org.example.emfdb;

import org.eclipse.core.databinding.observable.map.IObservableMap;

public class GenericValueFetcher {
    final private IObservableMap observableMap;

    public GenericValueFetcher(IObservableMap observableMap) {
        this.observableMap = observableMap;
    }

    public Object getValue(Object obj) {
        return this.observableMap.get(obj);
    }

}
