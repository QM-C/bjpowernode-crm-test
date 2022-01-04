package com.qm.main;

import com.qm.dao.StudentDao;
import com.qm.domain.Student;
import com.qm.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @projectName: bjpowerndoe-crm
 * @package: com.qm.main
 * @className: TestHelloWorld
 * @author: 清明
 * @description: TODO
 * @date: 2022/1/2 20:37
 * @version: 1.0
 */
public class TestHelloWorld
{
    @Test
    public void TestSelectAllStudents()
    {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.selectAllStudents();
        students.forEach(System.out::println);
        System.out.println(mapper.getById("A0001"));
        Student student = new Student();
        student.setId("C0003");
        student.setName("nqbi");
        student.setAge(100);
        System.out.println(mapper.addAStudent(student));
        sqlSession.commit();
        students = mapper.selectAllStudents();
        students.forEach(System.out::println);
        SqlSessionUtil.close(sqlSession);
    }
}
