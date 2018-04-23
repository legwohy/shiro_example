package com.singlePoint.listener;

import com.singlePoint.dao.UserDao;
import com.singlePoint.pojo.MemberSession;
import com.singlePoint.pojo.User;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 全局监听器 管理会话
 */
public class SessionListener implements HttpSessionListener{
    private UserDao userDao;
    private MySessionContext ctx = MySessionContext.getInstancce();
    /**
     * 创建会话时触发监听
     * request.getSession() 默认为true
     * true 当前没有会话则创建会话,否则加入会话。
     * false 表示当前没有会话则返回null
     * 只有 servlet 中 调用request.getSession()时创建会话
     * 默认的情况下，用户第一次访问jsp页面就会创建session 第一次容器初始化时会话已经创建
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("创建了会话===="+event.getSession().getId());
        ctx.addSession(event.getSession());// 用户访问时创建会话(登陆时必须获取会话)
    }

    /** 销毁会话(会话到期或者会话销毁时触发操作) */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("销毁了会话===="+event.getSession().getId());
        User user = (User)event.getSession().getAttribute("user");


        //获取用户的sessionId和用户在线状态
        MemberSession  ms = userDao.findMemberSessionByUserId(user.getId());

        //如果用户在线且sessionId和e.getSession().getId()相同说明下线，不是更替。
        //则修改用户的在线状态和session设置null。
        if(event.getSession().getId().equals(ms.getSessionId())) {
            userDao.update(user.getId(),null);
        }

        ctx.removeSession(event.getSession().getId());

    }
}
