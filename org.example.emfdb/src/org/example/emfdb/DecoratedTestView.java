package org.example.emfdb;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.example.emfdb.instrument.Instrument;
import org.example.emfdb.instrument.InstrumentFactory;
import org.example.emfdb.instrument.InstrumentPackage;
import org.example.emfdb.instrument.Portfolio;
import org.example.emfdb.instrument.impl.PortfolioImpl;

public class DecoratedTestView extends ViewPart {

    @Override
    public void createPartControl(Composite parent) {
        PortfolioImpl portfolio = (PortfolioImpl) InstrumentFactory.eINSTANCE
                .createPortfolio();
        portfolio.useIdentityEqualsList();
        for (int i = 0; i < 5; i++) {
            Instrument inst = InstrumentFactory.eINSTANCE.createInstrument();
            inst.setId(i);
            inst.setSymbol("Inst" + i);
            portfolio.getInstruments().add(inst);
        }

        WritableValue v = new WritableValue(portfolio, Portfolio.class);

        IObservableList obList = EMFProperties.list(
                InstrumentPackage.Literals.PORTFOLIO__INSTRUMENTS)
                .observeDetail(v);
        ObservableListContentProvider cp = new ObservableListContentProvider();

        TableViewer tv = new TableViewer(parent);
        tv.getTable().setHeaderVisible(true);
        tv.setContentProvider(cp);
        TableViewerColumn col = new TableViewerColumn(tv, SWT.NONE);
        col.getColumn().setText("First Name");
        col.getColumn().pack();
        IObservableMap map = EMFProperties.value(
                InstrumentPackage.Literals.INSTRUMENT__ID).observeDetail(
                cp.getKnownElements());
        col.setLabelProvider(new ObservableMapCellLabelProvider(map));
        tv.setInput(obList);
    }

    @Override
    public void setFocus() {

    }

}
