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
	public String chatList(Model model, HttpSession session) {
		HashMap<String, String> chatInfo = new HashMap<String, String>();
		WebMemberVO vo = (WebMemberVO) session.getAttribute("loginInfo");
		chatInfo.put("id", vo.getCustomer_email());//userID  // revID
		chatInfo.put("name", vo.getCustomer_name());
		chatInfo.put("receiveId", "revID");
		model.addAttribute("loginInfo", chatInfo);
		
		return "chat/list";
	}
}
