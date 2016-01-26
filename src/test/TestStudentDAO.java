package test;

import com.alex.dao.StudentDAO;
import com.alex.module.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by user on 12.01.2016.
 */
public class TestStudentDAO {

    StudentDAO studentDAO;

    @Before
    public void testStudentDAO(){
        studentDAO = new StudentDAO();
    }

    @Test
    public void testInsert(){

        List oldList = studentDAO.getAll();

        Student student = new Student("test1", "test1", "test1", new Date(), 1);
        studentDAO.insert(student);

        ArrayList<Student> newList = (ArrayList) studentDAO.getAll();

        assertEquals(oldList.size()+1,newList.size());
        assertEquals("test1",newList.get(newList.size()-1).getName());

    }

    @Test
    public void testUpdate(){
        ArrayList<Student> newList = (ArrayList) studentDAO.getAll();
        String newName = "test2";
        Student student = newList.get(newList.size()-1);
        String studentName = student.getName();

        assertNotEquals(newName,studentName);

        student.setName(newName);
        studentDAO.update(student);

        student = newList.get(newList.size()-1);
        studentName = student.getName();
        assertEquals(newName,studentName);
    }
}
