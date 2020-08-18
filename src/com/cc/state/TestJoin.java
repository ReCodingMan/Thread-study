package com.cc.state;

/**
 * 测试插队join方法
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();


        for (int i = 0; i < 500; i++) {
            if (i==200) {
                thread.join();//插队
            }
            System.out.println("main" + i);
        }
    }
}
