package com.qm.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @projectName: bjpowerndoe-crm
 * @package: com.qm.util
 * @className: SqlSessionUtil
 * @author: 清明
 * @description: 工具类，进行SqlSession对象的创建和销毁工作
 * @date: 2022/1/2 20:38
 * @version: 1.0
 */
public class SqlSessionUtil
{
    //重量级对象，有一个就够了
    private static final SqlSessionFactory sqlSessionFactory;

    private static final ThreadLocal<SqlSession> t = new ThreadLocal<>();

    //静态代码块，用于执行注册驱动，初始化等操作
    static
    {
        //mybatis主配置文件的路径
        final String path = "mybatis.xml";

        //创建InputStream流，并且读取路径文件，其中要使用到mybatis框架的类Resources的getResourcesAsStream()方法
        InputStream inputStream = null;

        try
        {
            inputStream = Resources.getResourceAsStream(path);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //使用SqlSessionFactoryBuilder的builder方法，传入InputStream流创建SqlSessionFactory对象
        if (inputStream != null)
        {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        else
        {
            throw new RuntimeException("流为空");
        }
    }

    /**
     * 工具类，私有构造方法，防止new对象
     */
    private SqlSessionUtil()
    {
    }

    public static SqlSession getSqlSession()
    {
        SqlSession sqlSession = t.get();
        if (sqlSession == null)
        {
            sqlSession = sqlSessionFactory.openSession();
            t.set(sqlSession);
        }

        return sqlSession;
    }

    public static void close(SqlSession session)
    {
        if (session != null)
        {
            session.close();
            t.remove();
        }
    }
}
