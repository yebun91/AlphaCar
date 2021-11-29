package com.hanul.alphacar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import homeStore.HomeStoreServiceImpl;
import homeStore.HomeStoreVO;
import member.WebMemberServiceImpl;
import member.WebMemberVO;

@Controller
public class HomeStoreController {
	
	@Autowired private HomeStoreServiceImpl service;
	@Autowired private CommonService common;
	
	
	//회원가입 요청
	@ResponseBody
	@RequestMapping(value = "/homeStoreRegister.st", produces = "text/html; charset=utf-8")
	public String homeStoreRegister(HttpSession session, HomeStoreVO vo, HttpServletRequest req, String join_company,
			MultipartFile file) {
		StringBuffer msg = new StringBuffer("<script>");
		ArrayList<String> inventory = new ArrayList<>();
		for (int i =0; i< 9; i++){
            inventory.add("X");
        }
        for(int i =0; i<Integer.parseInt(req.getParameter("inventory")); i++){
            inventory.set(i, "Y");
        }
		
//		if (!file.isEmpty()) {// 파일이 있는 경우
//			// 파일 첨부 처리 부분
//			//vo.setCustomer_picture(file.getOriginalFilename());
//			vo.setCustomer_picture(common.fileUpload("join", file, session));
//		}
		
		if (service.store_insert(vo)) {
			msg.append("alert('회원가입을 축하드립니다.'); location='")
				.append(req.getContextPath()).append("'");
		//	msg.append("alert('회원가입을 축하드립니다.'); location='login' ")
		} else {
			msg.append("alert('회원가입 실패'); location='homeJoin' ");
		}
		msg.append("</script>");
		return msg.toString();
	}
}
