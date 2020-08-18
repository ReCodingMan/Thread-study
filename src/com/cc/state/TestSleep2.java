package com.cc.state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep2 {

    public static void main(String[] args) throws InterruptedException {
        //打印当前系统时间
        Date date = new Date(System.currentTimeMillis());//获取系统当前时间
        while (true) {
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            date = new Date(System.currentTimeMillis());
        }
    }
}
