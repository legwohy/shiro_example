package com.singlePoint.listener;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义会话上下文 单例
 */
public class MySessionContext {
    private static MySessionContext ctx;

    private Map<String,HttpSession> map;

    private MySessionContext(){
        map = new HashMap<>();
    }

    public static MySessionContext getInstancce(){
        if(ctx == null){
            ctx = new MySessionContext();
        }
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
