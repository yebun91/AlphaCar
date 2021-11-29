package homeMypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.WebMemberVO;

@Service
public class HomeMyPageServiceImpl implements HomeMyPageService {

	@Autowired private HomeMyPageDAO dao;

	@Override
	public int home_member_update(WebMemberVO vo) {
		return dao.home_member_update(vo);
	}

	@Override
	public List<HomeCompanyVO> company_list(String customer_email) {
		return dao.company_list(customer_email);
	}
}