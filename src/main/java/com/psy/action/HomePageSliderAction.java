package com.psy.action;

import com.psy.model.HomePageSlider;
import com.psy.service.HomePageSliderService;
import com.psy.tool.ServerStatus;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/HomePageSlider")
public class HomePageSliderAction {

    HomePageSliderService service = new HomePageSliderService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ServerStatus<HomePageSlider> showAllList(@Context HttpServletRequest request) {

        List<HomePageSlider> list = service.listAll();
        Logger logger = Logger.getLogger(this.getClass());

        return service.getFormatResult(list);
    }
}
