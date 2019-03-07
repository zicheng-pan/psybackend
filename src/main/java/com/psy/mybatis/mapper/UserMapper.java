package com.psy.mybatis.mapper;

import com.psy.model.User;

import java.util.List;

public interface UserMapper {

    public List<User> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}