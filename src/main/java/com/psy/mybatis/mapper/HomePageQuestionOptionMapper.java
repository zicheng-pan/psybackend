package com.psy.mybatis.mapper;

import java.util.List;

import com.psy.model.HomePageQuestionOption;

public interface HomePageQuestionOptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HomePageQuestionOption record);

    int insertSelective(HomePageQuestionOption record);

    HomePageQuestionOption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomePageQuestionOption record);

    int updateByPrimaryKey(HomePageQuestionOption record);
    
    List<HomePageQuestionOption> selectAllByQuestionId(Integer questionId);
}