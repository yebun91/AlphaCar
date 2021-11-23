package com.hanul.alphacar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeServiceController {
	@RequestMapping("/list.se")
	public String list(HttpSession session, Model model) {
		return "service/list";
	}
	
	@RequestMapping("/write.se")
	public String write(HttpSession session, Model model) {
		return "service/write";
	}
	
	@RequestMapping("/detail.se")
	public String detail(HttpSession session, Model model) {
		return "service/detail";
	}
	
	@RequestMapping("/update.se")
	public String update(HttpSession session, Model model) {
		return "service/update";
	}
	
	@RequestMapping("/delete.se")
	public String delete(HttpSession session, Model model) {
		return "redirect:list.se";
	}
	@RequestMapping("/customer_write.se")
	public String customer_write(HttpSession session, Model model) {
		return "service/customer_write";
	}
}
