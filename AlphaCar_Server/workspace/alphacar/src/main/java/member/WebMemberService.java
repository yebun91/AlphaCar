package member;

import java.util.HashMap;

public interface WebMemberService {

	//아이디, 비번 일치하는 회원정보 조회
		WebMemberVO member_login(HashMap<String, String> map);
}
