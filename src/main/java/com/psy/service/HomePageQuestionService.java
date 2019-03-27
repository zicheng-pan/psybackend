package com.psy.service;

import java.util.List;

import com.psy.model.HomePageQuestion;
import com.psy.mybatis.mapper.HomePageQuestionMapper;

public class HomePageQuestionService extends BaseService<HomePageQuestionMapper, HomePageQuestion> {
	
	public List<HomePageQuestion> selectQuestion (Integer testId) {
		HomePageQuestionMapper mapper = getMapper();
		return mapper.selectByTestId(testId);
	}
}
