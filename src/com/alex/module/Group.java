package com.alex.module;

/**
 * Created by user on 30.12.2015.
 */
public class Group implements ToArray{

    private long id;
    private String number;
    private String faculty;

    public Group(String number, String faculty){
        this.number = number;
        this.faculty = faculty;
    }

    public Group(long id, String number, String faculty){
        this.id = id;
        this.number = number;
        this.faculty = faculty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public Object[] toArray() {
        return new Object[]{id,number,faculty};
    }
}
