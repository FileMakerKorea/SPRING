package com.project.mbti.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/intro")
public class IntroController {
	
	// topNav에서 MBTI 소개 눌렀을 때 보여지는 화면
	@RequestMapping(path = "/introduction", method = RequestMethod.GET)
	public String intro() {
		return "introduction";
	}
	
}
