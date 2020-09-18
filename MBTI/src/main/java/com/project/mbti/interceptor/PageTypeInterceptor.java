package com.project.mbti.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PageTypeInterceptor extends HandlerInterceptorAdapter {

	// 컨트롤러에서 처리 후 view로 보내기 전에 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String uri = request.getRequestURI();
		String pageType = "";
		if(uri.contains("normalMypage")) {
			pageType = "normalMypage";
		} else if (uri.contains("certificateAdd")) {
			pageType = "certificateAdd";
		} else if (uri.contains("memberUpdate")) {
			pageType = "memberUpdate";
		} 
		request.setAttribute("pageType", pageType);
	}

}
