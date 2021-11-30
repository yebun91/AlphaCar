package homeMypage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import homeNotice.HomeNoticeVO;
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

	@Override
	public void company_delete(int store_number) {
		sql.delete("homeMyPage.mapper.company_delete", store_number);
	}

	@Override
	public List<WebMemberVO> customer_list() {
		return sql.selectList("homeMyPage.mapper.CustomerList");
	}

	@Override
	public CustomerPage customer_list(CustomerPage page) {
		//총 글의 개수를 조회(totalList)
		int pagecnt = sql.selectOne("homeMyPage.mapper.customerTotalList", page);
		page.setTotallist(pagecnt); //총 글의 수
		
		//전체 글을 조회하여 List 
		List<WebMemberVO> list = sql.selectList("homeMyPage.mapper.customerList", page);
		page.setList(list);
		return page;

	}
	

}
