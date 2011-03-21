package org.example.emfdb;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ListToSetAdapter;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Display;
import org.example.emfdb.instrument.InstrumentFactory;
import org.example.emfdb.instrument.InstrumentPackage;
import org.example.emfdb.instrument.Instrument;
import org.example.emfdb.instrument.Portfolio;

public class PerfTest implements IApplication {

    public Object start(final IApplicationContext context) throws Exception {
        Display display = new Display();
        Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
            public void run() {
                Date start = new Date();
                List<Instrument> instruments = Utils.createInstruments(10000);
                Portfolio portfolio = InstrumentFactory.eINSTANCE
                        .createPortfolio();
                IObservableList list = EMFProperties.list(
                        InstrumentPackage.Literals.PORTFOLIO__INSTRUMENTS)
                        .observe(portfolio);
                IObservableSet set = new ListToSetAdapter(list);

                IObservableMap[] maps = Utils
                        .createEMFObservableMapsWithIntermediate(set);
                // In order for the maps to do something interesting when the
                // underlying data changes, we have to wire up at least one
                // listener.
                IMapChangeListener listener = new IMapChangeListener() {
                    public void handleMapChange(MapChangeEvent event) {
                        // I don't want to actually do anything as a result of a
                        // change.
                    }
                };
                for (IObservableMap map : maps) {
                    map.addMapChangeListener(listener);
                }
                Date end = new Date();
                System.out.printf(
                        "Domain initialization took %d milliseconds\n",
                        end.getTime() - start.getTime());
                System.out.printf("Waiting for gobyte!\n");
                // Super-stupid "synchronization". Wait until something has been
                // presented on STDIN before continuing.
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                start = new Date();
                // Here's the expensive bit. As a result of this, the
                // databinding layer is going to allocate and wire listeners for
                // the newly added people and the properties we've indicated we
                // want bound to the UI.
                portfolio.getInstruments().addAll(instruments);
                end = new Date();

                System.out.printf("Completed binding in %d milliseconds.\n",
                        end.getTime() - start.getTime());
            }
        });
        return Integer.valueOf(0);
    }

    public void stop() {
        // TODO Auto-generated method stub

    }

}
