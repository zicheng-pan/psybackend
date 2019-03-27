package com.psy.mybatis.mapper;

import java.util.List;

import com.psy.model.HomePageQuestion;

public interface HomePageQuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(HomePageQuestion record);

    int insertSelective(HomePageQuestion record);

    HomePageQuestion selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(HomePageQuestion record);

    int updateByPrimaryKey(HomePageQuestion record);
    
    List<HomePageQuestion> selectByTestId(Integer testId);
}