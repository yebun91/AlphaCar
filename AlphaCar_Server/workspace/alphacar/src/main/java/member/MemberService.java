package member;

import java.util.HashMap;

public interface MemberService {

	//안드로이드 멤버 로그인 확인
	MemberVO anLogin(HashMap<String, String> map);
	//안드로이드 멤버 회원가입
	int anJoin(MemberVO vo);
	//안드로이드 멤버 회원가입 이미지없이
	int anJoinNoImg(MemberVO vo);
	//멤버 아이디 중복 확인
	int anIdCheck(String id);
	//멤버 정보 변경
	int anMemberUpdate(MemberVO vo);
}
