package com.psy.service;

import com.psy.model.Counselor;
import com.psy.mybatis.mapper.CounselorMapper;

public class CounselorService extends BaseService<CounselorMapper,Counselor>{
    public static void main(String[] args) {
        new CounselorService().deleteByPrimaryKey(3);
    }
}
