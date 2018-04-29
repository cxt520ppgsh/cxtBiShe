package com.example.ryzen1400.abd.model.bean;

import com.bumptech.glide.Glide;

import java.security.PublicKey;

public class PriceItem {
   public String name; //农业产品的名称
    private String date;//时间
    private  String grade;//农业产品的等级
    private String price;//农业产品的价格

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
