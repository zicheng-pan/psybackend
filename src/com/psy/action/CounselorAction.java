package com.psy.action;

import com.psy.model.Counselor;
import com.psy.mybatis.mapper.CounselorMapper;
import com.psy.service.BaseService;
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
public class CounselorAction extends BaseService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ServerStatus getAllCounselor(@DefaultValue("") @QueryParam("authCode") String authCode,
                                        @Context HttpServletRequest request) {
        String offset = request.getParameter("offset");
        String page_size = request.getParameter("page_size");
        String city_id = request.getParameter("city_id");
        String price_type = request.getParameter("price_type");
        String price_cut = request.getParameter("price_cut");

        {
            SqlSessionFactory sqlSessionFactory = null;

            String resource = "mybatis.cfg.xml";


            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }


            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            List<Counselor> userList = null;
            SqlSession session = sqlSessionFactory.openSession();

            CounselorMapper mapper = session.getMapper(CounselorMapper.class);
            try {
                userList = mapper.selectAll();
                session.commit();
                for (Counselor user : userList) {
                    logger.debug("-------------------------------------");
                    logger.debug(user.getTitle());
                    logger.debug("-------------------------------------");
                    System.out.println( user);

                }
            } catch (Exception e) {
                e.printStackTrace();
                session.rollback();
            }



            session.close();
            ServerStatus<Counselor> serverStatus = new ServerStatus();
            serverStatus.setStatus( "success");
            Result<Counselor> result = new Result<Counselor>();
            result.setCount(userList.size());
            result.setList(userList);
            serverStatus.setResult(result);

            return serverStatus;
        }

    }
}