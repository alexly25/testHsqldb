package com.alex.gui;

import com.alex.dao.GenericDAO;
import com.alex.dao.FactoryDAO;
import com.alex.gui.field.CharField;
import com.alex.gui.table.FactoryTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 06.01.2016.
 */
public abstract class GenericDialog<T> extends JDialog {

    public GenericDialog(Frame frame) {
        super(frame, true);
        init();
        iniBtn();
    }

    private void iniBtn() {
        addBtn("Отмена", new CloseListener());
        addBtn("OK", new SaveListener());
    }

    protected void addBtn(String title, ActionListener actionListener) {
        JButton button = new JButton(title);
        button.addActionListener(actionListener);
        add(button);
    }


    protected CharField addCharField(int limit) {
        CharField charField = new CharField(limit);
        add(charField);
        return charField;
    }

    protected abstract void init();

    protected abstract T getObject();

    protected abstract void action(GenericDAO genericDAO, T object);

    protected GenericTable getTable() {
        return FactoryTable.getTable(getClassT());
    }

    protected GenericDAO getDAO() {
        return FactoryDAO.getDAO(getClassT());
    }

    protected abstract Class<T> getClassT();

    public class CloseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    public class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            T object = getObject();

            if(object == null){
                JOptionPane.showMessageDialog(null,
                        "Не верный формат данных.",
                        "Ошибка ввода",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            action(getDAO(), object);
            getTable().refresh(null);
            dispose();
        }
    }
}
