package com.alex.gui;

import com.alex.gui.panel.StudentEditPanel;
import com.alex.gui.table.StudentTable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 05.01.2016.
 */
public class StudentPanel extends JPanel {

    public StudentPanel(Frame frame) {
        super();

        JScrollPane scrollPaneTable = new JScrollPane();
        StudentTable studentTable = StudentTable.getStudentTable();
        scrollPaneTable.setViewportView(studentTable);

        setLayout(new BorderLayout());
        add(new FilterPanel(), BorderLayout.NORTH);
        add(scrollPaneTable, BorderLayout.CENTER);
        add(new StudentEditPanel(frame), BorderLayout.SOUTH);
    }
}
