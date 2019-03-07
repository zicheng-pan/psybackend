package com.psy.dao;

import java.util.List;

public interface BaseDaoInterface<E> {
    int deleteByPrimaryKey(Integer id);

    int insert(E record);

    int insertSelective(E record);

    E selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(E record);

    int updateByPrimaryKey(E record);

    public List<E> selectAll() throws Exception;
}
