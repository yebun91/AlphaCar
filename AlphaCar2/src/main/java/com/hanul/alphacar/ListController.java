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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import favorite.FavoriteCustomerVO;
import favorite.FavoriteServiceImpl;
import favorite.FavoriteVO;

import member.MemberServiceImpl;
import store.RegisterVO;
import store.StoreServiceImpl;
import store.StoreVO;
import store.Store_FileVO;

@Controller
public class ListController {

	@Autowired private StoreServiceImpl service;
	@Autowired private MemberServiceImpl m_service;
	@Autowired private FavoriteServiceImpl f_service;
	
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
	@RequestMapping("/anSelectFile")
	public void anSelectFile(HttpServletRequest req , HttpServletResponse res) throws Exception {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		
		List<Store_FileVO> file = service.store_file();
		
		
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		String data = gson.toJson(file);
		out.println(data);
		
	}
	
	@ResponseBody
	@RequestMapping("/anStoreRegister")
	public void anStoreRegister(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
//		String fileName = "";
//		
//		MultipartRequest multi = (MultipartRequest)req;
//		MultipartFile file = multi.getFile("customer_picture");
//		
//		if(file != null) {
//			fileName = file.getOriginalFilename();
//			System.out.println("fileName : " + fileName);
//			
//			if(file.getSize() > 0) {
//				String realImgPath = req.getSession().getServletContext()
//						.getRealPath("/resources/");
//				
//				System.out.println("realpath : " + realImgPath);
//				System.out.println("fileSize : " + file.getSize());
//				
//				// 이미지 파일을 서버에 저장
//				try {
//					file.transferTo(new File(realImgPath, fileName));
//				} catch (Exception e) {
//					e.getMessage();
//				} 
//				
//			}
//		}		
		
//		RegisterVO vo = new RegisterVO(req.getParameter("customer_email"), vo.setStore_name(req.getParameter("store_name")),
//				vo.setStore_addr(req.getParameter("store_addr")), vo.setStore_addr(req.getParameter("store_addr")),
//				vo.setStore_tel(req.getParameter("store_tel")), vo.setStore_time(req.getParameter("store_time")),
//				vo.setStore_dayoff(req.getParameter("store_dayoff")), vo.setIntroduce(req.getParameter("introduce")),
//				vo.setStore_price(req.getParameter("store_price")), vo.setStore_master_name(req.getParameter("store_master_name")),
//				vo.setStore_registration_number(req.getParameter("store_registration_number")), vo.setImgpath(req.getParameter("imgpath")),
//				vo.setImgname(req.getParameter("imgname")));
//
//		int result = service.anJoin(vo);
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("result", result +"");
//		PrintWriter out = res.getWriter();
//		Gson gson = new Gson();
//		String data = gson.toJson(map);
//		out.println(data);
	}
	
	@ResponseBody
	@RequestMapping("/anSelectAllDetail")
	public void anSelectAllDetail(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		String param = req.getParameter("customer_email");
		System.out.println(param);
		
		List<StoreVO> list = service.store_state(param);
		
		System.out.println(list.size());
		
		
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		String data = gson.toJson(list);
		out.println(data);
		
	}
	
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
	
	
	//��ü ����Ʈ ��ȸ
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
