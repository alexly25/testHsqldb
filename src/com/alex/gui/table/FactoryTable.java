package com.alex.gui.table;

import com.alex.gui.GenericTable;
import com.alex.module.Group;
import com.alex.module.Student;

/**
 * Created by user on 07.01.2016.
 */
public class FactoryTable {

    public static GenericTable getTable(Class c) {

        if (c == Student.class) {
            return StudentTable.getStudentTable();
        } else if (c == Group.class) {
            return GroupTable.getGroupTable();
        }

        return null;
    }
}
