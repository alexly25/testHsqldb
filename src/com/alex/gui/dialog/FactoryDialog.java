package com.alex.gui.dialog;

import com.alex.gui.GenericEditPanel;
import com.alex.gui.Frame;
import com.alex.gui.GenericDialog;
import com.alex.gui.dialog.insert.GroupInsertDialog;
import com.alex.gui.dialog.insert.StudentInsertDialog;
import com.alex.gui.dialog.update.GroupUpdateDialog;
import com.alex.gui.dialog.update.StudentUpdateDialog;
import com.alex.module.Group;
import com.alex.module.Student;

/**
 * Created by user on 09.01.2016.
 */
public class FactoryDialog {

    public static GenericDialog getDialog(Class c, Frame frame, int activity) {

        if (c == Student.class) {

            if (activity == GenericEditPanel.INSERT) {
                return new StudentInsertDialog(frame);
            } else if (activity == GenericEditPanel.UPDATE) {
                return new StudentUpdateDialog(frame);
            }

        } else if (c == Group.class) {

            if (activity == GenericEditPanel.INSERT) {
                return new GroupInsertDialog(frame);
            } else if (activity == GenericEditPanel.UPDATE) {
                return new GroupUpdateDialog(frame);
            }
        }

        return null;
    }
}
