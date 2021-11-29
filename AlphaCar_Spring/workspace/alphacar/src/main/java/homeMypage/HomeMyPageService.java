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
}
