package com.psy.service;

import com.psy.mybatis.mapper.UserMapper;

import java.util.List;

public class UserService<T> extends BaseService<UserMapper> {

    public List<T> listAll() {
        Object obj =(Object) super.selectAll();
        List<T> list = (List<T>) obj;
        return list;
    }
}
