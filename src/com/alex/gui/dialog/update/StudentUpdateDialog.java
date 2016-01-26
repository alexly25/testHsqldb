package com.alex.gui.dialog.update;

import com.alex.dao.GenericDAO;
import com.alex.gui.Frame;
import com.alex.gui.dialog.AbstractStudentDialog;
import com.alex.module.Student;

import javax.swing.*;

/**
 * Created by user on 06.01.2016.
 */
public class StudentUpdateDialog extends AbstractStudentDialog {

    public StudentUpdateDialog(Frame frame){
        super(frame);
        init(getTable(), getTable().getSelectedRow());
    }

    private void init(JTable table, int row){
        cFldName.setText((String) table.getValueAt(row,1));
        cFldSurname.setText((String) table.getValueAt(row,2));
        cFldPatronymic.setText((String) table.getValueAt(row,3));
        cFldDate.setText((String) table.getValueAt(row,4));
        cmbBxGroup.setSelectedItem(table.getValueAt(row,5));
    }

    @Override
    protected Student getObject() {
        Student student = super.getObject();

        if(student == null){
            return null;
        }

        long id = (long) getTable().getValueAt(getTable().getSelectedRow(),0);
        student.setId(id);

        return student;
    }

    @Override
    protected void action(GenericDAO genericDAO, Student object) {
        genericDAO.update(object);
    }
}
