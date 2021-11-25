package com.hanul.alphacar;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import member.WebMemberServiceImpl;
import member.WebMemberVO;

@Controller
public class HomeMemberController {
	
	@Autowired private WebMemberServiceImpl service;
	

	@RequestMapping ("/homeLogout")
	public String logout (HttpSession session) {

		session.removeAttribute("loginInfo");
		

		return "redirect:/";	
	}

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
