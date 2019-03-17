package com.psy.mybatis.mapper;

import java.util.List;

import com.psy.model.HomePageArticle;

public interface HomePageArticleMapper {
	
	public List<HomePageArticle> selectAll() throws Exception;
	
    int deleteByPrimaryKey(Integer id);

    int insert(HomePageArticle record);

    int insertSelective(HomePageArticle record);

    HomePageArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomePageArticle record);

    int updateByPrimaryKey(HomePageArticle record);
}