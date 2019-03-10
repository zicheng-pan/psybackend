package com.psy.dao;

import com.psy.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;

public class BaseDao<T> implements BaseDaoInterface<Object> {

    protected Logger logger = Logger.getLogger(this.getClass());
    private HashMap methodMap = new HashMap<String, Method>();
    //get T class details
    private Class<T> entityClass = null;
    private SqlSession session = null;
    private T mapper = null;


    public BaseDao() {
        getMapper();
    }

    public SqlSession getSession() {
        if (session == null) {
            session = MybatisUtil.openSqlSession();
        }
        return session;
    }

    public void setEntityClass() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        entityClass = (Class<T>) type.getActualTypeArguments()[0];
    }

    public T getMapper() {

        if (session == null)
            session = MybatisUtil.openSqlSession();

        if (mapper == null) {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            entityClass = (Class<T>) type.getActualTypeArguments()[0];
            mapper = session.getMapper(entityClass);
            //getAllMethods
            try {
                Method[] methods = getMapper().getClass().getDeclaredMethods();
                for (Method m : methods) {
                    System.out.println(m.getName());
                    methodMap.put(m.getName(), m);
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e);
            }

            return mapper;
        } else {
            return mapper;
        }
    }

    public boolean isMatchMethod(String methodName) {
        if (!"".equals(methodName) && methodMap.containsKey(methodName))
            return true;
        else
            return false;
    }

    public void commit() throws InvocationTargetException, IllegalAccessException {
        if (session != null) {
            session.commit();
            //TODO investigate if close or not
//            close();
        }
    }

    public void close() {
        if (session != null) {
            session.close();
            mapper = null;
            session = null;
        }
    }

    public int executeDeletorUpdate(String methodName, Object obj) {
        int result = 0;
        if (obj == null)
            return 0;
        if (session == null) {
            getSession();
            mapper = getMapper();
        }
        if (isMatchMethod(methodName)) {
            Method m = (Method) methodMap.get(methodName);
            try {
                result = (Integer) m.invoke(mapper, obj);
                commit();
            } catch (Exception e) {
                e.printStackTrace();
//                close();
                logger.error(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return executeDeletorUpdate("deleteByPrimaryKey", id);
    }

    @Override
    public int insert(Object record) {
        return executeDeletorUpdate("insert", record);
    }

    @Override
    public int insertSelective(Object record) {
        return executeDeletorUpdate("insertSelective", record);
    }

    @Override
    public Object selectByPrimaryKey(Integer id) {
        return executeDeletorUpdate("selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(Object record) {
        return executeDeletorUpdate("updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(Object record) {
        return executeDeletorUpdate("updateByPrimaryKey", record);
    }

    @Override
    public List<Object> selectAll() {
        if (session == null) {
            session = getSession();
            mapper = session.getMapper(entityClass);
        }

        String methodName = "selectAll";
        List<Object> list = null;
        if (isMatchMethod(methodName)) {
            Method m = (Method) methodMap.get(methodName);
            try {
                list = (List<Object>) m.invoke(mapper);
            } catch (Exception e) {
                e.printStackTrace();
//                close();
                logger.error(e.getMessage());
            }
        }
        return list;

    }

}
