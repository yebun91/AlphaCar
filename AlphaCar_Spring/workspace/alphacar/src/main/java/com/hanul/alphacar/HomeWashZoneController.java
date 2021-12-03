package com.hanul.alphacar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeWashZoneController {

	@RequestMapping ("/list.wa")
	public String list(HttpSession session) {
		return "washZone/list";	
	}
}
