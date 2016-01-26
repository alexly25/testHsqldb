package com.alex.gui.table.model;

import com.alex.gui.GenericTableModel;
import com.alex.module.Group;

import java.util.List;

/**
 * Created by user on 05.01.2016.
 */
public class GroupTableModel extends GenericTableModel<Group> {

    public GroupTableModel(List list) {
        super(list);
        columnNames = new String[]{"id", "number", "faculty"};
    }

    @Override
    protected List getList() {
        return getAbstractDao().getAll();
    }

    @Override
    protected Class getClassT() {
        return Group.class;
    }
}
