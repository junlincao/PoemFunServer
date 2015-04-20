package com.cjl.poemfun.service;

import com.cjl.poemfun.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserService
 *
 * @author CJL
 * @since 2015-04-20
 */
@Service("UserServices")
public class UserServices {
    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
}
