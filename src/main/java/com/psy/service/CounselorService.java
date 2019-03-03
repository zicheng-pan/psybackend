package com.psy.service;

import com.psy.model.Counselor;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

// for: https://therapis-uapi.knowyourself.cc/consultant?offset=20&page_size=20&city_id=&price_type=0&price_cut=0&method=
@Path("/consultant")
public class CounselorService {

//    @GET @Produces(MediaType.TEXT_PLAIN)
//    public String sayHello() {
//        return "Hello World!" ;
//    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Counselor> getAllCounselor(@DefaultValue("") @QueryParam("authCode") String authCode,
                                 @Context HttpServletRequest request) {
        String offset = request.getParameter("offset");
        String page_size = request.getParameter("page_size");
        String city_id = request.getParameter("city_id");
        String price_type = request.getParameter("price_type");
        String price_cut = request.getParameter("price_cut");

        List<Counselor> list = new ArrayList<Counselor>();
        Counselor c1 = new Counselor();
        c1.setName("name1");
        c1.setTitle("title1");
        Counselor c2 = new Counselor();
        c2.setName("name1");
        c2.setTitle(offset+" "+page_size+" "+city_id+" "+price_type+" "+price_cut);
        list.add(c1);
        list.add(c2);
        return list;
    }
}
