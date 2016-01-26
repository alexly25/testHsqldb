package test;

import com.alex.dao.GroupDAO;
import com.alex.module.Group;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 13.01.2016.
 */
public class TestGroupDAO {

    GroupDAO groupDAO;

    @Before
    public void testGroupDAO(){
        groupDAO = new GroupDAO();
    }

    @Test
    public void testInsert(){

        List oldList = groupDAO.getAll();

        Group group = new Group("test1","test1");
        groupDAO.insert(group);

        ArrayList<Group> newList = (ArrayList) groupDAO.getAll();

        assertEquals(oldList.size()+1,newList.size());
        assertEquals("test1",newList.get(newList.size()-1).getNumber());

    }

    @Test
    public void testUpdate(){
        ArrayList<Group> newList = (ArrayList) groupDAO.getAll();
        String newFaculty = "test2";
        Group group = newList.get(newList.size()-1);
        String groupFaculty = group.getFaculty();

        assertNotEquals(newFaculty,groupFaculty);

        group.setNumber(newFaculty);
        groupDAO.update(group);

        group = newList.get(newList.size()-1);
        groupFaculty = group.getNumber();
        assertEquals(newFaculty,groupFaculty);
    }
}
