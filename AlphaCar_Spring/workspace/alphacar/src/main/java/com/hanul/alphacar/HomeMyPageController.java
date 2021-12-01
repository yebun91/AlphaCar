package com.hanul.alphacar;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import common.CommonService;
import homeMypage.CustomerPage;
import homeMypage.HomeMyPageServiceImpl;
import homeMypage.HomeStoreFileVO;
import homeMypage.HomeStoreVO;
import homeQna.QnaPage;
import homeQna.QnaServiceImpl;
import homeQna.QnaVO;
import member.WebMemberServiceImpl;
import member.WebMemberVO;

@Controller
public class HomeMyPageController {
	
	@Autowired private CommonService common;
	@Autowired private HomeMyPageServiceImpl homeService;
	@Autowired private CustomerPage c_page;
	@Autowired private WebMemberServiceImpl member;
	@Autowired private QnaServiceImpl service;
	@Autowired private QnaPage page;
	
	@RequestMapping("/mypage.mp")
	public String login(HttpSession session) {
		
	  HashMap<String, String> map = new HashMap<String, String>();
	  map.put("customer_email", "e"); map.put("customer_pw", "e");
	  session.setAttribute("loginInfo", member.member_login(map));
		 
		
		return "mypage/mypage";
	}
	//회원정보 수정 페이지로 이동
	@RequestMapping("/memberUpdate.mp")
	public String memberUpdate() {
		return "mypage/member_update";
	}
	//회원정보 수정 처리
	@RequestMapping("/memberSubmit.mp")
	public String memberUpdateWork(WebMemberVO vo, MultipartFile image_file, HttpSession session, String attach) {
		WebMemberVO member = (WebMemberVO) session.getAttribute("loginInfo");
		String uuid = session.getServletContext().getRealPath("resources")
				+ "/" + member.getCustomer_picture();
			
		//전송한 이미지 파일이 있다면
		if (! image_file.isEmpty()) {
			vo.setCustomer_picture(common.fileUpload("profiles", image_file, session));
			//기존에 가지고 있었던 파일 패스값이 있다면
			if ( member.getCustomer_picture() != null ) {
				File f = new File ( uuid );
				// 기존 첨부 파일 삭제
				if (f.exists()) f.delete();
			} 
			
		}else {
			//전송한 이미지가 없을 경우 기존 주소 유지
			vo.setCustomer_picture(member.getCustomer_picture());
		}
		
		//화면에서 변경 입력한 정보를 db에 변경 저장한 후 상세화면으로 연결
		homeService.home_member_update(vo);	
		return "redirect:mypage.mp";

	}	
    //회원 탈퇴
    @RequestMapping("/memberDelete.mp")
    public String memberDelete(HttpSession session, String customer_email) {
        homeService.home_member_delete(customer_email);
        session.removeAttribute("loginInfo");
        return "redirect:/";
    }
    
	//내 가게 정보
	@RequestMapping("/memberCompany.mp")
	public String memberCompany(HttpSession session, Model model) {
		WebMemberVO member = (WebMemberVO) session.getAttribute("loginInfo");
		model.addAttribute("company", homeService.company_list(member.getCustomer_email()));
		return "mypage/member_company";
	}
	
	
	
	//1:1 문의 내역
	@RequestMapping("/memberContact.mp")
	public String memberContact(HttpSession session, Model model, 
			@RequestParam (defaultValue = "1") int curPage,
			String search, String keyword, QnaVO vo) {
		
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		//((WebMemberVO) session.getAttribute("loginInfo")).getCustomer_email() ;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("customer_email", ((WebMemberVO) session.getAttribute("loginInfo")).getCustomer_email());
		map.put("page", page);
		//DB에서 공지글 목록을 조회한 후 목록화면에 출력
		model.addAttribute("page", service.member_qna_list(map));
		
		return "mypage/member_contact";
	}

	//가게 삭제
	@RequestMapping("/memberCompanyDelete.mp")
	public String memberCompanyDelete(int store_number) {
		homeService.company_delete(store_number);
		return "redirect:memberCompany.mp";
	}
	
	//가게 그래프 보러가기
	@RequestMapping("/memberCompanyGraph.mp")
	public String memberCompanyGraph(HttpSession session, Model model) {
		return "mypage/member_company_graph";
	}
	
	//가게 수정 페이지 요청
	@RequestMapping("/memberCompanyUpdate.mp")
	public String memberCompanyUpdate(HttpSession session, Model model, int store_number ) {
		System.out.println(store_number);
		model.addAttribute("vo", homeService.companyId_list(store_number));
		model.addAttribute("img", homeService.company_img(store_number));
		
		return "mypage/member_company_update";
	}

	// 가게 수정 저장 처리 요청
	
