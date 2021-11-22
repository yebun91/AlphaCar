package com.hanul.alphacar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeMemberController {
	@RequestMapping("/homeLogin")
	public String login(HttpSession session, Model model) {
		return "member/login";
	}
	
	@RequestMapping("/homeJoin")
	public String join(HttpSession session, Model model) {
		return "member/join";
	}
}
