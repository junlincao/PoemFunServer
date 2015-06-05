package com.cjl.poetryfan.dao;

import com.cjl.poetryfan.domain.DaySuggest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * com.cjl.poetryfan.dao
 *
 * @author CJL
 * @since 2015-06-05
 */
@Repository("DaySuggestDao")
public class DaySuggestDao extends BaseJdbcDao {


    public List<DaySuggest> getSuggestList(String endDay) {
        endDay = "2015-06-06";
        String sql = "select `poetry_id` pid, `suggest_date` sdate from day_suggest ";
        Object[] params = null;
        if (endDay != null) {
            sql += " where `suggest_date` < ?";
            params = new String[]{endDay};
        }
        sql += " order by suggest_date asc";

        List<DaySuggest> result = getJdbcTemplate().query(sql, params, new RowMapper<DaySuggest>() {
            @Override
            public DaySuggest mapRow(ResultSet resultSet, int i) throws SQLException {
                DaySuggest ds = new DaySuggest();
                ds.setPid(resultSet.getInt("pid"));
                ds.setDate(resultSet.getString("sdate"));
                return ds;
            }
        });
        return result;
    }
}
