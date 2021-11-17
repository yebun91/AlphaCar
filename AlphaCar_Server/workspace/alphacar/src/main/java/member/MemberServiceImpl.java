package member;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired private MemberDAO dao;

	@Override
	public MemberVO anLogin(HashMap<String, String> map) {
		return dao.anLogin(map);
	}

	@Override
	public int anJoin(MemberVO vo) {
		return dao.anJoin(vo);
	}

	@Override
	public int anIdCheck(String id) {
		return dao.anIdCheck(id);
	}

	@Override
	public int anMemberUpdate(MemberVO vo) {
		return dao.anMemberUpdate(vo);
	}

	@Override
	public int anJoinNoImg(MemberVO vo) {
		return dao.anJoinNoImg(vo);
	}

}
