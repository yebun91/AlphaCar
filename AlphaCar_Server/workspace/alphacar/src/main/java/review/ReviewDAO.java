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
	
	// ������ ���̽��� ���� : �����ͺ��̽� �ʱ�ȭ ����
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
