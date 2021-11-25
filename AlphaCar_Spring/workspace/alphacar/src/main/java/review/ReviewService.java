package review;

import java.util.List;

public interface ReviewService {
	
	int review_insert(ReviewVO vo);
	ReviewVO review_select(int review_id);
	List<ReviewVO> review_list(String customer_email);

	
	
}
