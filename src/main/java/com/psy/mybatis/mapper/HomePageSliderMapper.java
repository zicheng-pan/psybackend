package com.psy.mybatis.mapper;

import com.psy.model.HomePageSlider;

import java.util.List;

public interface HomePageSliderMapper {

    public List<HomePageSlider> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(HomePageSlider record);

    int insertSelective(HomePageSlider record);

    HomePageSlider selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomePageSlider record);

    int updateByPrimaryKey(HomePageSlider record);
}