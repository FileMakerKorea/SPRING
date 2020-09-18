package com.project.mbti.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// 기관과 관련된 페이지로 매핑되는 컨트롤러
@Controller
@RequestMapping("/org")
public class OrgController {
	
	// 테스트. main아래에서 center, hosp구분해 각각 redirect
	@RequestMapping("/centerMain")
	public String test1() {
		return "centerMain";
	}
	
	@RequestMapping("/hospMain")
	public String test2() {
		return "hospMain";
	}
	//
	
	// 기관 로그인 성공. 메인 페이지
	@RequestMapping("/main")
	public String orgMain() {
		return "orgMain";
	}
	
	// 기관 로그인 페이지 요청
	@RequestMapping("/login")
	public String login() {
		return "orgLogin";
	}
	
	// 기관 로그인 실행
	@RequestMapping("/loginProcess")
	public String loginProcess(
			String orgName,
			String orgCode) {
		
		// DAO를 통한 로그인 처리
		
		// 로그인 성공
		return "redirect:/org/main";
	}
}
