package com.hanul.alphacar;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

import common.CommonService;
import homeBestQna.BestQnaServiceImpl;
import homeBestQna.BestQnaVO;
import member.WebMemberVO;

@Controller
public class HomeServiceController {
	@Autowired private BestQnaServiceImpl service;
	@Autowired private CommonService common;
	
	@RequestMapping(value="/uploadSummernoteImageFile", produces = "application/json; charset=utf8")
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request )  {
		JsonObject jsonObject = new JsonObject();
		
        /*
		 * String fileRoot = "C:\\summernote_image\\"; // 외부경로로 저장을 희망할때.
		 */
		
		// 내부경로로 저장
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		String fileRoot = contextRoot+"resources/img/fileupload/";
		
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot + savedFileName);	
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", "resources/img/fileupload/"+savedFileName); // contextroot + resources + 저장할 내부 폴더명
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		String a = jsonObject.toString();
		return a;
	}
	
//	@RequestMapping(value="/uploadSummernoteImageFile", produces = "application/json")
//	@ResponseBody
//	public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, BestQnaVO vo) {
//		
//		JsonObject jsonObject = new JsonObject();
//		
//		String fileRoot = "C:\\summernote_image\\";	//저장될 외부 파일 경로
//		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
//		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
//				
//		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
//		
//		File targetFile = new File(fileRoot + savedFileName);	
//		
//		try {
//			InputStream fileStream = multipartFile.getInputStream();
//			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
//			jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
//			jsonObject.addProperty("responseCode", "success");
//			if ( ! multipartFile.isEmpty() ) {// 파일이 있는 경우
//				// 파일 첨부 처리 부분
//				vo.setBest_qna_filename(savedFileName);
//				vo.setBest_qna_filepath(targetFile+"");
//			}
//				
//		} catch (IOException e) {
//			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
//			jsonObject.addProperty("responseCode", "error");
//			e.printStackTrace();
//		}
//		
//		return jsonObject;
//	}
	//faq 리스트로 가기
	@RequestMapping("/list.se")
	
	public String list(HttpSession session, Model model,
			//@RequestParam (defaultValue = "1") int curPage,
			String search, String keyword) {
		//System.out.println(service.faq_list());
		List<BestQnaVO> list =  service.faq_list();
		model.addAttribute("list",list);
		//DB에서 공지글 목록을 조회한 후 목록화면에 출력
		//model.addAttribute("notice_page", service.faq_list(page));
		return "service/list";
	}
	
	// 신규 공지사항 저장 처리 요청
	@RequestMapping ("/insert.se")
	public String insert (BestQnaVO vo, HttpSession session, MultipartFile file, String notice_search_index) {
		
//			MemberVO member = (MemberVO) session.getAttribute("loginInfo");
//			vo.setWriter(member.getId());
		
		// 로그인 된 사용자의 id를 가져와 글쓴이(writer)에 담기 위한 처리
		vo.setCustomer_email( ( (WebMemberVO) session.getAttribute("loginInfo")).getCustomer_email() );
		System.out.println(vo.getCustomer_email());
		System.out.println(notice_search_index);
		String index = "";
		if (notice_search_index.equals("user-info") ) {
			index = "C";
		} else if(notice_search_index.equals("store") ) {
			index = "S";
		} else if(notice_search_index.equals("app_web") ) {
			index = "M";
		} else if(notice_search_index.equals("alphacar") ) {
			index = "A";
		}
		vo.setBest_qna_attribute(index);
		
		
//		if ( ! file.isEmpty() ) {// 파일이 있는 경우
//			// 파일 첨부 처리 부분
//			vo.setBest_qna_filename(savedFileName);
//			vo.setBest_qna_filepath(targetFile+"");
//		}
		
		
		// 화면에서 입력한 정보를 DB에 저장한 후 화면으로 연결(출력)
		service.faq_insert(vo);
		
		return "redirect:list.se"; // 리턴 시 공지사항 목록 화면으로 이동 처리
		}
	
	@RequestMapping("/write.se")
	public String write(HttpSession session, Model model) {
		return "service/write";
	}
	
	@RequestMapping("/detail.se")
	public String detail(int id, Model model) {
		// 클릭시 조회수 증가
		service.faq_read(id);
		
		model.addAttribute("vo", service.faq_detail(id));
		model.addAttribute("crlf", "\r\n");
		//model.addAttribute("page", page);
				
		
		return "service/detail";
	}
	
	@RequestMapping("/update.se")
	public String update(HttpSession session, Model model) {
		return "service/update";
	}
	
	@RequestMapping("/delete.se")
	public String delete(HttpSession session, Model model) {
		return "redirect:list.se";
	}
	@RequestMapping("/customer_write.se")
	public String customer_write(HttpSession session, Model model) {
		return "service/customer_write";
	}
}
