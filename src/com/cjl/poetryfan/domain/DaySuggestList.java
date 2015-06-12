package com.cjl.poetryfan.domain;

/**
 * 每日推荐列表
 *
 * @author CJL
 * @since 2015-06-05
 */
public class DaySuggestList {
    private int pid;
    private String date;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DaySuggestList{" +
                "pid=" + pid +
                ", date='" + date + '\'' +
                '}';
    }
}
