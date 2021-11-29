package member;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebMemberServiceImpl implements WebMemberService {

	@Autowired private WebMemberDAO dao;

	@Override
	public WebMemberVO member_login(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return dao.member_login(map);
	}

	@Override
	public boolean member_join(WebMemberVO vo) {
		// TODO Auto-generated method stub
		return dao.member_join(vo);
	}

}
