package com.psy.mybatis.mapper;

import java.util.List;

import com.psy.model.HomePageMenu;

public interface HomePageMenuMapper {
	public List<HomePageMenu> selectAll() throws Exception;
	
    int deleteByPrimaryKey(Integer id);

    int insert(HomePageMenu record);

    int insertSelective(HomePageMenu record);

    HomePageMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomePageMenu record);

    int updateByPrimaryKey(HomePageMenu record);
}