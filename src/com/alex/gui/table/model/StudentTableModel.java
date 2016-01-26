package com.alex.gui.table.model;

import com.alex.dao.StudentDAO;
import com.alex.gui.FilterPanel;
import com.alex.gui.GenericTableModel;
import com.alex.module.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 03.01.2016.
 */
public class StudentTableModel extends GenericTableModel<Student> {

    public StudentTableModel(List list) {
        super(list);
        columnNames = new String[]{"id", "name", "surname", "patronymic", "birth_date", "group"};
    }

    protected List getList(){

        List<Student> list = null;
        String surname = FilterPanel.txtFldSurname.getText();
        String group = FilterPanel.txtFldGroup.getText();
        StudentDAO studentDAO = (StudentDAO) getAbstractDao();

        if (surname.trim().length() > 0 && group.trim().length() == 0) {
            list = studentDAO.getBySurname(surname);
        } else if (surname.trim().length() > 0 && group.trim().length() > 0) {
            list = studentDAO.getBySurnameAndGroup(surname, group);
        } else if (surname.trim().length() == 0 && group.trim().length() > 0) {
            list = studentDAO.getByGroup(group);
        } else {
            list = studentDAO.getAll();
        }

        return list;
    }

    @Override
    protected Class getClassT() {
        return Student.class;
    }
}
