package com.alex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by user on 07.01.2016.
 */
public class Database {

    private static Connection connection;

    private Database() {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:file:db\\univercity", "SA", "");
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        if (connection == null) {
            new Database();
        }

        return connection;
    }

    public static void Close() {

        if (connection == null) {
            return;
        }

        try {
            Statement st = connection.createStatement();
            st.execute("SHUTDOWN");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
