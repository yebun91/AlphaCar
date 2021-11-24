package com.hanul.alphacar;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import member.MemberServiceImpl;
import member.MemberVO;
import member.WebMemberVO;

@Controller
public class HomeMemberController {
	
	@Autowired private MemberServiceImpl service;
	
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
	
	@RequestMapping("/homeJoin")
	public String join(HttpSession session, Model model) {
		return "member/join";
	}
}
