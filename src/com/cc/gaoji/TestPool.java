package com.cc.gaoji;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class TestPool {
    public static void main(String[] args) {
        //创建服务，创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //关闭连接
        service.shutdown();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
