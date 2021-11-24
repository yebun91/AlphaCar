package member;

import java.util.HashMap;

import javax.inject.Qualifier;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MemberService{
	
	@Autowired private SqlSession sql;

	@Override
	public WebMemberVO member_login(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return sql.selectOne("member.mapper.member_login", map);
	}
}
