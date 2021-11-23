package review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO implements ReviewService {
	
	
	@Autowired private SqlSession sql;
	
	@Override
	public List<ReviewVO> review_list(String customer_email) {
		// TODO Auto-generated method stub
		return sql.selectList("review.mapper.list", customer_email);
	}
	
	@Override
	public int review_insert(String score, String title, String content) {
		
		
		return sql.insert("review.mapper.insert");
	}


}
