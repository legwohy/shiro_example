package com.thread.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * threadLocal
 */
public class MyThreadLocal {
    // threadLocal 共享实例 并初始化参数 实现变量共享
    private static final ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){
        // 初始化参数
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    /**
     * 解析字符串日期
     * @param strDate
     * @return
     */
    public Date parse(String strDate) throws ParseException {
        return threadLocal.get().parse(strDate);// threadlocal解析字符串日期

    }


}
