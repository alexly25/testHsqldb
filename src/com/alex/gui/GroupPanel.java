package com.alex.gui;

import com.alex.gui.panel.GroupEditPanel;
import com.alex.gui.table.GroupTable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 05.01.2016.
 */
public class GroupPanel extends JPanel {

    public GroupPanel(Frame frame) {
        super();

        JScrollPane scrollPaneTable = new JScrollPane();
        GroupTable groupTable = GroupTable.getGroupTable();
        scrollPaneTable.setViewportView(groupTable);

        setLayout(new BorderLayout());
        add(scrollPaneTable, BorderLayout.CENTER);
        add(new GroupEditPanel(frame), BorderLayout.SOUTH);
    }
}
