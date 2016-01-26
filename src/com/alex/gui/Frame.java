package com.alex.gui;

import com.alex.dao.Database;
import com.alex.dao.GroupDAO;
import com.alex.dao.StudentDAO;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by user on 03.01.2016.
 */
public class Frame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 400;

    public Frame(){
        super();
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        addWindowListener(new ClosingListener());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Студенты", new StudentPanel(this));
        tabbedPane.add("Группы", new GroupPanel(this));
        getContentPane().add(tabbedPane);

    }

    public static void main(String[] args) {

        JFrame frame = new Frame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);

    }

    static class ClosingListener implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            Database.Close();
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}

