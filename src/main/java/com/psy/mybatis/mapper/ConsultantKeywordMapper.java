package com.psy.mybatis.mapper;

import java.util.List;

import com.psy.model.ConsultantKeyword;

public interface ConsultantKeywordMapper {
	
	List<ConsultantKeyword> selectAll();
    int deleteByPrimaryKey(Integer id);

    int insert(ConsultantKeyword record);

    int insertSelective(ConsultantKeyword record);

    ConsultantKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsultantKeyword record);

    int updateByPrimaryKey(ConsultantKeyword record);
}