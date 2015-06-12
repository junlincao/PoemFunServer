package com.cjl.poetryfan.service;

import com.cjl.poetryfan.dao.DaySuggestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * com.cjl.poetryfan.service
 *
 * @author CJL
 * @since 2015-06-08
 */
@Service("poetry")
public class PoetryServices {
    @Resource
    DaySuggestDao daySuggestDao;

    public DaySuggestDao getDaySuggestDao() {
        return daySuggestDao;
    }
}
