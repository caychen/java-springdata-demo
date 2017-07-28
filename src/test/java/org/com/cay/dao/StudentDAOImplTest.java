package org.com.cay.dao;

import java.util.List;

import org.com.cay.dao.impl.StudentDAOImpl;
import org.com.cay.entity.Student;
import org.junit.Test;

public class StudentDAOImplTest {

    @Test
     public void testQuery() {

        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " , name:" + student.getName()
                    + ", age:" + student.getAge());
        }

    }

    @Test
    public void testSave() {

        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(30);

        studentDAO.save(student);
    }

}
