package com.cjl.poemfun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * Created by cjl on 2015/4/19.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @RequestMapping("")
    public void test(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String name) {
        try {
            writeStatusCode(response, 0, "ok");
            response.getWriter().write("hello " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
