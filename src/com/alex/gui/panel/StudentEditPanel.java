package com.alex.gui.panel;

import com.alex.gui.FilterPanel;
import com.alex.gui.GenericEditPanel;
import com.alex.gui.Frame;
import com.alex.gui.GenericTable;
import com.alex.gui.table.StudentTable;
import com.alex.module.Student;

/**
 * Created by user on 08.01.2016.
 */
public class StudentEditPanel extends GenericEditPanel<Student> {

    public StudentEditPanel(Frame frame) {
        super(frame);
    }

    @Override
    protected Class getClassT() {
        return Student.class;
    }
}
