package com.gupaoedu.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: qingshan
 */
@Data
public class Blog implements Serializable{
    Integer bid; // 文章ID
    String name; // 文章标题
    Integer authorId; // 文章作者ID
    private String mobileStr;
    private List<Integer> mobiles =new ArrayList<>();

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getMobileStr() {
        return mobileStr;
    }

    public void setMobileStr(String mobileStr) {
        this.mobileStr = mobileStr;
    }

    public List<Integer> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Integer> mobiles) {
        this.mobiles = mobiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blog)) return false;
        Blog blog = (Blog) o;
        return bid.equals(blog.bid) &&
                name.equals(blog.name) &&
                authorId.equals(blog.authorId) &&
                mobileStr.equals(blog.mobileStr) &&
                mobiles.equals(blog.mobiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bid, name, authorId, mobileStr, mobiles);
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                ", mobileStr='" + mobileStr + '\'' +
                ", mobiles=" + mobiles +
                '}';
    }
}
