package com.psy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.psy.model.HomePageMenu;
import com.psy.service.HomePageMenuService;
import com.psy.tool.ServerStatus;

@Path("/HomePageMenu")
public class HomePageMenuAction {
	HomePageMenuService homePageMenuService = new HomePageMenuService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ServerStatus<HomePageMenu> showAllList(@Context HttpServletRequest request) {
		List<HomePageMenu> list = homePageMenuService.listAll();
		return homePageMenuService.getFormatResult(list);
		
	}
}
