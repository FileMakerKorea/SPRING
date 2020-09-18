package com.project.mbti.contoller;



import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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
import com.project.mbti.vo.Blood;
import com.project.mbti.vo.BloodDetail;
import com.project.mbti.vo.Member;


// 일반 회원과 관련된 페이지로 매핑되는 컨트롤러
@Controller
@RequestMapping("/normal")
public class NormalController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BloodService bloodService;
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private HospitalService hospitalService;
	
	// 일반 회원 로그인 요청
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "normalLogin";
	}
	
	// 일반 회원 로그인 처리
	@RequestMapping(path = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(
			String id,
			String pass,
			HttpSession session,
			PrintWriter out,
			HttpServletResponse response) {
		
		String path = null;
		int result = memberService.memberPassCheck(id, pass);
		response.setContentType("text/html; charset=utf8");
		if(result == -1) {
			out.print("<script>alert('존재하지 않는 아이디입니다.'); history.back();</script>");
			return path;
		} else if (result == 0) {
			out.print("<script>alert('비밀번호가 맞지 않습니다.'); history.back();</script>");
			return path;
		} else if (result == 1) {
			path = "redirect:/main";
			Member member = memberService.getMember(id);
			boolean isMemberLogin = true;

			session.setAttribute("member", member);
			session.setAttribute("isMemberLogin", isMemberLogin);			 
		}
		return path;
	}
	
	// 일반 회원 로그아웃 처리
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("member");
		session.removeAttribute("isMemberLogin");
		return "redirect:/main";
	}
	
	// 일반 회원 가입
	@RequestMapping(path = "/join", method = RequestMethod.GET)
	public String join(
			HttpSession session,
			HttpServletResponse response,
			PrintWriter out) {
		
		// 회원 가입 버튼 가리거나 다른 방법 생각 가능
		boolean isMemberLogin = session.getAttribute("isMemberLogin") != null ? (boolean) session.getAttribute("isMemberLogin") : false;
		if(isMemberLogin) {
			response.setContentType("text/html; charset=utf8");
			out.print("<script>alert('로그인한 상태에서 회원가입을 할 수 없습니다.'); location.href='/mbti/main'</script>");
			return null;
		}
		return "memberJoin";
	}
	
	// 회원 가입 - 아이디 중복 체크 창
	@RequestMapping(value = "/overlapIdCheck", method = RequestMethod.POST)
	@ResponseBody
	public int overlapIdCheck(String id) {

		int cnt = memberService.overlapIdCheck(id);
		return cnt;
	}
	
	// 일반 회원 가입 프로세스 후 리다이렉트
	@RequestMapping(path = "/joinProcess", method = RequestMethod.POST)
	public String joinProcess(
			String id,
			String pass,
			String name,
			String gender,
			String bType,
			String rhType,
			String birthday,
			String[] email,
			@RequestParam(required = false) String mobile,
			@RequestParam(required = false) String zipcode,
			@RequestParam(required = false) String address1,
			@RequestParam(required = false) String address2,
			@RequestParam(required = false, defaultValue = "0") int height,
			@RequestParam(required = false, defaultValue = "0") int weight,
			Model model) {
		
		Member member = new Member();
		
		String mGender = gender.equals("male") ? "남" : gender.equals("female") ? "여" : null;
		String mEmail = email[0]+"@"+email[1];
		Date mBirth = ProjectUtils.stringToSqlDate(birthday);
		String mAddr = zipcode.equals("") ? null : zipcode + "/"+ address1 + "/" + address2;
		String mCell = mobile.equals("") ? null : mobile;
		
		member.setmId(id);
		member.setmPassword(pass);
		member.setmName(name);
		member.setmGender(mGender);
		member.setmBType(bType);
		member.setmRhType(rhType);
		member.setmEmail(mEmail);
		member.setmAddr(mAddr);
		member.setmCell(mCell);
		member.setmBirth(mBirth);
		member.setmHeight(height);
		member.setmWeight(weight);
		
		memberService.addMember(member);
		member.setmRegDate(memberService.getMember(member.getmId()).getmRegDate());
		model.addAttribute("member", member);
		model.addAttribute("isMemberLogin", "true");
		
		return "redirect:/main";
	}
	
	// 신청현황클릭 - 헌혈증 정보 출력
	@RequestMapping(path = "/myStatus", method = RequestMethod.GET)
	public String myStatus(
			@RequestParam(required = false, defaultValue = "1") int page,
			HttpSession session,
			Model model) {
		
		Member member = (Member) session.getAttribute("member");
		Map<String, Object> modelMap = bloodService.getMembersBloodList(member.getmId(), page);
		
		@SuppressWarnings("unchecked") // object -> ArrayList형변환 시 경고문구 무시
		List<Object> bloodList = (ArrayList<Object>) modelMap.get("bloodList");
		List<BloodDetail> bloodDetailList = null;

		if(bloodList.size() != 0) {
			bloodDetailList = new ArrayList<BloodDetail>();
			for(Object blood : bloodList){
				BloodDetail bloodDetail = bloodService.getBloodDetail((Blood) blood);
				bloodDetailList.add(bloodDetail);

			}			
		}
		modelMap.remove("bloodList");
		modelMap.put("bloodDetailList", bloodDetailList);

		model.addAllAttributes(modelMap);
		
		return "myStatus";
	}
	
	// 일반 회원 마이페이지
	@RequestMapping(path = "/normalMypage", method = RequestMethod.GET)
	public String normalMypage(
			HttpSession session,
			Model model) {
		
		Member member = (Member) session.getAttribute("member");
		List<Blood> bloodList = bloodService.getMembersBloodList(member.getmId());
		
		// 헌혈증이 없는 회원은 기타 처리 없이 페이지로 리턴
		if(bloodList.size() == 0) {
			return "normalMypage.jsp&nav=views/memberNav";
		}

		Map<String, Object> modelMap = new HashMap<String, Object>();
		int totalCount = bloodList.size();		

		List<Map<String, Object>> centerList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> hospList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> bIndexList = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> cIdStatus = bloodService.getMembersBloodStatus(member.getmId(), "cId");
		List<Map<String, Object>> hIdStatus = bloodService.getMembersBloodStatus(member.getmId(), "hId");
		List<Map<String, Object>> bIndexStatus = bloodService.getMembersBloodStatus(member.getmId(), "bIndex");
		List<Map<String, Object>> bVolumeStatus = bloodService.getMembersBloodStatus(member.getmId(), "bVolume");

		for(int i = 0; i < cIdStatus.size(); i++) {
			Object cId = null;

			Map<String, Object> tmpMap;						
			if((cId = cIdStatus.get(i).get("cId")) == null) continue; // 센터가 null인 경우는 없긴 하다

			tmpMap = new HashMap<String, Object>();
			tmpMap.put("cName", centerService.getCenterName((String) cId));
			tmpMap.put("count", cIdStatus.get(i).get("count"));
			centerList.add(tmpMap);
		}
		
		for(int i = 0; i < hIdStatus.size(); i++) {		
			Object hId = null;

			Map<String, Object> tmpMap;
			if((hId = hIdStatus.get(i).get("hId")) == null) continue;

			tmpMap = new HashMap<String, Object>();
			tmpMap.put("hName", hospitalService.getHospitalName((String) hId));
			tmpMap.put("count", hIdStatus.get(i).get("count"));
			hospList.add(tmpMap);
		}
		for(int i = 0; i < bIndexStatus.size(); i++) {
			
			Object bIndex = null;

			Map<String, Object> tmpMap;
			if((bIndex = bIndexStatus.get(i).get("bIndex")) == null) continue;

			tmpMap = new HashMap<String, Object>();
			tmpMap.put("bIndex", bIndex);
			tmpMap.put("count", bIndexStatus.get(i).get("count"));
			bIndexList.add(tmpMap);
		}
		modelMap.put("totalCount", totalCount);
		modelMap.put("volumeSum", bVolumeStatus.get(0).get("sum"));
		modelMap.put("centerList", centerList);
		modelMap.put("hospList", hospList);
		modelMap.put("bIndexList", bIndexList);
		
		model.addAllAttributes(modelMap);
		
		return "normalMypage.jsp&nav=views/memberNav";
	}
		
	
	// 헌혈증 정보 입력 페이지
	@RequestMapping(path = "/certificateAdd", method = RequestMethod.GET)
	public String certificateAdd() {
		return "certificateAdd.jsp&nav=views/memberNav";
	}
	
	// 헌혈증 정보 입력 처리
	@RequestMapping(path = "/certificateProcess", method = RequestMethod.POST)
	public String certificateProcess(
			Blood blood,
			String mId,
			String bId,
			String strbDate,
			String cName,
			String bIndex,
			String cId,
			String rhType,
			String bType,
			int bVolume) {
		
		Date bDate = ProjectUtils.stringToSqlDate(strbDate);
		String bUsed = "N";
		
		blood.setbDate(bDate);
		blood.setbUsed(bUsed);
		
		bloodService.addBlood(blood);

		return "redirect:/normal/normalMypage";
	}
	
	// 헌혈증 상세 정보 페이지
	@RequestMapping(path = "certificateDetail")
	public String certificateDetail() {
		return "certificateDetail.jsp&nav=views/memberNav";
	}
	
	// 회원 정보 수정 페이지
	@RequestMapping(path = "/memberUpdate", method = RequestMethod.GET)
	public String memberUpdate(
			HttpSession session,
			Model model) {
		Member member = (Member) session.getAttribute("member");
		String mAddr = member.getmAddr();
		String zipcode = null;
		String address1 = null;
		String address2 = null;
		
		if(mAddr != null) {
			zipcode = mAddr.split("/")[0];
			address1 = mAddr.split("/")[1];
			address2 = mAddr.split("/")[2];			
		}
		
		model.addAttribute("zipcode", zipcode);
		model.addAttribute("address1", address1);
		model.addAttribute("address2", address2);
		
		
		return "memberUpdate.jsp&nav=views/memberNav";
	}
	
	// 회원 정보 수정 처리
	@RequestMapping(path = "/memberUpdateProcess", method = RequestMethod.POST)
	public String memberUpdaterProcess(
			String id,
			@RequestParam(required = false) String pass,
			String[] email,
			@RequestParam(required = false) String mobile,
			@RequestParam(required = false) String zipcode,
			@RequestParam(required = false) String address1,
			@RequestParam(required = false) String address2,
			@RequestParam(required = false, defaultValue = "0") int height,
			@RequestParam(required = false, defaultValue = "0") int weight,
			HttpSession session) {
		
		/* - 가입시엔 생일을 받음, db에 저장되는 건 나이
		 * 나이를 계산해서 입력하면 문제는 없지만 정보 수정 시 생일을 알 지 못함
		 * db를 수정하거나 폼을 수정
		 */
		String mEmail = email[0]+"@"+email[1];
		String mAddr = zipcode.equals("") ? "" : zipcode + "/"+ address1 + "/" + address2;
		
		Member member = memberService.getMember(id);
		if(!pass.equals("")) member.setmPassword(pass);
		member.setmEmail(mEmail);
		member.setmCell(mobile);
		member.setmAddr(mAddr);
		member.setmHeight(height);
		member.setmWeight(weight);
		
		memberService.updateMember(member);
		session.setAttribute("member", memberService.getMember(id));
		
		return "redirect:/normal/normalMypage";
	}
	
	// 회원 탈퇴 페이지
	@RequestMapping(path = "/memberDelete", method = RequestMethod.GET)
	public String memberDelete() {
		return "memberDelete.jsp&nav=views/memberNav";
	}
	
	// 회원 탈퇴 처리
	@RequestMapping(path = "/memberDeleteProcess", method = RequestMethod.POST)
	public String memberDeleteProcess(
			String pass,
			HttpSession session,
			PrintWriter out,
			HttpServletResponse response) {
		Member member = (Member) session.getAttribute("member");
		int memberPassCheck = memberService.memberPassCheck(member.getmId(), pass);
		
		response.setContentType("text/html; charset=utf8");
		if(memberPassCheck == 1) {
			session.removeAttribute("member");
			session.removeAttribute("isLogin");
			/*
			 * 1. db에서 멤버 삭제하거나
			 * 2. notes에 탈퇴 상태를 적어놓음 -> 로그인 처리 시 탈퇴 상태면 존재하지 않는 아이디. 가입 시 중복검사에서 걸러야 함
			 * 3. notes에 탈퇴 날짜 저장 후 일정 기간 이후 데이터 삭제
			 * 4. 등등
			 */
			
			/*
			 * memberService.deleteMember(member); session.invalidate();
			 */
			out.print("<script>alert('정상적으로 탈퇴되었습니다. 이용해주셔서 감사합니다.'); location.href='/mbti/main';</script>");
		} else if(memberPassCheck == 0) {
			out.print("<script>alert('비밀번호가 맞지 않습니다.'); location.href='/mbti/normal/memberDelete';</script>");
		}
		return null;
	}
	
}