	@RequestMapping ("/update_work.mp")
	public String update_work(HomeStoreVO vo, HttpSession session, int inventory, int store_number, HomeStoreFileVO fileVo,
			MultipartHttpServletRequest req) {
		ArrayList<String> storeInventory = new ArrayList<>();
		MultipartFile multiFile =  (MultipartFile) req.getFile("file");
		//MultipartFile multipartFile = multiFile.getFile("file");
		
		//HomeStoreVO store = homeService.companyId_list(store_number);
		ArrayList<String> imgpath = new ArrayList<String>();
		List<HomeStoreFileVO> fileListVO = homeService.company_img(store_number);
		
		
		for (int i =0; i< 9; i++){
			storeInventory.add("X");
       	}
		for(int i =0; i<inventory; i++){
			storeInventory.set(i, "Y");
   		}
    	for (int i = 0; i < storeInventory.size(); i++) {
			vo.setNow_state(storeInventory.get(i));
			
		}
    	vo.setStore_number(store_number);
    	
    	homeService.company_update(vo);
    	
    	// 원래 첨부된 파일이 있었다면 물리적인 디스크에서 해당 파일 삭제
    	// 서버에 파일이 있는지 파악
    	
    	for (int i = 0; i < fileListVO.size(); i++) {
    		String uuid = session.getServletContext().getRealPath("resources")
    				+ "/" + fileListVO.get(i).getImgpath();
//    		
//    		// 원래 파일이 첨부된 경우 이전 파일을 삭제하고 변경한 파일을 저장
//    		
//    			//vo.setFilename(file.getOriginalFilename());
//    			//vo.setFilepath( common.fileUpload("notice", file, session) );
//    			fileVo.setImgname(multiFile.getOriginalFilename());
//    			fileVo.setImgpath(common.fileUpload("company", multiFile, session));
//    			
//	    		if (fileListVO.get(i).getImgname() != null) {
//	    			// 파일 정보를 File 형태의 f 에 할당
//					File f = new File ( uuid );
//					// 기존 첨부 파일이 있다면 삭제
//					if (f.exists()) f.delete();
//	    		} else {
//	    			fileVo.setImgname(fileListVO.get(i).getImgname());
//	    			fileVo.setImgpath(fileListVO.get(i).getImgpath());
//	    		}
//	    		fileVo.setRank(i);
//	    		homeService.companyImg_update(fileVo);
	    		
	    		if (! multiFile.isEmpty()) {
	    			// 원래 첨부 파일이 없었는데 수정시 첨부한 경우
	    			fileVo.setImgname(multiFile.getOriginalFilename());
	    			fileVo.setImgpath(common.fileUpload("company", multiFile, session));
	    			
	    			// 원래 첨부된 파일이 있었다면 물리적인 디스크에서 해당 파일 삭제
	    			// 서버에 파일이 있는지 파악
	    			if ( fileListVO.get(i).getImgname() != null ) {
	    				// 파일 정보를 File 형태의 f 에 할당
	    				File f = new File ( uuid );
	    				// 기존 첨부 파일이 있다면 삭제
	    				if (f.exists()) f.delete();
	    			}
	    		} else {
	    			// 파일을 첨부하지 않은 경우
	    			// 원래 첨부된 파일이 있었는데 삭제한 경우 
	    			//if ( attach.isEmpty() ) {               // 첨부된 파일명이 없을 때
	    				if (fileListVO.get(i).getImgpath() != null) {	// 원래 첨부된 파일이 있었다면
	    					File f = new File (uuid);
	    					if (f.exists()) f.delete();	// 물리 디스크의 파일을 삭제
	    				} else {
		    				// 원래 첨부된 파일을 그대로 사용하는 경우	
	    					fileVo.setImgname(fileListVO.get(i).getImgname());
	    	    			fileVo.setImgpath(fileListVO.get(i).getImgpath());
		    			}
	    			}
		    		fileVo.setRank(i);
		    		homeService.companyImg_update(fileVo);
	    		}
	    		
    		
    	
		
    	
        
		
		return "redirect:memberCompany.mp";
	}
	
	//신규 가게등록 페이지 요청
	@RequestMapping("/memberCompanyInsert.mp")
	public String memberCompanyInsert(HttpSession session, Model model) {
		return "mypage/member_company_insert";
	}
	
