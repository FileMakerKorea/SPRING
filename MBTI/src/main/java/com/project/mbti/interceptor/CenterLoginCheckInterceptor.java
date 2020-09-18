package com.project.mbti.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CenterLoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		//boolean isCenterLogin = session.getAttribute("isCenterLogin") == null ? false : (boolean) session.getAttribute("isCenterLogin");
		boolean isLogin = session.getAttribute("isLogin") == null ? false : (boolean) session.getAttribute("isLogin");
		
		//if(!isCenterLogin) {
		if(!isLogin) {				
			response.sendRedirect("/mbti/org/login");
			session.invalidate();
		}
		
		//return isCenterLogin;
		return isLogin;
	}
	
}
