package com.alex.gui.dialog;

import com.alex.gui.Frame;
import com.alex.gui.GenericDialog;
import com.alex.gui.GenericTable;
import com.alex.gui.field.CharNumField;
import com.alex.module.Group;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 08.01.2016.
 */
public abstract class AbstractGroupDialog extends GenericDialog<Group> {

    private static final int DEFAULT_WIDTH = 230;
    private static final int DEFAULT_HEIGHT = 120;

    protected JTextField cnFldNumber;
    protected JTextField cFldFaculty;

    public AbstractGroupDialog(Frame frame) {
        super(frame);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new GridLayout(3, 2, 5, 5));
    }

    @Override
    protected void init() {
        add(new Label("number:"));
        cnFldNumber = new CharNumField(7);
        add(cnFldNumber);
        add(new Label("faculty:"));
        cFldFaculty = addCharField(30);
    }

    @Override
    protected Group getObject() {
        String number = cnFldNumber.getText();
        String faculty = cFldFaculty.getText();

        if(number.length() <= 0
                || faculty.length() <= 0){
            return null;
        }

        return new Group(number, faculty);
    }

    @Override
    protected Class<Group> getClassT() {
        return Group.class;
    }

}
