package com.alex.gui.table;

import com.alex.gui.GenericTable;
import com.alex.module.Group;

/**
 * Created by user on 07.01.2016.
 */
public class GroupTable extends GenericTable<Group> {

    private static GroupTable groupTable;

    private GroupTable() {
        super();
    }

    public static GroupTable getGroupTable() {
        if (groupTable == null) {
            groupTable = new GroupTable();
        }

        return groupTable;
    }

    @Override
    protected Class<Group> getClassT() {
        return Group.class;
    }
}
