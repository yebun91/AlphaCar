package com.hanul.alphacar;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import homeMypage.HomeMyPageServiceImpl;
import homeQna.QnaPage;
import homeQna.QnaServiceImpl;
import homeQna.QnaVO;
import member.WebMemberServiceImpl;
import member.WebMemberVO;

@Controller
public class HomeMyPageController {
	
	@Autowired private CommonService common;
	@Autowired private HomeMyPageServiceImpl homeService;
	@Autowired private WebMemberServiceImpl member;
	@Autowired private QnaServiceImpl service;
	@Autowired private QnaPage page;
	
	@RequestMapping("/mypage.mp")
	public String login(HttpSession session) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("customer_email", "e");
		map.put("customer_pw", "e");
		session.setAttribute("loginInfo", member.member_login(map));
		
		return "mypage/mypage";
	}
	//회원정보 수정 페이지로 이동
	@RequestMapping("/memberUpdate.mp")
	public String memberUpdate() {
		return "mypage/member_update";
	}
	//회원정보 수정 처리
	@RequestMapping("/memberSubmit.mp")
	public String memberUpdateWork(WebMemberVO vo, MultipartFile image_file, HttpSession session, String attach) {
		WebMemberVO member = (WebMemberVO) session.getAttribute("loginInfo");
		String uuid = session.getServletContext().getRealPath("resources")
				+ "/" + member.getCustomer_picture();
			
		//전송한 이미지 파일이 있다면
		if (! image_file.isEmpty()) {
			vo.setCustomer_picture(common.fileUpload("profiles", image_file, session));
			//기존에 가지고 있었던 파일 패스값이 있다면
			if ( member.getCustomer_picture() != null ) {
				File f = new File ( uuid );
				// 기존 첨부 파일 삭제
				if (f.exists()) f.delete();
			}
			
		}else {
			//전송한 이미지가 없을 경우 기존 주소 유지
			vo.setCustomer_picture(member.getCustomer_picture());
		}
		
		//화면에서 변경 입력한 정보를 db에 변경 저장한 후 상세화면으로 연결
		homeService.home_member_update(vo);	
		return "redirect:mypage.mp";

	}	

	//내 가게 정보
	@RequestMapping("/memberCompany.mp")
	public String memberCompany(HttpSession session, Model model) {
		WebMemberVO member = (WebMemberVO) session.getAttribute("loginInfo");
		model.addAttribute("company", homeService.company_list(member.getCustomer_email()));
		return "mypage/member_company";
	}
	
	//1:1 문의 내역
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
	
	//가게 삭제
	@RequestMapping("/memberCompanyDelete.mp")
	public String memberCompanyDelete(int store_number) {
		return "redirect:memberCompany.mp";
	}
	
	//가게 그래프 보러가기
	@RequestMapping("/memberCompanyGraph.mp")
	public String memberCompanyGraph(HttpSession session, Model model) {
		return "mypage/member_company_graph";
	}
	
	//가게 수정
	@RequestMapping("/memberCompanyUpdate.mp")
	public String memberCompanyUpdate(HttpSession session, Model model) {
		return "mypage/member_company_update";
	}
	
	//신규 가게등록 페이지 요청
	@RequestMapping("/memberCompanyInsert.mp")
	public String memberCompanyInsert(HttpSession session, Model model) {
		return "mypage/member_company_insert";
	}
	
	//회원 정보 검색
	@RequestMapping("/masterMemberList.mp")
	public String masterMemberList(HttpSession session, Model model) {
		return "mypage/master_member_list";
	}
	
	//1:1문의 처리
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
