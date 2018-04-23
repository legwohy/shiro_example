package com.thread.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class SynDateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Date synParse(String strDate){
        Date date = null;
        try {
            synchronized (sdf){
                date = sdf.parse(strDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String synFormat(Date date){
        synchronized (sdf){
            return sdf.format(date);
        }

    }

}
