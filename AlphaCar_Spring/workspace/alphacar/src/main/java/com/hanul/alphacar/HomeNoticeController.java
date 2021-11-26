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
import member.WebMemberServiceImpl;
import member.WebMemberVO;

@Controller
public class HomeNoticeController {
	
	@Autowired private HomeNoticeServiceImpl service;
	@Autowired private CommonService common;
	@Autowired private HomeNoticePage page;
	@Autowired private WebMemberServiceImpl member;
	
	//공지사항 리스트
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
	
	//공지사항 작성 화면으로
	@RequestMapping("/write.no")
	public String write(HttpSession session, Model model) {
		return "notice/write";
	}
	
	//공지사항 작성한 글 저장처리
	@RequestMapping("/insert.no")
	public String insert(HomeNoticeVO vo, HttpSession session, Model model) {
		
		// 로그인 된 사용자의 email을 저장함
		vo.setCustomer_email( ( (WebMemberVO) session.getAttribute("loginInfo")).getCustomer_email() );
		
		service.notice_insert(vo);
		return "redirect:list.no";
	}
	
	// 공지사항 상세화면 요청
	@RequestMapping("/detail.no")
	public String detail(int id, Model model) {
		/* 클릭시 조회수 증가 */
		service.notice_read(id);
		
		model.addAttribute("vo", service.notice_detail(id));
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("page", page);
		
		return "notice/detail";
	}
	
	//공지글 수정 화면으로
	@RequestMapping("/update.no")
	public String update(HttpSession session, Model model, int id) {
		model.addAttribute("vo", service.notice_detail(id));
		return "notice/update";
	}
	
	/// 공지글 수정 저장 처리 요청
	@RequestMapping ("/update_work.no")
	public String update_work(HomeNoticeVO vo, HttpSession session, String attach) {
		service.notice_update(vo);		
		return "redirect:detail.no?id=" + vo.getNotice_id();
	}

	//공지글 삭제처리
	@RequestMapping("/delete.no")
	public String delete(HttpSession session, Model model, int id) {
		service.notice_delete(id);
		return "redirect:list.no";
	}
}
