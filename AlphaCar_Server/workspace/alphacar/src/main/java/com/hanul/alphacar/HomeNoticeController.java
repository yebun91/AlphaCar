package com.hanul.alphacar;

import java.util.HashMap;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.CommonService;
import homeNotice.HomeNoticePage;
import homeNotice.HomeNoticeServiceImpl;
import homeNotice.HomeNoticeVO;
import member.MemberServiceImpl;
import member.WebMemberServiceImpl;

@Controller
public class HomeNoticeController {
	
	@Autowired private HomeNoticeServiceImpl service;
	@Autowired private CommonService common;
	@Autowired private HomeNoticePage page;
	@Autowired private WebMemberServiceImpl member;
	

	@RequestMapping("/list.no")
	public String list(HttpSession session, Model model, 
			@RequestParam (defaultValue = "1") int curPage,
			String search, String keyword) {
		

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("customer_email", "admin@naver.com");
		map.put("customer_pw", "admin1234");
		session.setAttribute("loginInfo", member.member_login(map));
		session.setAttribute("category", "no");
		
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);

		
		model.addAttribute("page", service.notice_list(page));
		return "notice/list";
	}
	
	@RequestMapping("/write.no")
	public String write(HttpSession session, Model model) {
		return "notice/write";
	}
	
	@RequestMapping("/detail.no")
	public String detail(HttpSession session, Model model) {
		return "notice/detail";
	}
	
	@RequestMapping("/update.no")
	public String update(HttpSession session, Model model) {
		return "notice/update";
	}
	
	@RequestMapping("/delete.no")
	public String delete(HttpSession session, Model model) {
		return "redirect:list.no";
	}
}
