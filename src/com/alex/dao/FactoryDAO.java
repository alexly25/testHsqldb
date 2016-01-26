package com.alex.dao;

import com.alex.module.Group;
import com.alex.module.Student;

/**
 * Created by user on 07.01.2016.
 */
public class FactoryDAO {

    public static GenericDAO getDAO(Class c) {

        if (c == Student.class) {
            return new StudentDAO();
        } else if (c == Group.class) {
            return new GroupDAO();
        }

        return null;
    }
}
