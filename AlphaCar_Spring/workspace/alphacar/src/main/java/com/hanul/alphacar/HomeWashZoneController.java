package com.hanul.alphacar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import homeMypage.HomeMyPageServiceImpl;

@Controller
public class HomeWashZoneController {
	
	@Autowired private HomeMyPageServiceImpl service;
	
	@RequestMapping ("/list.wa")
	public String list(HttpSession session, Model model) {
		model.addAttribute("wash_zone", service.company_list_all());
		return "washZone/list";	
	}
}
