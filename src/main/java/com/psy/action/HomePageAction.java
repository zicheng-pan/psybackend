package com.psy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.psy.model.HomePage;
import com.psy.model.HomePageArticle;
import com.psy.model.HomePageBanner;
import com.psy.model.HomePageCourse;
import com.psy.model.HomePageQuestion;
import com.psy.model.HomePageQuestionOption;
import com.psy.model.HomePageTest;
import com.psy.service.HomePageArticleService;
import com.psy.service.HomePageBannerService;
import com.psy.service.HomePageCourseService;
import com.psy.service.HomePageQuestionOpService;
import com.psy.service.HomePageQuestionService;
import com.psy.service.HomePageTestService;
import com.psy.tool.Result;

@Path("/wonder")
public class HomePageAction<E> {
	// 所有首页请求服务
	HomePageArticleService articleService = new HomePageArticleService();
	HomePageBannerService bannerService = new HomePageBannerService();
	HomePageCourseService courseService = new HomePageCourseService();
	HomePageTestService testService = new HomePageTestService();
	HomePageQuestionService homePageQuestionService = new HomePageQuestionService();
	HomePageQuestionOpService HomePageQuestionOpService = new HomePageQuestionOpService();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public HomePage<E> queryHomePage(@Context HttpServletRequest request){
		Logger logger = Logger.getLogger(this.getClass());
		logger.info("1111111");
		List<HomePageArticle> articles = articleService.listAll();
		List<HomePageBanner> banners = bannerService.listAll();
		List<HomePageCourse> courses = courseService.listAll();
		List<HomePageTest> homePageTests = testService.listAll();
		HomePage<E> serverStatus = new HomePage();
		// 文章列表
		Result<HomePageArticle> result1 = new Result<HomePageArticle>();
		result1.setCount(articles.size());
		result1.setList(articles);
		logger.info("22222222");
		// 轮播列表
		Result<HomePageBanner> result2 = new Result<HomePageBanner>();
		result2.setCount(banners.size());
		result2.setList(banners);
		// 课程列表
		Result<HomePageCourse> result3 = new Result<HomePageCourse>();
		result3.setCount(courses.size());
		result3.setList(courses);
		// 测试列表
		Result<HomePageTest> result4 = new Result<HomePageTest>();
		result4.setCount(homePageTests.size());
		result4.setList(homePageTests);
		serverStatus.setStatus("success");
		Map<String, Result> resMap = new HashMap<String, Result>();
		resMap.put("article_list", result1);
		resMap.put("banner_list", result2);
		resMap.put("course_list", result3);
		resMap.put("test_list", result4);
		serverStatus.setResult(resMap);
		return serverStatus;
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/getQuestion")
	public Map<String, Object> queryHomePageQuestion(@Context HttpServletRequest request){
		// 定义一个返回的map集合
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 根据测试编号来获取测试标题
		String testId = request.getParameter("testId");
		Integer id = 0;
		if (!"".equals(testId)) {
			id = Integer.parseInt(testId);
		}
		// 获取数据
		List<HomePageQuestion> pageQuestions = homePageQuestionService.selectQuestion(id);
		Map<String, Object> resultList = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		// 获取测试问题编号
		resultList.put("status", "success");
		for (HomePageQuestion question: pageQuestions) {
			Integer questionId = question.getQuestionId();
			// 通过测试问题编号获取数据
			List<HomePageQuestionOption> options = HomePageQuestionOpService.selectAllByQuestionId(questionId);
			if (question != null){
				resultMap.put("question", question.getQuestionTitle());
			}
			// 新建一个字符串的map集合
			Map<String, String> map = new HashMap<String, String>();
			if (null != options && options.size() != 0) {
				for (HomePageQuestionOption eo: options) {
					// 循环获取问题属性
					map.put(eo.getQuestionOption(), eo.getQuestionName());
				}
				resultMap.put("option", map);
			}
			list.add(resultMap);
		}
		resultList.put("result", list);
		return resultList;
	}
}
