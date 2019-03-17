package com.psy.mybatis.mapper;

import java.util.List;

import com.psy.model.HomePageBanner;

public interface HomePageBannerMapper {
	public List<HomePageBanner> selectAll() throws Exception;
	
    int deleteByPrimaryKey(Integer id);

    int insert(HomePageBanner record);

    int insertSelective(HomePageBanner record);

    HomePageBanner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomePageBanner record);

    int updateByPrimaryKey(HomePageBanner record);
}