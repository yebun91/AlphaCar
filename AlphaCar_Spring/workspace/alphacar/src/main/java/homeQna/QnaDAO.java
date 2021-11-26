package homeQna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import homeNotice.HomeNoticeVO;

@Repository
public class QnaDAO implements QnaService {
	
	@Autowired private SqlSession sql;

	@Override
	public void qna_insert(QnaVO vo) {
		sql.insert("homeQna.mapper.homeInsert", vo);
		
	}

	@Override
	public QnaPage qna_list(QnaPage page) {
		//총 글의 개수를 조회(totalList)
		int pagecnt = sql.selectOne("homeQna.mapper.hometotalList", page);
		page.setTotallist(pagecnt); //총 글의 수
		
		//전체 글을 조회하여 List 
		List<QnaVO> list = sql.selectList("homeQna.mapper.homeQnaList", page);
		page.setList(list);
		return page;
	}

	@Override
	public List<QnaVO> qna_list() {
		// TODO Auto-generated method stub
		return sql.selectList("homeQna.mapper.homeQnaList");
	}

	@Override
	public QnaVO qna_detail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void qna_update(QnaVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void qna_delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void qna_read(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
