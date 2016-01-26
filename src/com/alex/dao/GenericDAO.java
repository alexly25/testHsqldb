package com.alex.dao;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 30.12.2015.
 */
public abstract class GenericDAO<T> {

    private Connection connection;
    protected String tableName;

    GenericDAO() {
        connection = Database.getConnection();
    }

    protected abstract T parseResultSet(ResultSet rs) throws Exception;

    public abstract void insert(T object);

    public abstract void update(T object);

    public void deleteById(long id) {
        String expression = "DELETE FROM " + tableName
                + " where id = " + id;
        update(expression);
    }

    public abstract List<T> getAll();

    protected List<T> query(String expression) {
        ResultSet resultSet = null;
        List<T> result = new ArrayList<>();

        try (Statement statement = connection.createStatement()){
            resultSet = statement.executeQuery(expression);

            while (resultSet.next()) {
                T object = parseResultSet(resultSet);
                result.add(object);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ошибка чтения БД: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    protected void update(String expression) {

        try (Statement statement = connection.createStatement()){

            int i = statement.executeUpdate(expression);

            if (i == -1) {
                System.out.println("update(" + expression + ") = -1");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
