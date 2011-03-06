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
import org.example.emfdb.addressbook.AddressBook;
import org.example.emfdb.addressbook.AddressbookFactory;
import org.example.emfdb.addressbook.AddressbookPackage;
import org.example.emfdb.addressbook.Person;
import org.example.emfdb.addressbook.impl.AddressBookImpl;

public class DecoratedTestView extends ViewPart {

    @Override
    public void createPartControl(Composite parent) {
        AddressBookImpl book = (AddressBookImpl) AddressbookFactory.eINSTANCE
                .createAddressBook();
        book.useIdentityEqualsList();
        for (int i = 0; i < 5; i++) {
            Person p = AddressbookFactory.eINSTANCE.createPerson();
            p.setFirstName("John " + i);
            p.setLastName("Doe");
            book.getPeople().add(p);
        }

        WritableValue v = new WritableValue(book, AddressBook.class);

        IObservableList obList = EMFProperties.list(
                AddressbookPackage.Literals.ADDRESS_BOOK__PEOPLE)
                .observeDetail(v);
        ObservableListContentProvider cp = new ObservableListContentProvider();

        TableViewer tv = new TableViewer(parent);
        tv.getTable().setHeaderVisible(true);
        tv.setContentProvider(cp);
        TableViewerColumn col = new TableViewerColumn(tv, SWT.NONE);
        col.getColumn().setText("First Name");
        col.getColumn().pack();
        IObservableMap map = EMFProperties.value(
                AddressbookPackage.Literals.PERSON__FIRST_NAME).observeDetail(
                cp.getKnownElements());
        col.setLabelProvider(new ObservableMapCellLabelProvider(map));
        tv.setInput(obList);
    }

    @Override
    public void setFocus() {

    }

}
