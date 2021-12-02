package com.hanul.alphacar;

import java.io.File;
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
		session.removeAttribute("revid");
		// 로그아웃 시 루트(home.jsp)로 이동
		return "redirect:/";	
	}
	
	//로그인 처리 요청
	@ResponseBody
	@RequestMapping("/webLogin")
	public Boolean webLogin(HttpSession session, String customer_email, String customer_pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("customer_email", customer_email);
		map.put("customer_pw", customer_pw);
		WebMemberVO vo = service.member_login(map);
		session.setAttribute("loginInfo", vo);
		
		return vo == null ? false : true;
	}
	
	//로그인 화면 요청
	@RequestMapping("/homeLogin")
	public String login(HttpSession session) {
		
		session.setAttribute("category", "homeLogin");
		return "member/login";
	}
	
	
	//회원가입 화면 요청
	@RequestMapping("/homeJoin")
	public String join() {
		return "member/join";
	}
	
	//회원가입 요청
	@ResponseBody
	@RequestMapping(value = "/homeRegister", produces = "text/html; charset=utf-8")
	public String homeRegister(HttpSession session, WebMemberVO vo, HttpServletRequest req, String join_company,
			MultipartFile file) {
		StringBuffer msg = new StringBuffer("<script>");
		
		if (! file.isEmpty()) {
			vo.setCustomer_picture(common.fileUpload("profiles", file, session));
		}else {
			//전송한 이미지가 없을 경우 null을 입력
			vo.setCustomer_picture(null);
		}
		
		if (service.member_join(vo)) {
			msg.append("alert('회원가입을 축하드립니다.'); location='")
				.append(req.getContextPath()).append("'");
		} else {
			msg.append("alert('회원가입 실패'); location='homeJoin' ");
		}
		msg.append("</script>");
		return msg.toString();
	}
}
