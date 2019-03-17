package com.psy.mybatis.mapper;

import java.util.List;

import com.psy.model.HomePageCourse;

public interface HomePageCourseMapper {
	public List<HomePageCourse> selectAll() throws Exception;
	
    int deleteByPrimaryKey(Integer id);

    int insert(HomePageCourse record);

    int insertSelective(HomePageCourse record);

    HomePageCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomePageCourse record);

    int updateByPrimaryKey(HomePageCourse record);
}