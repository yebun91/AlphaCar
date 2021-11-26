package homeBestQna;

import java.util.List;

public interface BestQnaService {
	//공지글 신규 저장
	void faq_insert(BestQnaVO vo);
	
	//공지글 목록 조회 - 페이지 처리된
	BsetQnaPage faq_list(BsetQnaPage page);
	
	//공지글 목록 조회
	List<BestQnaVO> faq_list();
	
	//공지글 상세 조회
	BestQnaVO faq_detail(int id);
	
	//공지글 변경 저장
	void faq_update(BestQnaVO vo);
	
	//공지글 삭제
	void faq_delete(int id);
	
	//공지글 조회시 조회수 증가 처리
	void faq_read(int id);
}
