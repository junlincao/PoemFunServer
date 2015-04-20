package com.cjl.poemfun.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * com.cjl.poemfun.dao
 *
 * @author CJL
 * @since 2015-04-20
 */
public class BaseJdbcDao extends JdbcDaoSupport {

    @Resource(name = "dataSource")
    public void setSuperDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
