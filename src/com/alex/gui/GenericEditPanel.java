package com.alex.gui;

import com.alex.dao.GenericDAO;
import com.alex.dao.FactoryDAO;
import com.alex.gui.dialog.FactoryDialog;
import com.alex.gui.table.FactoryTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 03.01.2016.
 */
public abstract class GenericEditPanel<T> extends JPanel {

    public static final int INSERT = 0;
    public static final int UPDATE = 1;

    Frame frame;

    public GenericEditPanel(Frame frame) {
        super();
        this.frame = frame;

        addBtn("Добавить", new InsertAction());
        addBtn("Изменить", new UpdateAction());
        addBtn("Удалить", new DeleteAction());
    }

    protected abstract Class getClassT();

    protected GenericTable getTable() {
        return FactoryTable.getTable(getClassT());
    }

    protected GenericDAO getDAO() {
        return FactoryDAO.getDAO(getClassT());
    }

    private void addBtn(String title, ActionListener actionListener) {
        JButton button = new JButton(title);
        button.addActionListener(actionListener);
        add(button);
    }

    class InsertAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FactoryDialog.getDialog(getClassT(), frame, INSERT).setVisible(true);
        }
    }

    class UpdateAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (getTable().getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(frame,
                        "Выберите одну строку для редактирования.");
                return;
            }

            FactoryDialog.getDialog(getClassT(), frame, UPDATE).setVisible(true);
        }
    }

    class DeleteAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (getTable().getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(frame,
                        "Выберите одну строку для удаления.");
                return;
            }

            long id = getTable().getSelectedObjectId();
            getDAO().deleteById(id);
            getTable().refresh(null);
        }
    }
}
