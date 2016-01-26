package com.alex.gui.table;

import com.alex.dao.FactoryDAO;
import com.alex.dao.StudentDAO;
import com.alex.gui.GenericTable;
import com.alex.module.Student;

import java.util.List;

/**
 * Created by user on 07.01.2016.
 */
public class StudentTable extends GenericTable<Student> {

    private static StudentTable studentTable;

    private StudentTable() {
        super();
    }

    public static StudentTable getStudentTable() {
        if (studentTable == null) {
            studentTable = new StudentTable();
        }

        return studentTable;
    }

    @Override
    protected Class<Student> getClassT() {
        return Student.class;
    }
}
