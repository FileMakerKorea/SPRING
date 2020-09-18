package com.project.mbti.contoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.mbti.service.HospitalService;



@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	public void setCenterService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
	
	
	@RequestMapping(value= {"/hospitalList", "/list"})	
	public String hospitalList(Model model, 
			@RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
			@RequestParam(value="type", required=false,  defaultValue="null") String type,
			@RequestParam(value="keyword", required=false,defaultValue="null") String keyword) {		
	
		Map<String, Object> modelMap = 
				hospitalService.hospitalList(pageNum, type, keyword);
			
		model.addAllAttributes(modelMap);		

		return "hospitalList";
	}
	
	@RequestMapping("/allNameCode")
	@ResponseBody
	public List<Map<String, Object>> hospitalNameAll() {
		return hospitalService.getHospitalNameAll();
	}

}
