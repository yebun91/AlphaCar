package com.hanul.alphacar;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import member.WebMemberServiceImpl;
import member.WebMemberVO;

@Controller
public class HomeMemberController {
	
	@Autowired private WebMemberServiceImpl service;
	@Autowired private CommonService common;
	
	// 로그아웃 처리 요청
	@RequestMapping ("/homeLogout")
	public String logout (HttpSession session) {
		// 세션에 담긴 로그인 정보를 삭제한다.
		session.removeAttribute("loginInfo");
		
		// 로그아웃 시 루트(home.jsp)로 이동
		return "redirect:/";	
	}
	
	//로그인 처리 요청
	@ResponseBody
	@RequestMapping("/webLogin")
	public Boolean webLogin(HttpSession session, String customer_email, String customer_pw) {
		System.out.println(customer_email);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("customer_email", customer_email);
		map.put("customer_pw", customer_pw);
		WebMemberVO vo = service.member_login(map);
		session.setAttribute("loginInfo", vo);
		
		return vo == null ? false : true;
	}
	
	//로그인 화면 요청
	@RequestMapping("/homeLogin")
	public String login(HttpSession session, Model model) {
		
		session.setAttribute("category", "homeLogin");
		return "member/login";
	}
	
	
	//회원가입 화면 요청
	@RequestMapping("/homeJoin")
	public String join(HttpSession session, Model model) {
		session.setAttribute("category", "homeJoin");
		return "member/join";
	}
	
	//회원가입 요청
	@ResponseBody
	@RequestMapping(value = "/homeRegister", produces = "text/html; charset=utf-8")
	public String homeRegister(HttpSession session, WebMemberVO vo, HttpServletRequest req, String join_company,
			MultipartFile file) {
		StringBuffer msg = new StringBuffer("<script>");
		String admin = "";
		if (join_company.equals("M")) {
			admin = "M";
			vo.setAdmin(admin);
		} else if (join_company.equals("C")) {
			admin = "C";
			vo.setAdmin(admin);
		}
		
		if (!file.isEmpty()) {// 파일이 있는 경우
			// 파일 첨부 처리 부분
			//vo.setCustomer_picture(file.getOriginalFilename());
			vo.setCustomer_picture(common.fileUpload("join", file, session));
		}
		
		if (service.member_join(vo)) {
			msg.append("alert('회원가입을 축하드립니다.'); location='")
				.append(req.getContextPath()).append("'");
		//	msg.append("alert('회원가입을 축하드립니다.'); location='login' ")
		} else {
			msg.append("alert('회원가입 실패'); location='homeJoin' ");
		}
		msg.append("</script>");
		return msg.toString();
	}
}
