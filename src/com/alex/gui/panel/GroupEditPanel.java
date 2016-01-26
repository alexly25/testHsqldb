package com.alex.gui.panel;

import com.alex.gui.GenericEditPanel;
import com.alex.gui.Frame;
import com.alex.gui.GenericTable;
import com.alex.module.Group;

/**
 * Created by user on 08.01.2016.
 */
public class GroupEditPanel extends GenericEditPanel<Group> {

    public GroupEditPanel(Frame frame) {
        super(frame);
    }

    @Override
    protected Class getClassT() {
        return Group.class;
    }
}
