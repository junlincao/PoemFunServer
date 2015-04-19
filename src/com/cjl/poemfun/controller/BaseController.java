package com.cjl.poemfun.controller;

import javax.servlet.http.HttpServletResponse;

/**
 * baseController, some common method
 *
 * Created by cjl on 2015/4/20.
 */
public class BaseController {

    protected HttpServletResponse writeStatusCode(HttpServletResponse response, int code, String desc) {
        response.addHeader("code", String.valueOf(code));
        response.addHeader("desc", desc);
        return response;
    }
}
