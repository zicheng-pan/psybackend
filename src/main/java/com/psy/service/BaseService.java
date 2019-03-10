package com.psy.service;

import com.psy.dao.BaseDao;
import com.psy.tool.Result;
import com.psy.tool.ServerStatus;

import java.util.List;

public abstract class BaseService<T, E> extends BaseDao<T> {

    public List<E> listAll() {
        Object obj = (Object) super.selectAll();
        List<E> list = (List<E>) obj;
        return list;
    }

    public ServerStatus<E> getFormatResult(List<E> list) {
        ServerStatus<E> serverStatus = new ServerStatus();
        serverStatus.setStatus("success");
        Result<E> result = new Result<E>();
        result.setCount(list.size());
        result.setList(list);
        serverStatus.setResult(result);
        return serverStatus;
    }
}
