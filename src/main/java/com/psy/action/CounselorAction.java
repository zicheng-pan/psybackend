package com.psy.action;

import com.psy.model.ConsultantKeyword;
import com.psy.model.Counselor;
import com.psy.mybatis.mapper.CounselorMapper;
import com.psy.service.BaseService;
import com.psy.service.ConsultantKeywordService;
import com.psy.service.CounselorService;
import com.psy.tool.Result;
import com.psy.tool.ServerStatus;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// for: https://therapis-uapi.knowyourself.cc/consultant?offset=20&page_size=20&city_id=&price_type=0&price_cut=0&method=
@Path("/consultant")
public class CounselorAction {
	private CounselorService counselorService = new CounselorService();
	private ConsultantKeywordService consultantKeywordService = new ConsultantKeywordService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getAllCounselor")
    public ServerStatus<Counselor> getAllCounselor(@Context HttpServletRequest request) {
    	List<ConsultantKeyword> keywords = consultantKeywordService.listAll();
    	List<Counselor> list = counselorService.listAll();
    	for (Counselor counselor : list) {
    		counselor.setTags(keywords);
    	}
    	return counselorService.getFormatResult(list);
    }
    
}
