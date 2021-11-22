package review;

public interface ReviewService {
	
	int review_insert(ReviewVO vo);
	ReviewVO review_select(int review_id);
	
}
