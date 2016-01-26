package com.alex.gui;

import com.alex.dao.GenericDAO;
import com.alex.dao.FactoryDAO;
import com.alex.module.ToArray;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by user on 07.01.2016.
 */
public abstract class GenericTableModel<T extends ToArray> extends AbstractTableModel {

    protected String[] columnNames;
    protected List<T> list;

    public GenericTableModel(List list) {

        if (list != null) {
            this.list = list;
        } else {
            this.list = getList();
        }
    }

    protected abstract List getList();

    protected abstract Class getClassT();

    protected GenericDAO getAbstractDao() {
        return FactoryDAO.getDAO(getClassT());
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T object = list.get(rowIndex);
        return object.toArray()[columnIndex];
    }

}
