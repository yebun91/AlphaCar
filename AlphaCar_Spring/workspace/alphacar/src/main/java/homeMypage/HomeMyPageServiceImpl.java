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

	@Override
	public void company_delete(int store_number) {
		dao.company_delete(store_number);
	}

	@Override
	public List<WebMemberVO> customer_list() {
		return dao.customer_list();
	}

	@Override
	public CustomerPage customer_list(CustomerPage page) {
		return dao.customer_list(page);
	}

	@Override
	public void company_delete(int store_number) {
		dao.company_delete(store_number);
	}
	
	@Override
	public int company_insert(HomeStoreVO vo) {
		// TODO Auto-generated method stub
		return dao.company_insert(vo);
	}

	@Override
	public void company_update(HomeStoreVO vo) {
		dao.company_update(vo);
		
	}

	@Override
	public List<HomeStoreVO> companyId_list(int store_number) {
		// TODO Auto-generated method stub
		return dao.companyId_list(store_number);
	}
}
