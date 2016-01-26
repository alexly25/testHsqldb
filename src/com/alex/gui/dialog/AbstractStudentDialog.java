package com.alex.gui.dialog;

import com.alex.dao.FactoryDAO;
import com.alex.dao.GroupDAO;
import com.alex.gui.FilterPanel;
import com.alex.gui.Frame;
import com.alex.gui.GenericDialog;
import com.alex.gui.GenericTable;
import com.alex.gui.table.FactoryTable;
import com.alex.gui.table.StudentTable;
import com.alex.module.Group;
import com.alex.module.Student;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by user on 07.01.2016.
 */
public abstract class AbstractStudentDialog extends GenericDialog<Student> {

    private static final int DEFAULT_WIDTH = 280;
    private static final int DEFAULT_HEIGHT = 205;

    protected JTextField cFldName;
    protected JTextField cFldSurname;
    protected JTextField cFldPatronymic;
    protected JTextField cFldDate;
    protected JComboBox cmbBxGroup;

    public AbstractStudentDialog(Frame frame) {
        super(frame);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new GridLayout(6, 2, 5, 5));
    }

    @Override
    protected void init() {
        add(new Label("name:"));
        cFldName = addCharField(15);
        add(new Label("surname:"));
        cFldSurname = addCharField(15);
        add(new Label("patronymic:"));
        cFldPatronymic = addCharField(15);
        add(new Label("birth_date(yyyy-mm-dd):"));
        cFldDate = addFTFDate("####-##-##");
        add(new Label("group:"));
        cmbBxGroup = addComboBox();
    }

    protected JFormattedTextField addFTFDate(String mask){
        JFormattedTextField result = null;
        MaskFormatter maskFormatter = null;

        try {
            maskFormatter = new MaskFormatter(mask);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        result = new JFormattedTextField(maskFormatter);
        add(result);
        return result;
    }

    private JComboBox addComboBox() {
        GroupDAO groupDAO = (GroupDAO) FactoryDAO.getDAO(Group.class);
        JComboBox comboBoxNumber = new JComboBox();
        ArrayList<Group> list = (ArrayList) groupDAO.getAll();

        for (int i = 0; i < list.size(); i++) {
            comboBoxNumber.addItem(list.get(i).getNumber());
        }

        add(comboBoxNumber);
        return comboBoxNumber;
    }

    @Override
    protected Student getObject() {

        GroupDAO groupDAO = (GroupDAO) FactoryDAO.getDAO(Group.class);
        String name = cFldName.getText();
        String surname = cFldSurname.getText();
        String patronymic = cFldPatronymic.getText();
        Date birthDate = null;
        long idGroup = groupDAO.getIdByNumber((String) cmbBxGroup.getSelectedItem());

        if (name.length() <= 0
                || surname.length() <= 0
                || patronymic.length() <= 0) {
            return null;
        }

        try {
            birthDate = getBirthDate(cFldDate.getText());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        System.out.println(name+"} {"+surname+"} {"+patronymic+"}");
        return new Student(name, surname, patronymic, birthDate, idGroup);
    }

    private Date getBirthDate(String birthDateFormat) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = simpleDateFormat.parse(birthDateFormat);
        return birthDate;
    }

    @Override
    protected Class<Student> getClassT() {
        return Student.class;
    }
}
