package com.hanul.alphacar;



import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import homeNotice.HomeNoticePage;
import homeNotice.HomeNoticeServiceImpl;
import homeNotice.HomeNoticeVO;

@Controller
public class HomeNoticeController {
	
	@Autowired private HomeNoticeServiceImpl service;
//	@Autowired private CommonService common;
	@Autowired private HomeNoticePage page;
	
	@RequestMapping("/list.no")
	public String list(HttpSession session, Model model, 
			@RequestParam (defaultValue = "1") int curPage,
			String search, String keyword) {
		
		// 공지글 처리 중 임의로 로그인해 두기
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", "admin@naver.com");
		map.put("pw", "admin1234");
		//session.setAttribute("loginInfo", member.member_login(map));
				
		session.setAttribute("category", "no");
		List<HomeNoticeVO> list = service.notice_list();
		HomeNoticeVO homeNoticeVO = new HomeNoticeVO();
		for (int i = 0; i < list.size(); i++) {
			homeNoticeVO = list.get(i);
			Date time = list.get(i).getNotice_writedate();
			homeNoticeVO.setNotice_time(common.Time.txtDate(time));
			list.set(i, homeNoticeVO);
		}
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		model.addAttribute("notice_page", list);
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
