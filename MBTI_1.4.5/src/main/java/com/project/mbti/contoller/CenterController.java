package com.project.mbti.contoller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.mbti.service.CenterService;
import com.project.mbti.vo.Board;


//스프링 MVC의 컨트롤러임을 선언하고 있다.
@Controller
@RequestMapping("/center")
public class CenterController {

	@Autowired
	private CenterService centerService;
	
	public void setCenterService(CenterService centerService) {
		this.centerService = centerService;
	}
	
	
	@RequestMapping(value= {"/centerList", "/list"})
	
	public String boardList(Model model, 
			@RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
			@RequestParam(value="type", required=false,  defaultValue="null") String type,
			@RequestParam(value="keyword", required=false,defaultValue="null") String keyword) {		
	
		Map<String, Object> modelMap = 
				centerService.centerList(pageNum, type, keyword);
			
		model.addAllAttributes(modelMap);		

		return "centerList";
		
	}
	
	@RequestMapping(value= {"/centerListPopup"})
	
	public String boardListPopup(Model model, 
			@RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
			@RequestParam(value="type", required=false,  defaultValue="null") String type,
			@RequestParam(value="keyword", required=false,defaultValue="null") String keyword) {		
	
		Map<String, Object> modelMap = 
				centerService.centerList(pageNum, type, keyword);
			
		model.addAllAttributes(modelMap);		

		return "centerList";
		
	}
	
}
