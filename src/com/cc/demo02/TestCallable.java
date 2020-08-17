package com.cc.demo02;

import com.cc.demo01.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 线程创建方式三：实现 callable 接口
 * Callable好处：
 *      可以有返回值
 *      可以抛出异常
 */
public class TestCallable implements Callable {

    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为："+name);

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://www.cc1021.com/Public/img/avatar.jpg","1.jpg");
        TestCallable t2 = new TestCallable("https://www.cc1021.com/Public/img/avatar.jpg","2.jpg");
        TestCallable t3 = new TestCallable("https://www.cc1021.com/Public/img/avatar.jpg","3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);

        //获取结果
        Boolean rs1 = result1.get();
        Boolean rs2 = result1.get();
        Boolean rs3 = result1.get();

        //关闭服务
        ser.shutdown();
    }
}

/**
 * 下载器
 */
class WebDownloader {

    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
