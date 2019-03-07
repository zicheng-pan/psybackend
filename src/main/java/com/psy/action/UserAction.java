package com.psy.action;

import com.psy.model.User;
import com.psy.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/User")
public class UserAction {

    private UserService userService = new UserService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public List<User> getAllUsers(@Context HttpServletRequest request) {

        List<User> userList = userService.listAll();
        return userList;
    }
}
