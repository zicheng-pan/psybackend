package com.psy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    public static SqlSessionFactory sqlSessionFactory;
    public static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();

    static {
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream("mybatis.cfg.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("loading file mybatis.cfg.xml error");
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static SqlSession openSqlSession() {
        SqlSession sqlSession = tl.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            tl.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSqlSession() {
        //获取SqlSession
        SqlSession sqlSession = openSqlSession();
        sqlSession.close();
        tl.remove();
    }

    public static void commit() {
        SqlSession sqlSession = openSqlSession();
        sqlSession.commit();
        closeSqlSession();
    }

    public static void rollback() {
        SqlSession sqlSession = openSqlSession();
        sqlSession.rollback();
        closeSqlSession();
    }

    public static Object getMapper(Class clazz) {
        SqlSession sqlSession = openSqlSession();
        return sqlSession.getMapper(clazz);
    }

}
