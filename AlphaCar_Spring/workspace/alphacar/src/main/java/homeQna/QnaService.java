package homeQna;

import java.util.List;

public interface QnaService {
	//공지글 신규 저장
	void qna_insert(QnaVO vo);
	
	//공지글 목록 조회 - 페이지 처리된
	QnaPage qna_list(QnaPage page);
	
	//공지글 목록 조회
	List<QnaVO> qna_list();
	
	//공지글 상세 조회
	QnaVO qna_detail(int id);
	
	//공지글 변경 저장
	void qna_update(QnaVO vo);
	
	//공지글 삭제
	void qna_delete(int id);
	
	//공지글 조회시 조회수 증가 처리
	void qna_read(int id);
}
