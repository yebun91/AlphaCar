package com.hanul.alphacar;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.WebMemberVO;

@Controller
public class ChatController {
	
	@RequestMapping("/list.chat")
	public String chatList(Model model, HttpSession session, String revid) {
		WebMemberVO vo = (WebMemberVO) session.getAttribute("loginInfo");
		
//		 if(revid != null) { 
//			 session.setAttribute("revid", revid); 
//		 }else {
//			 session.setAttribute("revid", ""); 
//		 }
		 
	    if(revid != null) { 
		    session.setAttribute("revid", revid); 
	    }
		 
		if(!vo.getAdmin().equals("A")) {
			session.setAttribute("revid", "운영자입니다");
		}
		return "chat/list";
	}
	
	@RequestMapping("/chat/list/change")
	public void chatListChange(HttpSession session, String revid) {
		if(revid != null) {
			session.setAttribute("revid", revid);
		}
	}
	
}
