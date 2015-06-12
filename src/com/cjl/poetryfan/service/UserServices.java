package com.cjl.poetryfan.service;

import com.cjl.poetryfan.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserService
 *
 * @author CJL
 * @since 2015-04-20
 */
@Service("User")
public class UserServices {
    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
}
