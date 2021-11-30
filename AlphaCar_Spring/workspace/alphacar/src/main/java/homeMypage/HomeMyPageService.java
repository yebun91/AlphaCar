package homeMypage;


import java.util.List;

import member.WebMemberVO;

public interface HomeMyPageService {
	//회원 정보 수정
	int home_member_update(WebMemberVO vo);
	//내 회사 불러오기
	List<HomeCompanyVO> company_list(String customer_email);
	//회사 삭제
	void company_delete(int store_number);
	//회원 정보 불러오기
	List<WebMemberVO> customer_list();
	//공지글 목록 조회 - 페이지 처리된
	CustomerPage customer_list(CustomerPage page);
}
