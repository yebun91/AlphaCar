package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class WebMemberDAO implements WebMemberService {

	@Autowired private SqlSession sql;
	
	@Override
	public WebMemberVO member_login(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return sql.selectOne("webmember.mapper.member_login", map);
	}

	@Override
	public boolean member_join(WebMemberVO vo) {
		// TODO Auto-generated method stub
		return sql.insert("webmember.mapper.member_join", vo) == 1 ? true : false;
	}
}
