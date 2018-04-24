package com.singlePoint.servlet;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义会话管理 必须单例且线程安全
 */
public class MySessionContext {
    private static MySessionContext ctx = new MySessionContext();// 恶汉模式 属性就实例化，能够保证线程安全(共享一个实例)

    private Map<String,HttpSession> map;

    private MySessionContext(){
        map = new HashMap<>();
    }

    public static MySessionContext getInstance(){
        // 懒汉模式 需要才实例化
        /*if(ctx == null){
            ctx = new MySessionContext();
        }*/
        return ctx;
    }

    /** 添加会话*/
    public synchronized void addSession(HttpSession session){
        map.put(session.getId(),session);
    }

    /** 获取会话*/
    public synchronized HttpSession getSession(String sessionId){
        if(sessionId == null){return null;}
        return map.get(sessionId);
    }

    /** 删除会话*/
    public synchronized void removeSession(String sessionId){
       map.remove(sessionId);
    }


}
