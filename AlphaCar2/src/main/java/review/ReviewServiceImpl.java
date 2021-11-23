package review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired private ReviewDAO dao;
	
	
	
	@Override
	public List<ReviewVO> review_list(String customer_email) {
		// TODO Auto-generated method stub
		return dao.review_list(customer_email);
	}

	@Override
	public int review_insert(String score, String title, String content) {
		return dao.review_insert(score, title, content);
	}
	
	
	
}
