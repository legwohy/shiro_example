package com.thread.test;

import com.thread.service.Source;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by user on 2018/4/2.
 */
public class TestSource {
    public static void main(String[] args){
        Source source = new Source(100);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = null;
        // 开启10个线程
        for (int i = 0;i<10;i++){
            runnable = new Runnable() {
                @Override
                public void run() {
                    //==============syn 同步==============

                    // 生成2次
                    /*for (int i = 0;i <2 ;i++){
                        source.produceBySyn(Integer.parseInt(String.valueOf(new Random().nextInt()).substring(3,5)));
                    }
                    // 消费5次
                    for (int i = 0;i <5 ;i++){
                        source.consumeBySyn(Integer.parseInt(String.valueOf(new Random().nextInt()).substring(2,3)));
                    }*/

                    // threadLocal 共享
                    // 生成2次
                    for (int i = 0;i <2 ;i++){
                        source.produceByThreadLocal(Integer.parseInt(String.valueOf(new Random().nextInt()).substring(3,5)));
                    }
                    // 消费5次
                    for (int i = 0;i <5 ;i++){
                        source.consumeByThreadLocal(Integer.parseInt(String.valueOf(new Random().nextInt()).substring(2,3)));
                    }
                }
            };

            executorService.execute(runnable);
        }

    }
}
