package com.alex.dao;

import com.alex.module.Group;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by user on 02.01.2016.
 */
public class GroupDAO extends GenericDAO<Group> {

    public GroupDAO() {
        super();
        tableName = "grp";
    }

    @Override
    protected Group parseResultSet(ResultSet rs) throws Exception {

        return new Group(rs.getLong("id"), rs.getString("number"), rs.getString("faculty"));
    }

    @Override
    public void insert(Group object) {

        String expression = "INSERT INTO " + tableName
                + "( \"NUMBER\", \"FACULTY\" )"
                + "VALUES ( '" + object.getNumber() + "', '" + object.getFaculty() + "')";

        update(expression);
    }

    @Override
    public void update(Group object) {

        String expression = "UPDATE " + tableName
                + " SET FACULTY = '" + object.getFaculty()
                + "' where id = " + object.getId();

        update(expression);
    }

    @Override
    public List<Group> getAll() {

        String expression = "Select * from " + tableName;

        return query(expression);
    }

    public long getIdByNumber(String number) {

        String expression = "Select * from grp where number = '" + number + "'";

        List<Group> result = query(expression);

        return result.get(0).getId();
    }
}
