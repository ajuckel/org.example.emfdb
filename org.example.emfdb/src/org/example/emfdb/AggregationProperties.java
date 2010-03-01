package org.example.emfdb;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.list.IListProperty;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;

public class AggregationProperties {
	public static IValueProperty count(final IListProperty listProp) {
		return new SimpleValueProperty() {
			private IObservableList obList = null;
			
			@Override
			public IObservableValue observe(Realm realm, Object source) {
				obList = listProp.observe(realm, source);
				return super.observe(realm, source);
			}

			public Object getValueType() {
				return Integer.class;
			}

			@Override
			protected Object doGetValue(Object source) {
				return obList.size();
			}

			@Override
			protected void doSetValue(Object source, Object value) {
			}

			@Override
			public INativePropertyListener adaptListener(
					ISimplePropertyListener listener) {
				return null;
			}
		};
	}

	public static IValueProperty avg(final IListProperty listProp, final IValueProperty valueProp) {
		return new SimpleValueProperty() {

			public Object getValueType() {
				return valueProp.getValueType();
			}

			@Override
			protected Object doGetValue(Object source) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected void doSetValue(Object source, Object value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public INativePropertyListener adaptListener(
					ISimplePropertyListener listener) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}
}