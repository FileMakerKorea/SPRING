package com.project.mbti.contoller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.mbti.service.BloodService;
import com.project.mbti.service.CenterService;
import com.project.mbti.service.HospitalService;
import com.project.mbti.util.ProjectUtils;


//스프링 MVC의 컨트롤러임을 선언하고 있다.
@Controller
@RequestMapping("/center")
public class CenterController {

	@Autowired
	private CenterService centerService;
	
	@Autowired
	private HospitalService hospitalService;
	
	@Autowired
	private BloodService bloodService;
	
	public void setCenterService(CenterService centerService) {
		this.centerService = centerService;
	}
	
	
	@RequestMapping(value = { "/centerList", "/list", "/centerList2" })

	public String centerList(Model model,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "null") String type,
			@RequestParam(value = "keyword", required = false, defaultValue = "null") String keyword) {

		String result = "centerList";
		
		Map<String, Object> modelMap = centerService.centerList(pageNum, type, keyword);

		UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
		String requestedValue = builder.buildAndExpand().getPath();
		model.addAllAttributes(modelMap);
		System.out.println(requestedValue);
		if (requestedValue.equals("/mbti/center/centerList2"))
			result = "forward:/WEB-INF/views/centerList2.jsp";

		return result;
	}
	
	// 센터의 사용 안 한 헌혈증
	@RequestMapping("/unUsedBloodId")
	@ResponseBody
	public List<String> unUsedBloodId(String cId) {
		return bloodService.getCentersUnUsedBloodId(cId);
	}
	
	// 센터에서 병원으로 헌혈증 넘기는 절차
	@RequestMapping("/deliverToHosp")
	public String deliverToHosp(
			@RequestParam("centerId") String cId,
			@RequestParam("cDeliveryHosp") String hId,
			@RequestParam("cDeliveryDate") String strDate,
			@RequestParam("cDeliveryBlood") String[] bId,
			Model model) {
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		String hName = hospitalService.getHospitalName(hId);
		Date deliverDate = ProjectUtils.stringToSqlDate(strDate);
		for(String id : bId) {
			bloodService.deliverToHosp(id, hId, deliverDate);
		}
		
		
		responseMap.put("hName", hName);
		responseMap.put("deliverCount", bId.length);
		responseMap.put("deliverDate", deliverDate);
		
		model.addAllAttributes(responseMap);
		
		return "redirect:/org/centerMain";
	}
	
}
