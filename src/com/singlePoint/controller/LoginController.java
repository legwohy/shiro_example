package com.singlePoint.controller;

import com.singlePoint.dao.UserDao;
import com.singlePoint.servlet.MySessionContext;
import com.singlePoint.pojo.MemberSession;
import com.singlePoint.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


/**
 *
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    private UserDao userDao = new UserDao();
    private MySessionContext ctx = MySessionContext.getInstance();

    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
       HttpSession session = request.getSession();
       System.out.println("post的sessionId="+session.getId());
        String userName = request.getParameter("username");
        User user = userDao.findUserByLoginName(userName);

        if(user != null ) {
            session.setAttribute("user",user);

            MemberSession ms = userDao.findMemberSessionByUserId(user.getId());

            // 销毁上一个会话
            if(null != ms && null != ms.getSessionId()) {
                if(ms.getStatus()==1){
                    System.out.println("post提交:ms="+ms.toString());
                    ctx.getSession(ms.getSessionId()).invalidate();

                    ms.setSessionId(session.getId());// 跟新sessionId
                    userDao.updateMemberSession(ms);
                }

            }else {
                userDao.createMemberSession(user.getId(),session.getId());// 写入 会话id
            }

            model.addAttribute("msg",user.getUserName()+",登陆成功");

            return "success";
        }else {
            model.addAttribute("msg", "用户名或密码不正确");
            return "login";
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpSession session) {
        System.out.println("get的sessionId==========="+session.getId());
        if(session.getAttribute("user") != null) {return "success";}

        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = ctx.getSession(request.getSession().getId());
        System.out.println("退出的sessionId==========="+session.getId());
        session.invalidate();// 若有cookie 需要清空cookie


        return "login";
    }
}
