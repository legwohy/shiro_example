package com.singlePoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by user on 2018/4/20.
 */
public class DbUtils {
    private String user = "cobra";
    private String password = "Z&Tc1234567890";
    private String url = "jdbc:mysql://192.168.6.163:3306/shiro?useUnicode=true&CharacterEncoding=UTF-8";
    private static DbUtils dbUtils;
    private DbUtils(){}

    public static DbUtils getInstance(){
        if(dbUtils == null){
            dbUtils = new DbUtils();
        }
        return dbUtils;
    }


    static {
        String driverName = "com.mysql.jdbc.Driver";
        try {Class.forName(driverName);} catch (Exception e) {e.printStackTrace();}
    }

    public  Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn){
        if(conn != null){
            try {conn.close();} catch (SQLException e) {e.printStackTrace();}
        }
    }

}
