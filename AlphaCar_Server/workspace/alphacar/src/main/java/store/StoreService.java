package store;

import java.util.ArrayList;
import java.util.List;

public interface StoreService {

	List<StoreVO> store_list(); // 전체 가게 정보 조회
	
	StoreVO store_detail(String customer_email); // 1건의 가게 상세내용 조회
	//StoreVO store_detail(int store_number); // 1건의 가게 상세내용 조회
	
	List<StoreVO> store_state(String customer_email);
	
}
