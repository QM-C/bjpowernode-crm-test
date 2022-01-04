package com.qm.domain;

/**
 * @projectName: bjpowerndoe-crm
 * @package: com.qm.domain
 * @className: Student
 * @author: 清明
 * @description: TODO
 * @date: 2022/1/2 20:24
 * @version: 1.0
 */
public class Student
{
    private String id;
    private String name;
    private Integer age;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
