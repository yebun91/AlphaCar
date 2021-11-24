package member;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired private MemberDAO dao;

	@Override
	public WebMemberVO member_login(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return dao.member_login(map);
	}
	

}
