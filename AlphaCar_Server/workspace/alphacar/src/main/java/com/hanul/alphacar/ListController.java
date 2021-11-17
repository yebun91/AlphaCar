package com.hanul.alphacar;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import store.StoreServiceImpl;
import store.StoreVO;

@Controller
public class ListController {

	@Autowired private StoreServiceImpl service;
	
//	@ResponseBody
//	@RequestMapping("anSelectDetail")
//	public void anSelectDetail(HttpServletRequest req, HttpServletResponse res, int store_number) throws IOException {
//		res.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html");
//		req.setCharacterEncoding("UTF-8");
//		
//		StoreVO vo = service.store_detail(store_number);
//		
//
//		PrintWriter out = res.getWriter();
//		Gson gson = new Gson();
//		String data = gson.toJson(vo);
//		out.println(data);
//		
//	}
	@ResponseBody
	@RequestMapping("/anSelectDetail")
	//@RequestMapping(value ="anSelectDetail", method = {RequestMethod.GET, RequestMethod.POST})
	public void anSelectDetail(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		System.out.println(req.getParameter("customer_email"));
		
		StoreVO vo = service.store_detail(req.getParameter("customer_email"));
		
		
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		String data = gson.toJson(vo);
		out.println(data);
		
	}
	
	
	//전체 리스트 조회
	@ResponseBody
	@RequestMapping("anSelectMulti")
	//@RequestMapping(value ="anSelectMulti", method = {RequestMethod.GET, RequestMethod.POST})
	public void anSelectMulti(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		List<StoreVO> list = service.store_list();
		
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		String data = gson.toJson(list);
		out.println(data);
		
		//return data;
	}
}
