package com.cjl.poetryfan.domain;

import com.google.gson.annotations.Expose;

/**
 * 制定日期推荐内容
 *
 * @author CJL
 * @since 2015-06-08
 */
public class DaySuggest {
    @Expose()
    String author;
    @Expose()
    String authorImg;
    @Expose()
    String birth;
    @Expose()
    String title;
    @Expose()
    String content;
    @Expose()
    String date;


    String updateDate;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
