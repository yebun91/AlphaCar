package store;

import java.util.ArrayList;
import java.util.List;

public interface StoreService {

	List<StoreVO> store_list(); // ��ü ���� ���� ��ȸ
	
	StoreVO store_detail(String customer_email); // 1���� ���� �󼼳��� ��ȸ
	//StoreVO store_detail(int store_number); // 1���� ���� �󼼳��� ��ȸ
	
	List<StoreVO> store_state(String customer_email);
	
}
