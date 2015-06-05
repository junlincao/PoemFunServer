package com.cjl.poetryfan.dao;

import com.cjl.poetryfan.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 账户
 *
 * @author CJL
 * @since 2015-04-20
 */
@Repository("UserDao")
public class UserDao extends BaseJdbcDao {

    public User queryUserByName(String name) {
        String sql = "select name, password, image, status, create_date from user where name=?";

        List<User> users = getJdbcTemplate().query(sql, new String[]{name}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setName(resultSet.getString("name"));
                u.setPwd(resultSet.getString("password"));
                u.setUserImg(resultSet.getString("image"));
                u.setCreateDate(resultSet.getDate("create_date"));


                return u;
            }
        });

        return users.size() > 0 ? users.get(0) : null;
    }
}
