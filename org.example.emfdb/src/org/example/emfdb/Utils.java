package org.example.emfdb;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.example.emfdb.instrument.Instrument;
import org.example.emfdb.instrument.InstrumentFactory;
import org.example.emfdb.instrument.InstrumentPackage;

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

    public static IObservableMap[] createEMFObservableMaps(IObservableSet set) {
        return new IObservableMap[] {
                EMFProperties.value(InstrumentPackage.Literals.INSTRUMENT__ID)
                        .observeDetail(set),
                EMFProperties.value(
                        InstrumentPackage.Literals.INSTRUMENT__SYMBOL)
                        .observeDetail(set),
                EMFProperties.value(
                        InstrumentPackage.Literals.INSTRUMENT__UNDER_PRICE)
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

    public static IObservableMap[] createEMFObservableMapsWithIntermediate(
            IObservableSet set) {
        IObservableMap greeksMap = EMFProperties.value(
                InstrumentPackage.Literals.INSTRUMENT__GREEKS).observeDetail(
                set);
        return new IObservableMap[] {
                EMFProperties.value(InstrumentPackage.Literals.INSTRUMENT__ID)
                        .observeDetail(set),
                EMFProperties.value(
                        InstrumentPackage.Literals.INSTRUMENT__SYMBOL)
                        .observeDetail(set),
                EMFProperties.value(
                        InstrumentPackage.Literals.INSTRUMENT__UNDER_PRICE)
                        .observeDetail(set),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__PRICE)
                        .observeDetail(greeksMap),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__DELTA)
                        .observeDetail(greeksMap),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__GAMMA)
                        .observeDetail(greeksMap),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__VEGA)
                        .observeDetail(greeksMap),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__THETA)
                        .observeDetail(greeksMap),
                EMFProperties.value(InstrumentPackage.Literals.GREEKS__RHO)
                        .observeDetail(greeksMap) };
    }

    public static IObservableMap[] createEMFObservableMapsWithoutLeafListening(
            IObservableSet set) {
        IObservableMap greeksMap = EMFProperties.value(
                InstrumentPackage.Literals.INSTRUMENT__GREEKS).observeDetail(
                set);
        return new IObservableMap[] {
                EMFProperties.value(InstrumentPackage.Literals.INSTRUMENT__ID)
                        .observeDetail(set),
                EMFProperties.value(
                        InstrumentPackage.Literals.INSTRUMENT__SYMBOL)
                        .observeDetail(set),
                EMFProperties.value(
                        InstrumentPackage.Literals.INSTRUMENT__UNDER_PRICE)
                        .observeDetail(set),
                new EMFPartialListeningMapDecorator(greeksMap,
                        InstrumentPackage.Literals.GREEKS__PRICE),
                new EMFPartialListeningMapDecorator(greeksMap,
                        InstrumentPackage.Literals.GREEKS__DELTA),
                new EMFPartialListeningMapDecorator(greeksMap,
                        InstrumentPackage.Literals.GREEKS__GAMMA),
                new EMFPartialListeningMapDecorator(greeksMap,
                        InstrumentPackage.Literals.GREEKS__VEGA),
                new EMFPartialListeningMapDecorator(greeksMap,
                        InstrumentPackage.Literals.GREEKS__THETA),
                new EMFPartialListeningMapDecorator(greeksMap,
                        InstrumentPackage.Literals.GREEKS__RHO) };
    }
}
