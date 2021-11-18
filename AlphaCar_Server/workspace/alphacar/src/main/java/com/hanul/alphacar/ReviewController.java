package com.hanul.alphacar;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import review.ReviewServiceImpl;
import review.ReviewVO;

@Controller
public class ReviewController {
	
	
	@Autowired private ReviewServiceImpl service;
	
	@ResponseBody
	@RequestMapping(value="/review", method = {RequestMethod.GET, RequestMethod.POST})
	public int review(HttpServletRequest req, Model model) {
		
		// 1. 안드로이드에서 보낸 데이터를 req로 받아서 변수에 저장
		String score = req.getParameter("rating");
		String title = req.getParameter("reviewTitle");
		String content = req.getParameter("reviewContent");
		
//		String score = "3.0";
//		String title = "리뷰제목1";
//		String content = "리뷰내용1";
		
		ReviewVO vo = new ReviewVO();
		
		
		// 3. 안드로이드에서 보낸 파일 받기 : 파일을 보낸 경우에만 실행
		// 파일이름만 저장해 놓고 안드로이드에서 받아서 전체 경로를 완성한다
		String fileName = "";
		
		MultipartRequest multi = (MultipartRequest)req;
		MultipartFile file = multi.getFile("imgRealPath");
		
		if(file != null) {
			fileName = file.getOriginalFilename();
			System.out.println("fileName : " + fileName);
			
			if(file.getSize() > 0) {
				String realImgPath = req.getSession().getServletContext()
						.getRealPath("/resources/");
				
				System.out.println("realpath : " + realImgPath);
				System.out.println("fileSize : " + file.getSize());
				
				// 이미지 파일을 서버에 저장
				try {
					file.transferTo(new File(realImgPath, fileName));
				} catch (Exception e) {
					e.getMessage();
				} 
				
			}
		}
		
		
		vo.setScore(score);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setFileName(fileName);
		vo.setFilePath("D:\\Study_Android_Spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\AlphaCar2\\resources\\"+fileName);

		System.out.println(fileName);
		
		return service.review_insert(vo);
	}
	
}
