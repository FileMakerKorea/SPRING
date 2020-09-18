package com.project.mbti.contoller;



import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.mbti.service.BloodService;
import com.project.mbti.service.MemberService;
import com.project.mbti.util.ProjectUtils;
import com.project.mbti.vo.Blood;
import com.project.mbti.vo.Member;


// 일반 회원과 관련된 페이지로 매핑되는 컨트롤러
@Controller
@RequestMapping("/normal")
@SessionAttributes({"member", "m"})
public class NormalController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BloodService bloodService;
	
	// 일반 회원 로그인 요청
	@RequestMapping("/login")
	public String login() {
		return "normalLogin";
	}
	
	// 일반 회원 가입
	@RequestMapping("/join")
	public String join() {
		return "memberJoin";
	}
	
	// 일반 회원 가입 프로세스 후 리다이렉트
	@RequestMapping("/joinProcess")
	public String joinProcess(
			@RequestParam(name = "id") String mId,
			@RequestParam(name = "pass") String mPassword,
			@RequestParam(name = "name") String mName,
			@RequestParam(name = "gender") String mGender,
			@RequestParam(name = "bType") String mBType,
			@RequestParam(name = "rhType") String mRhType,
			@RequestParam(name = "birthday") String birthday,
			@RequestParam(name = "email") String[] email,
			@RequestParam(name = "mobile", required = false) String mCell,
			@RequestParam(required = false) String zipcode,
			@RequestParam(required = false) String address1,
			@RequestParam(required = false) String address2,
			@RequestParam(name = "height", required = false, defaultValue = "0") int mHeight,
			@RequestParam(name = "weight", required = false, defaultValue = "0") int mWeight,
			Model model) {
		
		Member member = new Member();
		
		String mEmail = email[0]+"@"+email[1];
		int mAge = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(birthday.substring(0, 4));
		String mAddr = zipcode.equals("") ? "" : "(" + zipcode + ") "+ address1 + " / " + address2;
		
		member.setmId(mId);
		member.setmPassword(mPassword);
		member.setmName(mName);
		member.setmGender(mGender);
		member.setmBType(mBType);
		member.setmRhType(mRhType);
		member.setmEmail(mEmail);
		member.setmAddr(mAddr);
		member.setmCell(mCell);
		member.setmAge(mAge);
		member.setmHeight(mHeight);
		member.setmWeight(mWeight);
		
		/*
		member 객체를 session attribute로 설정
		memberService.addMember(member);
		member.setmRegDate(memberService.getMember(member.getmId()).getmRegDate());
		model.addAttribute("member", member);
		*/
		
		/*
		혹은 member id만 session attribute로 설정		
		 */
		return "redirect:/main";
	
	}
	
	// 일반 회원 마이페이지
	@RequestMapping("/normalMypage")
	public String normalMypage() {
		return "normalMypage.jsp&nav=views/memberNav";
	}
	
	// 헌혈증 정보 입력 페이지
	@RequestMapping("/certificateAdd")
	public String certificateAdd() {
		return "certificateAdd.jsp&nav=views/memberNav";
	}
	
	// 헌혈증 정보 입력 처리
	@RequestMapping("/certificateProcess")
	public String certificateProcess(Blood blood, @RequestParam("strbDate") String strbDate) {
		
		// com.project.mbti.util
		Date bDate = ProjectUtils.stringToSqlDate(strbDate);
		blood.setbDate(bDate);
		bloodService.addBlood(blood);

		return "redirect:/normal/normalMypage";
	}
	
}
