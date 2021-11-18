package review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired private ReviewDAO dao;
	
	@Override
	public int review_insert(ReviewVO vo) {
		return dao.review_insert(vo);
	}

}
