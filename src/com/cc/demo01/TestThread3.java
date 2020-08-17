package com.cc.demo01;

/**
 * 创建线程方式2：实现 runnable 接口，重写run方法
 * 执行线程需要丢入 runnable 接口实现类，调用start方法
 */
public class TestThread3 implements Runnable {

    @Override
    public void run() {
        // run 方法线程体
        for (int i=0; i<20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {

        // 创建一个线程对象，调用start方法
        TestThread3 testThread3 = new TestThread3();
        new Thread(testThread3).start();

        // main线程，主线程
        for (int i=0; i<20; i++) {
            System.out.println("我在学习多线程---" + i);
        }
    }
}
