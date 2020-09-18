package com.project.mbti.contoller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.mbti.service.BloodService;
import com.project.mbti.service.CenterService;
import com.project.mbti.service.HospitalService;
import com.project.mbti.service.MemberService;
import com.project.mbti.util.ProjectUtils;
import com.project.mbti.vo.Center;
import com.project.mbti.vo.Hospital;
import com.project.mbti.vo.Member;


// 기관과 관련된 페이지로 매핑되는 컨트롤러
@Controller
@RequestMapping("/org")
public class OrgController {
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private HospitalService hospitalService;
	
	@Autowired
	private BloodService bloodService;
	
	@Autowired
	private MemberService memberService;
	
	// 기관 로그인 페이지 요청
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "orgLogin";
	}
	
	// 센터 메인 페이지
	@RequestMapping(path = "/centerMain", method = RequestMethod.GET)
	public String centerMain(
			HttpSession session,
			Model model) {
		
		Center center = (Center) session.getAttribute("center");
		List<Map<String, Object>> countByHosp = bloodService.getCentersBloodCountByHosp(center.getcId());
		model.addAttribute("countByHosp", countByHosp);
		
		return "centerMain";
	}
	
	@RequestMapping(path = "/bloodDetailByHosp")
	@ResponseBody
	public Map<String, Object> bloodDetailByHosp(
			String cId,
			String hId,
			HttpSession session) {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		Center center = (Center) session.getAttribute("center");
		List<Map<String, Object>> list = bloodService.getCentersBloodByHosp(center.getcId(), hId);
		for(Map<String, Object> map : list) {
			Member member = memberService.getMember((String) map.get("mId"));
			map.put("mName", member.getmName());
			map.put("mAge", ProjectUtils.getAgeFromDate(member.getmBirth()));
			map.put("mGender", member.getmGender());
		}

		responseMap.put("hName", hospitalService.getHospitalName(hId));
		responseMap.put("list", list);
		return responseMap;
	}
	
	// 병원 메인 페이지
	@RequestMapping("/hospMain")
	public String hospMain(
			Model model,
			HttpSession session,
			@RequestParam(required = false, defaultValue = "1") int pageNum) {
		
		String userID = (String) session.getAttribute("userID");

		Map<String, Object> modelMap = bloodService.hospitalCount(userID, pageNum);

		model.addAllAttributes(modelMap);

		return "hospMain";
	}
	
	// 기관 로그인 실행
	@RequestMapping(path = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(
			String orgName,
			String orgCode,
			HttpSession session,
			PrintWriter out,
			HttpServletResponse response) {
		
		/* 김건우
		String path = null;
		int result = centerService.centerCodeCheck(orgName, orgCode);
		int result1 = hospitalService.hospitalCodeCheck(orgName, orgCode);
		response.setContentType("text/html; charset=utf8");
		
		if(result == -1) {
			out.print("<script>alert('존재하지 않는 기관명입니다.'); history.back();</script>");
			return path;
		} else if (result == 0) {
			out.print("<script>alert('기관코드가 맞지 않습니다.'); history.back();</script>");
			return path;
		} else if (result == 1) {
			path = "redirect:/org/centerMain";
			Center center = centerService.getCenter(orgCode);
			boolean isCenterLogin = true;
			
			session.setAttribute("center", center);
			session.setAttribute("isCenterLogin", isCenterLogin);
			
			return path;
		}
		
		if(result1 == -1) {
			out.print("<script>alert('존재하지 않는 기관명입니다.'); history.back();</script>"); 
			return path;
		} else if (result1 == 0) {
			out.print("<script>alert('기관코드가 맞지 않습니다.'); history.back();</script>"); 
			return path;
		} else if (result1 == 1) { 
			path = "redirect:/org/hospMain"; 
			Hospital hospital = hospitalService.getHospital(orgCode);
			boolean isHospitalLogin = true;
		  
			session.setAttribute("hospital", hospital);
			session.setAttribute("isHospitalLogin", isHospitalLogin);
		 
		}		  
		return path;
		*/
		
		// 박태원
		String path = null;
		boolean isLogin = false;
		response.setContentType("text/html; charset=utf8");
		String msg = "<script>alert('기관코드가 맞지 않습니다.'); history.back();</script>";
		String msgBlank = "<script>alert('기관코드  또는 기관명이 비어 있습니다.'); history.back();</script>";

		int result = 0;

		if (orgCode.length() == 0 || orgName.length() == 0) {
			out.print(msgBlank);
		}

		else {

			String codeCheck = orgCode.substring(0, 2);
			String prefix = "KH";

			if (codeCheck.equals(prefix)) {

				result = hospitalService.hospitalCodeCheck(orgCode);
				path = "redirect:/org/hospMain";

			} else {
				result = centerService.centerCodeCheck(orgCode);
				path = "redirect:/org/centerMain";
				
				// session에 center 추가
				Center center = centerService.getCenter(orgCode);				
				session.setAttribute("center", center);
				//
			}
			response.setContentType("text/html; charset=utf8");

			if (result == 0) {
				out.print(msg);
				return null;
			} else {
				isLogin = true;
				session.setAttribute("userID", orgCode);
				session.setAttribute("isLoginName", orgName);
				session.setAttribute("isLogin", isLogin);

			}
		}
		return path;
		//
	}
}















