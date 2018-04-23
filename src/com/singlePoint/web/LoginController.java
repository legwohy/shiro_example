package com.singlePoint.web;

import com.singlePoint.dao.UserDao;
import com.singlePoint.listener.MySessionContext;
import com.singlePoint.pojo.MemberSession;
import com.singlePoint.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


/**
 *
 */
@Controller
public class LoginController {
    private UserDao userDao = new UserDao();
    private MySessionContext ctx = MySessionContext.getInstancce();

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        System.out.println("post 提交登陆响应");
       HttpSession session = request.getSession();
        String userName = request.getParameter("username");
        User user = userDao.findUserByLoginName(userName);
        //密码和id匹配
        if(user != null ) {
            session.setAttribute("user",user);
            MemberSession ms = userDao.findMemberSessionByUserId(user.getId());

            userDao.createMemberSession(user.getId(),session.getId());// 添加会话

            // 销毁上一个会话
            if(ms.getSessionId() != null) {
                HttpSession oldSession = ctx.getSession(ms.getSessionId());
                if(oldSession != null)
                    oldSession.invalidate();
            }
            model.addAttribute("msg",user.getUserName()+",登陆成功");

            return "success";
        }else {
            model.addAttribute("msg", "用户名或密码不正确");
            return "login";
        }
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(HttpSession session) {
        System.out.println("get 提交登陆响应");
        if(session.getAttribute("user") != null) {return "success";}
        return "login";
    }
}
