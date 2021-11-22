package review;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO implements ReviewService {
	@Autowired SqlSession sql;
	
	// 데이터 베이스와 연동 : 데이터베이스 초기화 해줌
	DataSource dataSource;
	
	@Override
	public int review_insert(ReviewVO vo) {
		
		return sql.insert("review.mapper.insert", vo);
	}

	@Override
	public ReviewVO review_select(int review_id) {
		return (ReviewVO) sql.selectList("review.mapper.select", review_id);
	}
	

}
