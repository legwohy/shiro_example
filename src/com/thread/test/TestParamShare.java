/*
package com.thread.test;

import com.ihome.pojo.ParamShare;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

*/
/**
 *
 *//*

public class TestParamShare {
    private static ParamShare paramShare = new ParamShare();
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = null;
        for (int i = 0;i<20;i++){
            runnable = new Runnable() {
                @Override
                public void run() {
                    // 不使用threadlocal 共享变量 结论 存取之不一致
                    //paramShare.set();
                    //paramShare.get();

                      // 使用threadlocal 共享变量 存取一致
                    //paramShare.setThread();
                    //paramShare.getThread();

                    // 使用synchronized 关键字同步
                    //paramShare.setSyn();
                    //paramShare.getSyn();


                    // 限购三次
                   for (int i = 0;i<3;i++){
                       int count1 = Integer.parseInt(String.valueOf(new Random().nextInt()).substring(1,2));
                       int count2 = Integer.parseInt(String.valueOf(new Random().nextInt()).substring(1,3));
                       paramShare.setTicket(count1);
                       paramShare.getTicket(count2);
                   }

                }
            };
            executorService.execute(runnable);
        }
    }
}
*/
