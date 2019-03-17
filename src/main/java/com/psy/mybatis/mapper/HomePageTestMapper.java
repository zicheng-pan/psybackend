package com.psy.mybatis.mapper;

import java.util.List;

import com.psy.model.HomePageTest;

public interface HomePageTestMapper {
	
	public List<HomePageTest> selectAll() throws Exception;
	
    int deleteByPrimaryKey(Integer id);

    int insert(HomePageTest record);

    int insertSelective(HomePageTest record);

    HomePageTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomePageTest record);

    int updateByPrimaryKey(HomePageTest record);
}