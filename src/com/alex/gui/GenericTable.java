package com.alex.gui;

import com.alex.gui.table.model.FactoryTableModel;

import javax.swing.JTable;
import java.util.List;

/**
 * Created by user on 07.01.2016.
 */
public abstract class GenericTable<T> extends JTable {

    public GenericTable() {
        super();
        refresh(null);
    }

    protected abstract Class<T> getClassT();

    protected GenericTableModel getTableModel(List list) {
        return FactoryTableModel.getTableModel(getClassT(), list);
    }

    public long getSelectedObjectId() {
        int row = getSelectedRow();
        return (long) getValueAt(row, 0);
    }

    public void refresh(List list) {
        GenericTableModel abstractTableModel = getTableModel(list);
        setModel(abstractTableModel);
    }
}
