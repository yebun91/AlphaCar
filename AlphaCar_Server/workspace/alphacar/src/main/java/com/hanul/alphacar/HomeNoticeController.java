package com.hanul.alphacar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeNoticeController {
	@RequestMapping("/list.no")
	public String list(HttpSession session, Model model) {
		return "notice/list";
	}
	
	@RequestMapping("/write.no")
	public String write(HttpSession session, Model model) {
		return "notice/write";
	}
	
	@RequestMapping("/detail.no")
	public String detail(HttpSession session, Model model) {
		return "notice/detail";
	}
	
	@RequestMapping("/update.no")
	public String update(HttpSession session, Model model) {
		return "notice/update";
	}
	
	@RequestMapping("/delete.no")
	public String delete(HttpSession session, Model model) {
		return "redirect:list.no";
	}
}
