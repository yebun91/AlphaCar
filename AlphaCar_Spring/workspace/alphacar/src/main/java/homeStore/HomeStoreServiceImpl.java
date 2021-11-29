package homeStore;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.WebMemberVO;

@Service
public class HomeStoreServiceImpl implements HomeStoreService {
	
	@Autowired private HomeStoreDAO dao;

	@Override
	public boolean store_insert(HomeStoreVO vo) {
		// TODO Auto-generated method stub
		return dao.store_insert(vo);
	}

	

	

	

}
