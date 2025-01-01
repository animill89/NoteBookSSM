package edu.cqie.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Boolean ret = HandlerInterceptor.super.preHandle(request, response, handler);
        HttpSession session = request.getSession();
        String username = (String) session.getServletContext().getAttribute("username");
        System.out.print("session:" + username);
        if (session.getAttribute("username") == null) {
            response.sendRedirect("/login");
            return false;
        }
        System.out.print(ret);
        return true;
    }
}
