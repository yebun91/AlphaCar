package com.hanul.alphacar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeMyPageController {
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
	@RequestMapping("/memberContact.mp")
	public String memberContact(HttpSession session, Model model) {
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
	@RequestMapping("/masterMemberList.mp")
	public String masterMemberList(HttpSession session, Model model) {
		return "mypage/master_member_list";
	}
	@RequestMapping("/masterContact.mp")
	public String masterContact(HttpSession session, Model model) {
		return "mypage/master_contact";
	}
	
}
