package com.cc.state;

/**
 * 观察测试线程的状态
 */
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("/////");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);//new

        //观察启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);//run

        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }
    }
}
