package com.example.ryzen1400.abd.model.bean;

public class MessageItem {
   public String title; //价格资讯的标题
    private String url;//价格资讯详情页面
    private  String img;//价格资讯封面

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }





}
