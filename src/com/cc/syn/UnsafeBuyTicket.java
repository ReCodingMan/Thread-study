package com.cc.syn;

/**
 * 线程不安全
 */
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "苦逼的我").start();
        new Thread(buyTicket, "牛逼的你们").start();
        new Thread(buyTicket, "可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable {

    //票
    private int ticketNum = 10;
    //外部停止方式
    boolean flag = true;

    @Override
    public void run() {
        //买票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNum <= 0) {
            return;
        }

        Thread.sleep(100);

        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNum--);
    }
}
