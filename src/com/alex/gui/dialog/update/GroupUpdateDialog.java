package com.alex.gui.dialog.update;

import com.alex.dao.GenericDAO;
import com.alex.gui.Frame;
import com.alex.gui.dialog.AbstractGroupDialog;
import com.alex.module.Group;

import javax.swing.*;

/**
 * Created by user on 09.01.2016.
 */
public class GroupUpdateDialog extends AbstractGroupDialog {

    public GroupUpdateDialog(Frame frame) {
        super(frame);
        init(getTable(), getTable().getSelectedRow());
    }

    private void init(JTable table, int row){
        cnFldNumber.setText((String) table.getValueAt(row,1));
        cFldFaculty.setText((String) table.getValueAt(row, 2));
    }

    @Override
    protected Group getObject() {
        Group group = super.getObject();

        if(group == null){
            return null;
        }

        long id = (long) getTable().getValueAt(getTable().getSelectedRow(),0);
        group.setId(id);

        return group;
    }

    @Override
    protected void action(GenericDAO genericDAO, Group object) {
        genericDAO.update(object);
    }

}