	//신규 가게 저장 요청
	@ResponseBody
	@RequestMapping(value = "/homeStoreRegister.mp", produces = "text/html; charset=utf-8")
	public String homeStoreRegister(HttpSession session, HomeStoreVO vo, HttpServletRequest req, String join_company,
			MultipartFile file, int inventory, MultipartHttpServletRequest mtfRequest) {
		StringBuffer msg = new StringBuffer("<script>");
		
		vo.setCustomer_email( ( (WebMemberVO) session.getAttribute("loginInfo")).getCustomer_email() );
		
		ArrayList<String> storeInventory = new ArrayList<>();
		for (int i =0; i< 9; i++){
			storeInventory.add("X");
        }
        for(int i =0; i<inventory; i++){
        	storeInventory.set(i, "Y");
        }
        
        for (int i = 0; i < storeInventory.size(); i++) {
			vo.setNow_state(storeInventory.get(i));
			
		}
        
        System.out.println(file);

		
//	        ArrayList<MultipartFile> file = new ArrayList<MultipartFile>();
//			file.add(multi.getFile("imgpath1"));
//			file.add(multi.getFile("imgpath2"));
//			file.add(multi.getFile("imgpath3"));
//			
//			for (int i = 0; i < file.size(); i++) {
//				if(file.get(i) != null) {
//					fileName = file.get(i).getOriginalFilename();
//					System.out.println("fileName : " + fileName);
//					
//					if(file.get(i).getSize() > 0) {
//						realImgPath = req.getSession().getServletContext()
//								.getRealPath("/resources/");
//						
//						System.out.println("realpath : " + realImgPath);
//						System.out.println("fileSize : " + file.get(i).getSize());
//						
//						// 이미지 파일을 서버에 저장
//						try {
//							file.get(i).transferTo(new File(realImgPath, fileName));
//						} catch (Exception e) {
//							e.getMessage();
//						} 
//						
//					}
//				
//				
//				}
//				if (i==0) {
//					vo.setImgname1(fileName);
//					vo.setImgpath1(realImgPath);
//				}else if(i==1) {
//
//					vo.setImgname2(fileName);
//					vo.setImgpath2(realImgPath);
//				}else if(i==2) {
//
//					vo.setImgname3(fileName);
//					vo.setImgpath3(realImgPath);
//				}
//			}
//			
		if (homeService.company_insert(vo) == 0) {
		//	msg.append("alert('회원가입을 축하드립니다.'); location='login' ")
			msg.append("alert('가게등록 실패'); location='memberCompanyInsert.mp' ");
		} else {
			msg.append("alert('가게 등록이 완료되었습니다!'); location='")
			.append(req.getContextPath()).append("'");
		}
		msg.append("</script>");
		return msg.toString();
	}
	
	//회원 정보 리스트로 반환
	@RequestMapping("/masterMemberList.mp")
	public String masterMemberList(HttpSession session, Model model, 
			@RequestParam (defaultValue = "1") int curPage,
			String search, String keyword) {
		
		c_page.setCurPage(curPage);
		c_page.setSearch(search);
		c_page.setKeyword(keyword);
		
		model.addAttribute("page", homeService.customer_list(c_page));
		return "mypage/master_member_list";
	}
	
	//히든페이지
	@RequestMapping("/hidden.mp")
	public String hidden(HttpSession session, Model model, 
			@RequestParam (defaultValue = "1") int curPage,
			String search, String keyword, String customer_email) {
		
		c_page.setCurPage(curPage);
		c_page.setSearch(search);
		c_page.setKeyword(keyword);
		
		WebMemberVO vo = new WebMemberVO();
		vo.setCustomer_email(customer_email);
		
		model.addAttribute("uri", "mastermemberUpdate.mp");
		model.addAttribute("page", c_page);
		model.addAttribute("vo", vo);
		return "mypage/redirect";
	}
	
	//회원정보 수정 마스터 페이지로 이동
	@RequestMapping("/mastermemberUpdate.mp")
	public String masterMemberUpdate(Model model, String customer_email) {
		WebMemberVO vo = homeService.home_member_select(customer_email);
		model.addAttribute("vo", vo);

		
		return "mypage/master_member_update";
	}
	
	//마스터가 하는 회원 삭제
    @RequestMapping("/mastermemberDelete.mp")
    public String mastermemberDelete(HttpSession session, String customer_email) {
        homeService.home_member_delete(customer_email);
        session.removeAttribute("loginInfo");
        return "redirect:masterMemberList.mp";
        
    }
    //마스터가 하는 회원정보 수정 처리
  	@RequestMapping("/mastermemberSubmit.mp")
  	public String mastermemberUpdateWork(WebMemberVO vo, MultipartFile image_file, HttpSession session, String attach) {
  		String uuid = session.getServletContext().getRealPath("resources")
  				+ "/" + vo.getCustomer_picture();
  		//전송한 이미지 파일이 있다면
  		if (! image_file.isEmpty()) {
  			vo.setCustomer_picture(common.fileUpload("profiles", image_file, session));
  			//기존에 가지고 있었던 파일 패스값이 있다면
  			if ( vo.getCustomer_picture() != null ) {
  				File f = new File ( uuid );
  				// 기존 첨부 파일 삭제
  				if (f.exists()) f.delete();
  			} 
  			
  		}else {
  			//전송한 이미지가 없을 경우 기존 주소 유지
  			vo.setCustomer_picture(vo.getCustomer_picture());
  		}
  		homeService.home_member_update(vo);	
  		//화면에서 변경 입력한 정보를 db에 변경 저장한 후 상세화면으로 연결

  		return "redirect:masterMemberList.mp";

  	}
	
	//1:1문의 처리
	@RequestMapping("/masterContact.mp")
	public String masterContact(HttpSession session, Model model, 
			@RequestParam (defaultValue = "1") int curPage,
			String search, String keyword) {
		
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		
		//DB에서 공지글 목록을 조회한 후 목록화면에 출력
		model.addAttribute("page", service.qna_list(page));
		return "mypage/master_contact";
	}
	
}
