package com.laotan.easyreader.bean;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Book implements Comparable { // 定义名为Book的类，默认继承自Object类
    public int id;// 编号  
    public String name;// 名称  
    public double price; // 价格  
    private String author;// 作者  
    public GregorianCalendar calendar;// 出版日期

    public Book() {
        this(0, "X", 0.0, new GregorianCalendar(), "");
    }

    public Book(int id, String name, double price, GregorianCalendar calender,
                String author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.calendar = calender;
        this.author = author;
    }

    // 重写继承自父类Object的方法，满足Book类信息描述的要求  
    public String toString() {
        String showStr = id + "\t" + name; // 定义显示类信息的字符串  
        DecimalFormat formatPrice = new DecimalFormat("0.00");// 格式化价格到小数点后两位
        showStr += "\t" + formatPrice.format(price);// 格式化价格  
        showStr += "\t" + author;
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy年MM月dd日");
        showStr += "\t" + formatDate.format(calendar.getTime()); // 格式化时间  
        return showStr; // 返回类信息字符串  
    }

    public int compareTo(Object obj) {// Comparable接口中的方法  
        Book b = (Book) obj;
        return this.id - b.id; // 按书的id比较大小，用于默认排序
    }
}