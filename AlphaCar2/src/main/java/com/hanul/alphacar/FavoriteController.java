package com.hanul.alphacar;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import favorite.FavoriteCustomerVO;
import favorite.FavoriteServiceImpl;
import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class FavoriteController {
	
	@Autowired private FavoriteServiceImpl service;
	

	  @ResponseBody
	  @RequestMapping(value = "/anFavoriteDel") public void
	  anFavoriteDel(HttpServletRequest req , HttpServletResponse res) throws Exception { 
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html"); 
		req.setCharacterEncoding("UTF-8");
	int fav_number =Integer.parseInt(req.getParameter("fav_number"));
	//	String customer_email =req.getParameter("customer_email");
		
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put( "fav_number", fav_number);
//		map.put( "customer_email" , req.getParameter("customer_email"));
		
		service.favorite_delete(fav_number); 
		  
		  
	  
	  
	  }
	  
	
	
	@ResponseBody
	@RequestMapping("/anFavorite")
	public void anFavorite(HttpServletRequest req , HttpServletResponse res) throws Exception {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		List<FavoriteCustomerVO> fav = service.favorite_search(req.getParameter("customer_email"));
		

		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		String data = gson.toJson(fav);
		out.println(data);
		
	}

	
	@ResponseBody
	@RequestMapping("anFavoriteInsert")
	public void favorite_insert (HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		
	//	FavoriteVO vo = new FavoriteVO(req.getParameter("customer_email"), req.getParameter("Stroe_number"));
		
	/*
	 * int result = service.favorite_insert();
	 * 
	 * 
	 * HashMap<String, String> map = new HashMap<String, String>();
	 * map.put("result", result +""); PrintWriter out = res.getWriter(); Gson gson =
	 * new Gson(); String data = gson.toJson(map); out.println(data);
	 */
		
	}
}
