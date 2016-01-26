package com.alex.gui.dialog.insert;

import com.alex.dao.GenericDAO;
import com.alex.gui.Frame;
import com.alex.gui.dialog.AbstractGroupDialog;
import com.alex.module.Group;

/**
 * Created by user on 09.01.2016.
 */
public class GroupInsertDialog extends AbstractGroupDialog {

    public GroupInsertDialog(Frame frame) {
        super(frame);
    }

    @Override
    protected void action(GenericDAO genericDAO, Group object) {
        genericDAO.insert(object);
    }
}
