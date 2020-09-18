package com.project.mbti.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HospitalLoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		//boolean isHospitalLogin = session.getAttribute("isHospitalLogin") == null ? false : (boolean) session.getAttribute("isHospitalLogin");
		boolean isLogin = session.getAttribute("isLogin") == null ? false : (boolean) session.getAttribute("isLogin");
		
		//if(!isHospitalLogin) {
		if(!isLogin) {
			response.sendRedirect("/mbti/org/login");
			session.invalidate();
		}
		
		//return isHospitalLogin;
		return isLogin;
	}
	
}
