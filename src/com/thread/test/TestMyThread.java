package com.thread.test;

import com.thread.service.DateUtil;
import com.thread.service.MyThreadLocal;
import com.thread.service.SynDateUtil;
import org.junit.Test;

import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 */
public class TestMyThread {
    private DateUtil dateUtil = new DateUtil();
    private SynDateUtil synDateUtil = new SynDateUtil();
    private MyThreadLocal myThreadLocal = new MyThreadLocal();

    @Test public void test1(){
        ExecutorService executorService = Executors.newCachedThreadPool();// 创建一个线程池
        Runnable runnable = null;
        for (int i = 0;i < 100;i++){
            runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+","+myThreadLocal.parse("2018-07-01 23:59:59"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            };

            executorService.execute(runnable);// 将线程添加到池

        }

    }
}
