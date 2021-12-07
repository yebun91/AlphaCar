package com.hanul.alphacar;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import homeQna.QnaServiceImpl;
import homeQna.QnaVO;
import member.WebMemberVO;

@Controller
public class HomeQnaController {
	
	@Autowired private QnaServiceImpl service;
	

	//qna 새글쓰기
	@RequestMapping("/write.qna")
	public String write(HttpSession session, Model model) {
		return "qna/write";
	}
	
	// 신규 qna 저장 처리 요청
	@RequestMapping ("/insert.qna")
	public String insert (QnaVO vo, HttpSession session, MultipartFile file, String qna_search_index, 
			String qna_password) {
		
//					MemberVO member = (MemberVO) session.getAttribute("loginInfo");
//					vo.setWriter(member.getId());
		
		// 로그인 된 사용자의 id를 가져와 글쓴이(writer)에 담기 위한 처리
		vo.setCustomer_email( ( (WebMemberVO) session.getAttribute("loginInfo")).getCustomer_email() );
		System.out.println(vo.getCustomer_email());
		System.out.println(qna_search_index);
		String index = "";
		if (qna_search_index.equals("user-info") ) {
			index = "C";
		} else if(qna_search_index.equals("store") ) {
			index = "S";
		} else if(qna_search_index.equals("app_web") ) {
			index = "M";
		} else if(qna_search_index.equals("alphacar") ) {
			index = "A";
		}
		vo.setQna_attribute(index);
		vo.setQna_password(qna_password);
		
		// 화면에서 입력한 정보를 DB에 저장한 후 화면으로 연결(출력)
		service.qna_insert(vo);
		
		return "redirect:masterContact.mp"; // 리턴 시 공지사항 목록 화면으로 이동 처리
		}
	
	//qna 글 자세히 보기
	@RequestMapping("/detail.qna")
	public String detail(int qna_id, Model model, WebMemberVO mvo, HttpSession session) {
		
			service.qna_read(qna_id);
			
			model.addAttribute("vo", service.qna_detail(qna_id));
			model.addAttribute("crlf", "\r\n");
			return "qna/detail";
		
	}
	
	//qna 비밀번호 확인 화면 요청
	@RequestMapping("/check.qna")
	public String check(HttpSession session, Model model, int qna_id) {
		
		model.addAttribute("vo", service.check_pw(qna_id));
		return "qna/check";
	}

	
	//qna 글 수정
	@RequestMapping("/update.qna")
	public String update(HttpSession session, Model model, int qna_id) {
		
		model.addAttribute("vo", service.qna_detail(qna_id));
		return "qna/update";
	}
	
	
	// faq 수정 저장 처리 요청
	@RequestMapping ("/update_work.qna")
	public String update_work(QnaVO vo, HttpSession session, String qna_search_index) {
		
		String index = "";
		if (qna_search_index.equals("user-info") ) {
			index = "C";
		} else if(qna_search_index.equals("store") ) {
			index = "S";
		} else if(qna_search_index.equals("app_web") ) {
			index = "M";
		} else if(qna_search_index.equals("alphacar") ) {
			index = "A";
		}
		vo.setQna_attribute(index);
		
		service.qna_update(vo);	
		return "redirect:detail.qna?qna_id=" + vo.getQna_id();
	}
	
	//qna 글 삭제
	@RequestMapping("/delete.qna")
	public String delete(HttpSession session, Model model, int qna_id) {
		service.qna_delete(qna_id);
		return "redirect:masterContact.mp";
	}
	
	//qna 답글 작성화면 요청
	@RequestMapping("/reply.qna")
	public String reply(Model model, int qna_id) {
		// 원글의 상세 정보를 DB에서 조회하여 답글 화면에 출력
		model.addAttribute("vo", service.qna_detail(qna_id));
		return "qna/reply";
	}
	
	// 답글 저장 처리 요청
	@RequestMapping ("/reply_insert.qna")
	public String reply_insert (QnaVO vo, HttpSession session, int qna_id) {
		System.out.println(qna_id);
		// 로그인 된 사용자의 id를 가져와 글쓴이(writer)에 담기 위한 처리
		vo.setCustomer_email( ( (WebMemberVO) session.getAttribute("loginInfo")).getCustomer_email() );
//			vo = service.qna_pw(qna_id);
//			vo.setQna_password(vo.getQna_password());

		// 화면에서 입력한 정보를 DB에 저장한 후 화면으로 연결(출력)
		service.qna_reply_insert(vo);
		
		return "redirect:masterContact.mp";
	}
	
	//qna 답글 수정
	@RequestMapping("/replyUpdate.qna")
	public String replyUpdate(HttpSession session, Model model, int qna_id) {
		model.addAttribute("vo", service.qna_detail(qna_id));
		return "qna/replyUpdate";
	}
	
	// 답글 수정저장 처리 요청
	@RequestMapping ("/reply_update.qna")
	public String update_work(QnaVO vo, HttpSession session) {
		
		service.reply_update(vo);
		return "redirect:detail.qna?qna_id=" + vo.getQna_id();
	}
}
