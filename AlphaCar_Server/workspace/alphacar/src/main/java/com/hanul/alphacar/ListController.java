package com.hanul.alphacar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import store.RegisterVO;
import store.StoreFileVO;
import store.StoreServiceImpl;
import store.StoreVO;
import store.Store_FileVO;

@Controller
public class ListController {

	@Autowired private StoreServiceImpl service;
	
	
	@ResponseBody
	@RequestMapping("/anStoreRegister")
	public void anStoreRegister(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		System.out.println(req.getParameter("customer_email"));
		System.out.println(req.getParameter("store_addr"));
		System.out.println(req.getParameter("inventory"));
		
		ArrayList<String> storeInventory = new ArrayList<String>();
		for (int i =0; i< 9; i++){
            storeInventory.add("X");
        }
        for(int i =0; i<Integer.parseInt(req.getParameter("inventory")); i++){
            storeInventory.set(i, "Y");
        }
		
		
		String fileName = "";
		String realImgPath = "";
		
		RegisterVO vo = new RegisterVO();
		vo.setCustomer_email(req.getParameter("customer_email"));
		vo.setStore_name(req.getParameter("store_name"));
		vo.setStore_addr(req.getParameter("store_addr"));
		vo.setStore_tel(req.getParameter("store_tel"));
		vo.setStore_time(req.getParameter("store_time"));
		vo.setStore_dayoff(req.getParameter("store_dayoff"));
		vo.setIntroduce(req.getParameter("introduce"));
		vo.setInventory(Integer.parseInt(req.getParameter("inventory")));
		
		for (int i = 0; i < storeInventory.size(); i++) {
			vo.setNow_state(storeInventory.get(i));
			
		}
		

		vo.setStore_price(req.getParameter("store_price"));
		vo.setStore_master_name(req.getParameter("store_master_name"));
		vo.setStore_registration_number(req.getParameter("store_registration_number"));
		
		
		MultipartRequest multi = (MultipartRequest)req;
		
		ArrayList<MultipartFile> file = new ArrayList<MultipartFile>();
		file.add(multi.getFile("imgpath1"));
		file.add(multi.getFile("imgpath2"));
		file.add(multi.getFile("imgpath3"));
		
		for (int i = 0; i < file.size(); i++) {
			if(file.get(i) != null) {
				fileName = file.get(i).getOriginalFilename();
				System.out.println("fileName : " + fileName);
				
				if(file.get(i).getSize() > 0) {
					realImgPath = req.getSession().getServletContext()
							.getRealPath("/resources/");
					
					System.out.println("realpath : " + realImgPath);
					System.out.println("fileSize : " + file.get(i).getSize());
					
					try {
						file.get(i).transferTo(new File(realImgPath, fileName));
					} catch (Exception e) {
						e.getMessage();
					} 
					
				}
			
			
			}
			if (i==0) {
				vo.setImgname1(fileName);
				vo.setImgpath1(realImgPath);
			}else if(i==1) {

				vo.setImgname2(fileName);
				vo.setImgpath2(realImgPath);
			}else if(i==2) {

				vo.setImgname3(fileName);
				vo.setImgpath3(realImgPath);
			}
		}
	
		int result = service.store_file_register(vo);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", result +"");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		String data = gson.toJson(map);
		out.println(data);

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
	
	public void common(HttpServletResponse res) throws IOException {
		List<StoreVO> list = null;
		
		
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		String data = gson.toJson(list);
		out.println(data);
		
	}
}
