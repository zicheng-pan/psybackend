package com.psy.mybatis.mapper;

import com.psy.model.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectAllUser() throws Exception;
}
