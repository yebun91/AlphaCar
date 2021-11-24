package store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired private StoreDAO dao;
	
	@Override
	public List<StoreVO> store_list() {
		// TODO Auto-generated method stub
		return dao.store_list();
	}

//	@Override
//	public StoreVO store_detail(int store_number) {
//		// TODO Auto-generated method stub
//		return dao.store_detail(store_number);
//	}
//	
	
	@Override
	public StoreVO store_detail(String customer_email) {
		// TODO Auto-generated method stub
		return dao.store_detail(customer_email);
	}

	@Override
	public List<StoreVO> store_state(String customer_email) {
		// TODO Auto-generated method stub
		return dao.store_state(customer_email);
	}


	@Override
	public int store_register(RegisterVO vo) {
		// TODO Auto-generated method stub
		return dao.store_register(vo);
	}

	@Override
	public int store_file_register(StoreFileVO vo) {
		// TODO Auto-generated method stub
		return dao.store_file_register(vo);
	}

	@Override
	public int store_file_register(RegisterVO vo) {
		// TODO Auto-generated method stub
		return dao.store_file_register(vo);
	}


}
