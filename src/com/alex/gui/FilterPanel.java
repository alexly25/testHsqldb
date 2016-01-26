package com.alex.gui;

import com.alex.dao.FactoryDAO;
import com.alex.dao.StudentDAO;
import com.alex.gui.table.FactoryTable;
import com.alex.gui.table.StudentTable;
import com.alex.module.Student;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;

/**
 * Created by user on 03.01.2016.
 */
public class FilterPanel extends JPanel{

    public static final JTextField txtFldSurname = new JTextField();
    public static final JTextField txtFldGroup = new JTextField();

    public FilterPanel(){
        super();

        setLayout(new GridLayout(2,2,3,3));
        setBorder(new TitledBorder("Фильтр"));

        add(new JLabel("Фамилия:"));
        addTextField(txtFldSurname);
        add(new JLabel("Группа:"));
        addTextField(txtFldGroup);
    }

    private void addTextField(JTextField jTextField){
        jTextField.addKeyListener(new FieldListener());
        add(jTextField);
    }

    public class FieldListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            FactoryTable.getTable(Student.class).refresh(null);
        }
    }
}
