package com.cjl.poetryfan.controller;

import com.cjl.poetryfan.dao.DaySuggestDao;
import com.cjl.poetryfan.domain.DaySuggest;
import com.cjl.poetryfan.domain.DaySuggestList;
import com.cjl.poetryfan.service.PoetryServices;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * poetry service
 *
 * @author CJL
 * @since 2015-06-08
 */
@Controller()
@RequestMapping("/poetry")
public class SuggestController {

    private static Log log = LogFactory.getLog(SuggestController.class);

    @Resource
    PoetryServices mPoetryServices;

    @RequestMapping("/suggest/list") // "?count=10&date=2015-06-11"
    public void daySuggestList(HttpServletRequest req, HttpServletResponse rsp) throws IOException {
        String c = req.getParameter("count");
        int count = Strings.isNullOrEmpty(c) ? 10 : Integer.valueOf(c);

        DaySuggestDao dsDao = mPoetryServices.getDaySuggestDao();
        List<DaySuggestList> result = dsDao.getSuggestList(req.getParameter("date"), count);

        Gson gson = new Gson();
        rsp.getWriter().write(gson.toJson(result));
    }

    @RequestMapping("/suggest/id/{id:\\d+}")
    public void daySuggestContentById(HttpServletRequest req, HttpServletResponse rsp, @PathVariable int id) throws IOException {
        DaySuggestDao dsDao = mPoetryServices.getDaySuggestDao();
        DaySuggest ds = dsDao.getSuggestContentById(id);
        sendSuggestContentResult(req, rsp, ds);
    }

    @RequestMapping("/suggest/date/{date}")
    public void daySuggestContentByDate(HttpServletRequest req, HttpServletResponse rsp, @PathVariable String date) throws IOException {
        DaySuggestDao dsDao = mPoetryServices.getDaySuggestDao();
        DaySuggest ds = dsDao.getSuggestContentByDate(date);
        sendSuggestContentResult(req, rsp, ds);
    }

    private void sendSuggestContentResult(HttpServletRequest req, HttpServletResponse rsp, DaySuggest ds) throws IOException {
        if (ds.getUpdateDate().equals(req.getHeader("If-None-Match"))) {
            rsp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            return;
        }

        rsp.setCharacterEncoding("UTF-8");
        rsp.setContentType("application/json");
        rsp.setHeader("ETag", ds.getUpdateDate());
        rsp.getWriter().write(new Gson().toJson(ds));
    }
}
