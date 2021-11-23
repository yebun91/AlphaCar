package com.hanul.alphacar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import review.ReviewServiceImpl;
import review.ReviewVO;

@Controller
public class ReviewController {
	
	@Autowired private ReviewServiceImpl service;
	
	@ResponseBody
	@RequestMapping("/anSelectReview")
	public void anSelectReview(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
	   
		
		List<ReviewVO> list = service.review_list(req.getParameter("customer_email"));
		
		
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		String data = gson.toJson(list);
		out.println(data);
		

		
	}
	

}
