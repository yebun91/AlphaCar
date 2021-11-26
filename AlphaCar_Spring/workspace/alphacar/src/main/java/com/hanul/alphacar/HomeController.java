package com.hanul.alphacar;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import homeNotice.HomeNoticePage;
import homeNotice.HomeNoticeServiceImpl;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired private HomeNoticeServiceImpl service;
	@Autowired private HomeNoticePage page;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("page", service.notice_list(page));
		return "index";
	}
}
