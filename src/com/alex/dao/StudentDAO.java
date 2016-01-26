package com.alex.dao;

import com.alex.module.Student;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by user on 30.12.2015.
 */
public class StudentDAO extends GenericDAO<Student> {

    private final String select = "select student.id, student.name, student.surname, student.patronymic, student.birth_date, student.id_group, grp.number from student, grp ";

    public StudentDAO() {
        super();
        tableName = "student";
    }

    @Override
    protected Student parseResultSet(ResultSet rs) throws Exception {

        return new Student(rs.getLong("student.id"), rs.getString("student.name"), rs.getString("student.surname"),
                rs.getString("student.patronymic"), rs.getDate("student.birth_date"), rs.getLong("student.id_group"),
                rs.getString("grp.number"));
    }

    @Override
    public void insert(Student object) {

        String expression = "INSERT INTO " + tableName
                + "( \"NAME\", \"SURNAME\", \"PATRONYMIC\", \"BIRTH_DATE\", \"ID_GROUP\" )"
                + "VALUES ( '" + object.getName() + "', '" + object.getSurname() + "', '" + object.getPatronymic()
                + "', '" + object.getBirthDateFormat() + "', " + object.getIdGroup() + ")";

        update(expression);
    }

    @Override
    public void update(Student object) {

        String expression = "UPDATE " + tableName
                + " SET NAME = '" + object.getName()
                + "', SURNAME = '" + object.getSurname()
                + "', PATRONYMIC = '" + object.getPatronymic()
                + "', BIRTH_DATE = '" + object.getBirthDateFormat()
                + "', ID_GROUP = '" + object.getIdGroup()
                + "' where id = " + object.getId();

        update(expression);
    }

    @Override
    public List<Student> getAll() {

        String expression = select + "where student.id_group = grp.id";

        return query(expression);
    }

    public List<Student> getByGroup(String numberGroup) {

        String expression = select + "where grp.number like '" + numberGroup + "%' " +
                "and student.id_group = grp.id";

        return query(expression);
    }

    public List<Student> getBySurname(String surname) {

        String expression = select + "where student.surname like '" + surname + "%' " +
                "and student.id_group = grp.id";

        return query(expression);
    }

    public List<Student> getBySurnameAndGroup(String surname, String numberGroup) {

        String expression = select + "where student.surname like '" + surname + "%' " +
                "and grp.number like '" + numberGroup + "%' " +
                "and student.id_group = grp.id";

        return query(expression);
    }

}
