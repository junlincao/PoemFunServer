package com.cjl.poemfun.controller;

import com.cjl.poemfun.dao.UserDao;
import com.cjl.poemfun.domain.User;
import com.cjl.poemfun.service.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by cjl on 2015/4/19.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
    @Resource
    UserServices userServices;

    @RequestMapping("")
    public void test(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String name) {
        UserDao ud = userServices.getUserDao();
        User u = ud.queryUserByName(name);

        try {
            if (u == null) {
                writeStatusCode(response, -1, "failed");
                response.getWriter().write("user not found");
            } else {
                writeStatusCode(response, 0, "ok");
                response.getWriter().write(u.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
