package com.singlePoint.servlet;

import com.singlePoint.dao.UserDao;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截目的用户的登陆状态 未登录将返回到登陆页面，其它的通过
 */
public class LoginInterceptor implements HandlerInterceptor{

    /**
     * dispatcherServlet跳转到@Controller，然后HandlerInterceptor 拦截到url，如果url在@COntroller中不存在，直接进入不了页面
     * 登陆检查
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("拦截响应了------------");
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null) {
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    /**
     * 渲染视图之前 用来控制页面跳转
     * @param request
     * @param response
     * @param o
     * @param mv
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mv) throws Exception {

    }

    /**
     * 计算时间
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
