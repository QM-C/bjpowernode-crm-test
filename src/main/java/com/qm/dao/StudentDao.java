package com.qm.dao;

import com.qm.domain.Student;

import java.util.List;

/**
 * @projectName: bjpowerndoe-crm
 * @package: com.qm.dao
 * @className: StudentDao
 * @author: 清明
 * @description: TODO
 * @date: 2022/1/2 20:31
 * @version: 1.0
 */
public interface StudentDao
{
    List<Student> selectAllStudents();

    Student getById(String id);

    int addAStudent(Student student);
}
