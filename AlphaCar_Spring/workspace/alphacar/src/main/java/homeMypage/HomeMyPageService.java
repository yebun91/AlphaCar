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
	//회원 정보 리스트로 불러오기
	List<WebMemberVO> customer_list();
	//공지글 목록 조회 - 페이지 처리된
	CustomerPage customer_list(CustomerPage page);
<<<<<<< HEAD
	//회원정보 하나 불러오기
	WebMemberVO home_member_select(String customer_email);
=======

	//신규 가게 등록
	int company_insert(HomeStoreVO vo);
	
	//가게 수정
	void company_update(HomeStoreVO vo);
	
	//가게 id를 기준으로 회사 정보 조회
	List<HomeStoreVO> companyId_list(int store_number);
}
>>>>>>> 08fe956823cfb828acc11197816c06c5e611dfe8
}
