package com.alex.gui.dialog.insert;

import com.alex.dao.GenericDAO;
import com.alex.gui.Frame;
import com.alex.gui.dialog.AbstractStudentDialog;
import com.alex.module.Student;

/**
 * Created by user on 06.01.2016.
 */
public class StudentInsertDialog extends AbstractStudentDialog {

    public StudentInsertDialog(Frame frame) {
        super(frame);
    }

    @Override
    protected void action(GenericDAO genericDAO, Student object) {
        genericDAO.insert(object);
    }

}
