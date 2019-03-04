package com.psy.mybatis.mapper;

import com.psy.model.HomePageSlider;

public interface HomePageSliderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HomePageSlider record);

    int insertSelective(HomePageSlider record);

    HomePageSlider selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomePageSlider record);

    int updateByPrimaryKey(HomePageSlider record);
}