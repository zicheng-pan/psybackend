package com.psy.mybatis.mapper;

import com.psy.model.Counselor;

import java.util.List;

public interface CounselorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Counselor record);

    int insertSelective(Counselor record);

    Counselor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Counselor record);

    int updateByPrimaryKey(Counselor record);

    public List<Counselor> selectAllCounselor() throws Exception;
}