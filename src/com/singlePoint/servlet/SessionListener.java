package com.singlePoint.servlet;

import com.singlePoint.dao.UserDao;
import com.singlePoint.pojo.MemberSession;
import com.singlePoint.pojo.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 全局监听器 管理会话
 */
public class SessionListener implements HttpSessionListener{
    private UserDao userDao;
    private MySessionContext ctx = MySessionContext.getInstance();
    /**
     * 创建会话时触发监听
     * request.getSession() 默认为true
     * true 当前没有会话则创建会话,否则加入会话。
     * false 表示当前没有会话则返回null
     * 只有 servlet 中 调用request.getSession()时创建会话
     * 默认的情况下，用户第一次访问jsp页面就会创建session 第一次容器初始化时会话已经创建（也就是说不能从此会话中取值）
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("创建了会话===="+event.getSession().getId());
        ctx.addSession(event.getSession());// 用户访问时创建会话(登陆时必须获取会话)

    }

    /**
     * 销毁会话(会话到期或者会话销毁时触发操作)
     * 销毁会话 会话管理提出会话，用户状态改为下线
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("监听到会话销毁===="+event.getSession().getId());
        User user = (User)event.getSession().getAttribute("user");
        System.out.println("销毁的会话能够取值吗?"+user.toString());
        userDao = new UserDao();
        MemberSession ms = userDao.findMemberSessionByUserId(user.getId());
        ms.setStatus(2);
        System.out.println("销毁会话的参数:"+ms.toString());

        userDao.updateMemberSession(ms);// 跟新状态
        ctx.removeSession(event.getSession().getId());// 剔除会话

    }
}
