package review;

import java.util.List;

public interface ReviewService {
	
	List<ReviewVO> review_list(String customer_email); // ��ü ���� ���� ��ȸ

	int review_insert(String score, String title, String content);	// 리뷰 쓰기
	
}
