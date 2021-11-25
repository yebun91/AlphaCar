package store;

import java.util.ArrayList;
import java.util.List;

public interface StoreService {

	List<StoreVO> store_list(); //전체 가게 정보 조회
	
	StoreVO store_detail(String customer_email); //가게 하나의 세부정보 조회
	//StoreVO store_detail(int store_number); 
	
	List<StoreVO> store_state(String customer_email); //가게 하나의 세부정보와 상태 조회
	
	int store_register(RegisterVO vo); //가게 등록
	
	int store_file_register(StoreFileVO vo);
	
	int store_file_register(RegisterVO vo);
	
	List<Store_FileVO> store_file();
	
	
}