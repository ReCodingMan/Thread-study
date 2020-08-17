package com.cc.demo01;

/**
 * 创建线程方式一：继承Thread类，重写run()方法，调用start开启线程
 */
public class TestThread1 extends Thread {

    @Override
    public void run() {
        // run 方法线程体
        for (int i=0; i<20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {

        // 创建一个线程对象，调用start方法
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();

        // main线程，主线程
        for (int i=0; i<20; i++) {
            System.out.println("我在学习多线程---" + i);
        }
    }
}
