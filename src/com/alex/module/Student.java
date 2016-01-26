package com.alex.module;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 30.12.2015.
 */
public class Student implements ToArray{

    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date birthDate;
    private long idGroup;
    private String numberGroup;

    public Student(String name, String surname,
                   String patronymic, Date birthDate, long idGroup){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.idGroup = idGroup;
    }

    public Student(long id, String name, String surname,
                   String patronymic, Date birthDate, long idGroup){
        this(name, surname, patronymic, birthDate, idGroup);
        this.id = id;
    }

    public Student(long id, String name, String surname,
                   String patronymic, Date birthDate, long idGroup, String numberGroup){
        this(id, name, surname, patronymic, birthDate, idGroup);
        this.numberGroup = numberGroup;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthDateFormat() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = date.format(birthDate);
        return sDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public Object[] toArray(){
        return new Object[]{id,name,surname,patronymic,getBirthDateFormat(), numberGroup};
        //return new String[]{name,name,name,name,name,name};
    }
}
