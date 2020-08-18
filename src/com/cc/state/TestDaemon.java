package com.cc.state;

/**
 * 测试守护线程
 * 上帝守护你
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);// 默认是false，正常的线程都是用户线程
        thread.start();

        new Thread(you).start();
    }
}

//上帝
class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}


//你
class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }

        System.out.println("========goodbye! world!=========");
    }
}
