package org.example.emfdb;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;

public class AggregationObservables {
	public static IObservableValue observeCount(final IObservableList list) {
		return new ComputedValue() {
			@Override
			protected Object calculate() {
				return list.size();
			}
		};
	}
	
	public static IObservableValue observeSum(final IObservableList list) {
		return observeSum(list, Double.class);
	}
	
	public static IObservableValue observeSum(final IObservableList list, final Class<? extends Number> clazz) {
		return new ComputedValue() {
			@Override
			protected Object calculate() {
				double sum = 0;
				for( Object obj : list ) {
					sum += clazz.cast(obj).doubleValue();
				}
				return Double.valueOf(sum);
			}
		};
	}

	public static IObservableValue observeAverage(final IObservableList list) {
		return observeAverage(list, Double.class);
	}
	
	public static IObservableValue observeAverage(final IObservableList list, final Class<? extends Number> clazz) {
		return new ComputedValue() {
			@Override
			protected Object calculate() {
				double sum = 0;
				for( Object obj : list ) {
					sum += clazz.cast(obj).doubleValue();
				}
				return Double.valueOf(sum/list.size());
			}
		};
	}

	public static IObservableValue observeMin(final IObservableList list) {
		return observeMin(list, Double.class);
	}
	
	public static IObservableValue observeMin(final IObservableList list, final Class<? extends Number> clazz) {
		return new ComputedValue() {
			@Override
			protected Object calculate() {
				if( list.size() > 0 ) {
					Number n = clazz.cast(list.get(0));
					for( int i = 1; i < list.size(); i++ ) {
						n = Math.min(n.doubleValue(), clazz.cast(list.get(i)).doubleValue());
					}
					return clazz.cast(n);
				} else {
					return clazz.cast(0);
				}
			}
		};
	}

	public static IObservableValue observeMax(final IObservableList list) {
		return observeMax(list, Double.class);
	}
	
	public static IObservableValue observeMax(final IObservableList list, final Class<? extends Number> clazz) {
		return new ComputedValue() {
			@Override
			protected Object calculate() {
				if( list.size() > 0 ) {
					Number n = clazz.cast(list.get(0));
					for( int i = 1; i < list.size(); i++ ) {
						n = Math.max(n.doubleValue(), clazz.cast(list.get(i)).doubleValue());
					}
					return clazz.cast(n);
				} else {
					return clazz.cast(0);
				}
			}
		};
	}
}
