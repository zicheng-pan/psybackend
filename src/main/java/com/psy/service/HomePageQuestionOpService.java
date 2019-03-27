package com.psy.service;

import java.util.List;

import com.psy.model.HomePageQuestionOption;
import com.psy.mybatis.mapper.HomePageQuestionOptionMapper;

public class HomePageQuestionOpService extends BaseService<HomePageQuestionOptionMapper, HomePageQuestionOption>{
	public List<HomePageQuestionOption> selectAllByQuestionId (Integer questionId) {
		// 获取mapper
		HomePageQuestionOptionMapper mapper = getMapper();
		return mapper.selectAllByQuestionId(questionId);
	}
}
