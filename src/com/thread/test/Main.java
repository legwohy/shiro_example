package com.thread.test;

import com.thread.service.DateUtil;
import com.thread.service.MyThread;
import com.thread.service.SynDateUtil;

/**
 *
 */
public class Main {
    public static void main(String[] args){
        DateUtil dateUtil = new DateUtil();
        SynDateUtil synDateUtil =  new SynDateUtil();

        Thread t1 = new Thread(new MyThread("t01",dateUtil));
        Thread t2 = new Thread(new MyThread("t02",dateUtil));
        Thread t3 = new Thread(new MyThread("t03",dateUtil));
        Thread t4 = new Thread(new MyThread("t04",dateUtil));
        Thread t5 = new Thread(new MyThread("t05",dateUtil));
        Thread t6 = new Thread(new MyThread("t06",dateUtil));
        Thread t7 = new Thread(new MyThread("t07",dateUtil));
        Thread t8 = new Thread(new MyThread("t08",dateUtil));
        Thread t9 = new Thread(new MyThread("t09",dateUtil));
        Thread t10 = new Thread(new MyThread("t10",dateUtil));
        Thread t11 = new Thread(new MyThread("t11",dateUtil));
        Thread t12 = new Thread(new MyThread("t12",dateUtil));
        Thread t13 = new Thread(new MyThread("t13",dateUtil));
        Thread t14 = new Thread(new MyThread("t14",dateUtil));
        Thread t15 = new Thread(new MyThread("t15",dateUtil));


      /*  Thread t1 = new Thread(new MyThread("t1",synDateUtil));
        Thread t2 = new Thread(new MyThread("t2",synDateUtil));
        Thread t3 = new Thread(new MyThread("t3",synDateUtil));
        Thread t4 = new Thread(new MyThread("t4",synDateUtil));
        Thread t5 = new Thread(new MyThread("t5",synDateUtil));
        Thread t6 = new Thread(new MyThread("t6",synDateUtil));
        Thread t7 = new Thread(new MyThread("t7",synDateUtil));
        Thread t8 = new Thread(new MyThread("t8",synDateUtil));
        Thread t9 = new Thread(new MyThread("t9",synDateUtil));
        Thread t10 = new Thread(new MyThread("t10",synDateUtil));
        Thread t11 = new Thread(new MyThread("t11",synDateUtil));*/


        t1.start(); t2.start(); t3.start(); t4.start(); t5.start(); t6.start();
        t7.start(); t8.start(); t9.start(); t10.start(); t11.start();t12.start();
        t13.start();t14.start(); t15.start();
    }
}
