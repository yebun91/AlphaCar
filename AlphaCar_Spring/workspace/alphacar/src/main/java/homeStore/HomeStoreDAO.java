package homeStore;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import homeNotice.HomeNoticeVO;
import member.WebMemberVO;

@Repository
public class HomeStoreDAO implements HomeStoreService {
	
	@Autowired private SqlSession sql;

	@Override
	public boolean store_insert(HomeStoreVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
