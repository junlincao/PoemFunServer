package com.cjl.poetryfan.dao;

import com.cjl.poetryfan.domain.DaySuggest;
import com.cjl.poetryfan.domain.DaySuggestList;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * com.cjl.poetryfan.dao
 *
 * @author CJL
 * @since 2015-06-05
 */
@Repository("DaySuggestDao")
public class DaySuggestDao extends BaseJdbcDao {

    /**查询内容sql**/
    private final String mContentSql = "SELECT a.name author, a.birth, a.image, p.title, p.content, d.suggest_date sd, d.update_date d1, p.update_date d2, a.update_date d3 FROM author a, day_suggest d, poetry p WHERE d.poetry_id = p.id AND p.author_id = a.id ";

    /**
     * 获取推荐日期列表
     *
     * @param endDay 非空则查询此日期之前的数据
     * @param count  查询条数
     * @return 列表内容
     */
    public List<DaySuggestList> getSuggestList(String endDay, int count) {
        String sql = "select `poetry_id` pid, `suggest_date` sdate from day_suggest ";
        List<Object> ps = new ArrayList<>(2);
        if (endDay != null) {
            sql += " where `suggest_date` < ?";
            ps.add(endDay);
        }
        sql += " order by suggest_date asc limit ? ";
        ps.add(count);

        List<DaySuggestList> result = getJdbcTemplate().query(sql, ps.toArray(), new RowMapper<DaySuggestList>() {
            @Override
            public DaySuggestList mapRow(ResultSet resultSet, int i) throws SQLException {
                DaySuggestList ds = new DaySuggestList();
                ds.setPid(resultSet.getInt("pid"));
                ds.setDate(resultSet.getString("sdate"));
                return ds;
            }
        });
        return result;
    }

    /**
     * 根据推荐日id查询当日推荐内容
     *
     * @param id 推荐日id
     * @return 内容
     */
    public DaySuggest getSuggestContentById(int id) {
        String sql = mContentSql + " AND d.id = ?";

        Object[] params = new Object[]{id};

        List<DaySuggest> result = getJdbcTemplate().query(sql, params, new ContentRowMapper());
        return result == null || result.size() == 0 ? null : result.get(0);
    }

    /**
     * 根据推荐日期查询当日推荐内容
     *
     * @param date 推荐日期
     * @return 内容
     */
    public DaySuggest getSuggestContentByDate(String date) {
        String sql = mContentSql + " AND d.suggest_date = ?";

        Object[] params = new Object[]{date};

        List<DaySuggest> result = getJdbcTemplate().query(sql, params, new ContentRowMapper());
        return result == null || result.size() == 0 ? null : result.get(0);
    }

    private class ContentRowMapper implements RowMapper<DaySuggest> {

        @Override
        public DaySuggest mapRow(ResultSet rs, int i) throws SQLException {
            DaySuggest ds = new DaySuggest();

            ds.setDate(rs.getString(rs.findColumn("sd")));
            ds.setAuthor(rs.getString(rs.findColumn("author")));
            ds.setBirth(rs.getString(rs.findColumn("birth")));
            ds.setAuthorImg(rs.getString(rs.findColumn("image")));
            ds.setContent(rs.getString(rs.findColumn("content")));
            ds.setTitle(rs.getString(rs.findColumn("title")));

            String updateDate = rs.getString(rs.findColumn("d1")) + rs.getString(rs.findColumn("d2")) + rs.getString(rs.findColumn("d3"));
            ds.setUpdateDate(String.valueOf(updateDate.hashCode()));

            return ds;
        }
    }
}
