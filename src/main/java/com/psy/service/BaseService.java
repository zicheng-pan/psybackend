package com.psy.service;

import com.psy.dao.BaseDao;

import java.util.List;

public abstract class BaseService<T,E> extends BaseDao<T> {

    public List<E> listAll() {
        Object obj =(Object) super.selectAll();
        List<E> list = (List<E>) obj;
        return list;
    }
}
