package homeBestQna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BestQnaServiceImpl implements BestQnaService {
	
	@Autowired private BestQnaDAO dao;

	@Override
	public void faq_insert(BestQnaVO vo) {
		dao.faq_insert(vo);
		
	}

	@Override
	public BsetQnaPage faq_list(BsetQnaPage page) {
		// TODO Auto-generated method stub
		return dao.faq_list(page);
	}

	@Override
	public List<BestQnaVO> faq_list() {
		// TODO Auto-generated method stub
		return dao.faq_list();
	}

	@Override
	public BestQnaVO faq_detail(int id) {
		// TODO Auto-generated method stub
		return dao.faq_detail(id);
	}

	@Override
	public void faq_update(BestQnaVO vo) {
		dao.faq_update(vo);
		
	}

	@Override
	public void faq_delete(int id) {
		dao.faq_delete(id);
		
	}

	@Override
	public void faq_read(int id) {
		// TODO Auto-generated method stub
		dao.faq_read(id);
	}

	
	
	

}
