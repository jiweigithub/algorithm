package com.hanshunping.designpattern.prototype.demo1;

import java.util.Date;

/**
 * 视频的类
 * 1.实现一个接口 Cloneable
 * 2.重写一个方法 clone()
 */
public class Video implements Cloneable {//无良UP主，克隆别人的视频!

    private String name;

    private Date createTime;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Video(){}

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
