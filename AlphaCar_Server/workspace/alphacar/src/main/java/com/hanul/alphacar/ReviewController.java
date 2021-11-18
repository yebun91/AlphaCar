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
		
		// 1. �ȵ���̵忡�� ���� �����͸� req�� �޾Ƽ� ������ ����
		String score = req.getParameter("rating");
		String title = req.getParameter("reviewTitle");
		String content = req.getParameter("reviewContent");
		
//		String score = "3.0";
//		String title = "��������1";
//		String content = "���䳻��1";
		
		ReviewVO vo = new ReviewVO();
		
		
		// 3. �ȵ���̵忡�� ���� ���� �ޱ� : ������ ���� ��쿡�� ����
		// �����̸��� ������ ���� �ȵ���̵忡�� �޾Ƽ� ��ü ��θ� �ϼ��Ѵ�
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
				
				// �̹��� ������ ������ ����
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
