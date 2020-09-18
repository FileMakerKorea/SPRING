package com.project.mbti.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberLoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		boolean isMemberLogin = session.getAttribute("isMemberLogin") == null ? false : (boolean) session.getAttribute("isMemberLogin");
		
		if(!isMemberLogin) {
			response.sendRedirect("/mbti/normal/login");
		}
		
		return isMemberLogin;
	}
	
}
