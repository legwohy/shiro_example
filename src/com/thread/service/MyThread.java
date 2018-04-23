package com.thread.service;


/**
 * 自定义线程
 */
public class MyThread implements Runnable {
    private String name;
    private DateUtil dateUtil;
    private SynDateUtil synDateUtil;
    public MyThread(String name,DateUtil dateUtil){
        this.name = name;
        this.dateUtil = dateUtil;
    }
    public MyThread(String name,SynDateUtil synDateUtil){
        this.name = name;
        this.synDateUtil = synDateUtil;
    }

    /**
     * 未上锁 日期解析出问题
     */
/*
    @Override
    public void run() {
        String strDate = "1997-07-01 22:59:59";
        System.out.println(name+","+dateUtil.parse(strDate));
    }*/

    /**
     * sdf置于内部 每一段代码均被线程抢驻
     */
    @Override
    public void run() {
        String strDate = "1997-07-01 22:59:59";
        System.out.println("run循环开始:"+name);
        for (int i = 0;i<5;i++){
            System.out.println("循环内1:"+name+"，编号:"+i);
            System.out.println(name+","+dateUtil.innerParse(strDate));
            System.out.println("循环内2:"+name+",编号:"+i);
        }

        System.out.println("run循环结束:"+name);

    }

    /**
     * 上锁
     */

    /*@Override
    public void run() {
        String strDate = "1997-07-01 22:59:59";
        System.out.println(name+","+synDateUtil.synParse(strDate));
    }*/
}
