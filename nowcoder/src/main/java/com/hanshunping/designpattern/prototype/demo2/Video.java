package com.hanshunping.designpattern.prototype.demo2;

import java.util.Date;

public class Video implements Cloneable {//无良UP主，克隆别人的视频!

    private String name;

    private Date createTime;

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Object clone = super.clone();

        Video video = (Video) clone;
        //将这个对象的属性也进行克隆
        video.createTime = (Date) this.createTime.clone();

        return clone;
    }

    public Video() {
    }

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
