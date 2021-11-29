package com.hanul.alphacar;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import homeBestQna.BestQnaPage;
import homeQna.QnaPage;
import homeQna.QnaServiceImpl;
import homeQna.QnaVO;
import member.WebMemberVO;

@Controller
public class HomeMyPageController {
	@Autowired private QnaServiceImpl service;
	@Autowired private QnaPage page;
	
	@RequestMapping("/mypage.mp")
	public String login(HttpSession session, Model model) {
		return "mypage/mypage";
	}
	@RequestMapping("/memberUpdate.mp")
	public String memberUpdate(HttpSession session, Model model) {
		return "mypage/member_update";
	}
	
	@RequestMapping("/memberCompany.mp")
	public String memberCompany(HttpSession session, Model model) {
		return "mypage/member_company";
	}
	
	//공지사항 리스트로 가기
	@RequestMapping("/memberContact.mp")
	public String memberContact(HttpSession session, Model model, 
			@RequestParam (defaultValue = "1") int curPage,
			String search, String keyword, QnaVO vo) {
		
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		vo.setCustomer_email( ( (WebMemberVO) session.getAttribute("loginInfo")).getCustomer_email() );
		//DB에서 공지글 목록을 조회한 후 목록화면에 출력
		//model.addAttribute("page", service.member_qna_list(page, vo.getCustomer_email()));
		
		return "mypage/member_contact";
	}

	@RequestMapping("/memberCompanyGraph.mp")
	public String memberCompanyGraph(HttpSession session, Model model) {
		return "mypage/member_company_graph";
	}
	@RequestMapping("/memberCompanyUpdate.mp")
	public String memberCompanyUpdate(HttpSession session, Model model) {
		return "mypage/member_company_update";
	}
	
	//신규 가게등록 페이지 요청
	@RequestMapping("/memberCompanyInsert.mp")
	public String memberCompanyInsert(HttpSession session, Model model) {
		return "mypage/member_company_insert";
	}
	@RequestMapping("/masterMemberList.mp")
	public String masterMemberList(HttpSession session, Model model) {
		return "mypage/master_member_list";
	}
	@RequestMapping("/masterContact.mp")
	public String masterContact(HttpSession session, Model model, 
			@RequestParam (defaultValue = "1") int curPage,
			String search, String keyword) {
		
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		
		//DB에서 공지글 목록을 조회한 후 목록화면에 출력
		model.addAttribute("page", service.qna_list(page));
		return "mypage/master_contact";
	}
	
}
