package homeBestQna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import homeNotice.HomeNoticeVO;

@Repository
public class BestQnaDAO implements BestQnaService {
	
	@Autowired private SqlSession sql;

	@Override
	public void faq_insert(BestQnaVO vo) {
		sql.insert("homeBestQna.mapper.homeInsert", vo);
		
	}

	@Override
	public BsetQnaPage faq_list(BsetQnaPage page) {
		//총 글의 개수를 조회(totalList)
		int pagecnt = sql.selectOne("homeBestQna.mapper.hometotalList", page);
		page.setTotallist(pagecnt); //총 글의 수
		
		//전체 글을 조회하여 List 
		List<BestQnaVO> list = sql.selectList("homeBestQna.mapper.homeBestQnaList", page);
		page.setList(list);
		return page;
	}

	@Override
	public List<BestQnaVO> faq_list() {
		// TODO Auto-generated method stub
		return sql.selectList("homeBestQna.mapper.homeBestQnaList");
	}

	@Override
	public BestQnaVO faq_detail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void faq_update(BestQnaVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void faq_delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void faq_read(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
