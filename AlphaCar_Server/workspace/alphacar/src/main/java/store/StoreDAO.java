package store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDAO implements StoreService{
	
	@Autowired private SqlSession sql;

	@Override
	public List<StoreVO> store_list() {
		// TODO Auto-generated method stub
		return sql.selectList("store.mapper.list");
	}

//	@Override
//	public StoreVO store_detail(int store_number) {
//		// TODO Auto-generated method stub
//		return sql.selectOne("store.mapper.detail", store_number);
//	}

	@Override
	public StoreVO store_detail(String customer_email) {
		// TODO Auto-generated method stub
		return sql.selectOne("store.mapper.detail", customer_email);
	}

	@Override
	public List<StoreVO> store_state(String customer_email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
