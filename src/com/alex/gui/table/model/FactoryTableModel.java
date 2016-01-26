package com.alex.gui.table.model;

import com.alex.gui.GenericTableModel;
import com.alex.module.Group;
import com.alex.module.Student;

import java.util.List;

/**
 * Created by user on 07.01.2016.
 */
public class FactoryTableModel {

    public static GenericTableModel getTableModel(Class c, List list) {

        if (c == Student.class) {
            return new StudentTableModel(list);
        } else if (c == Group.class) {
            return new GroupTableModel(list);
        }

        return null;
    }
}
