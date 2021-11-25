package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO implements ReviewService {
	@Autowired private SqlSession sql;
	
	DataSource dataSource;
	
	@Override
	public int review_insert(ReviewVO vo) {
		
		return sql.insert("review.mapper.insert", vo);
	}

	@Override
	public ReviewVO review_select(int review_id) {
		return (ReviewVO) sql.selectList("review.mapper.select", review_id);
	}
	

	@Override
	public List<ReviewVO> review_list(String customer_email) {
		// TODO Auto-generated method stub
		return sql.selectList("review.mapper.list", customer_email);
	}
	

}