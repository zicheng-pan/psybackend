package com.psy.action;

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
import com.psy.model.HomePageTest;
import com.psy.service.HomePageArticleService;
import com.psy.service.HomePageBannerService;
import com.psy.service.HomePageCourseService;
import com.psy.service.HomePageTestService;
import com.psy.tool.Result;

@Path("/wonder")
public class HomePageAction<E> {
	// 所有首页请求服务
	HomePageArticleService articleService = new HomePageArticleService();
	HomePageBannerService bannerService = new HomePageBannerService();
	HomePageCourseService courseService = new HomePageCourseService();
	HomePageTestService testService = new HomePageTestService();
	
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
}
