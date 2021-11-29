package homeMypage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.WebMemberVO;

@Repository
public class HomeMyPageDAO implements HomeMyPageService {

	@Autowired private SqlSession sql;

	@Override
	public int home_member_update(WebMemberVO vo) {
		return sql.update("homeMyPage.mapper.memberUpdate", vo);
	}

	@Override
	public List<HomeCompanyVO> company_list(String customer_email) {
		return sql.selectList("homeMyPage.mapper.company_select", customer_email);
	}
	

}
