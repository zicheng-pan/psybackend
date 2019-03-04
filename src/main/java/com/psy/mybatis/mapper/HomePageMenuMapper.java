package com.psy.mybatis.mapper;

import com.psy.model.HomePageMenu;

public interface HomePageMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HomePageMenu record);

    int insertSelective(HomePageMenu record);

    HomePageMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomePageMenu record);

    int updateByPrimaryKey(HomePageMenu record);
}