package homeQna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired private QnaDAO dao;

	@Override
	public void qna_insert(QnaVO vo) {
		dao.qna_insert(vo);
		
	}

	@Override
	public QnaPage qna_list(QnaPage page) {
		// TODO Auto-generated method stub
		return dao.qna_list(page);
	}

	@Override
	public List<QnaVO> qna_list() {
		// TODO Auto-generated method stub
		return dao.qna_list();
	}

	@Override
	public QnaVO qna_detail(int id) {
		// TODO Auto-generated method stub
		return dao.qna_detail(id);
	}

	@Override
	public void qna_update(QnaVO vo) {
		dao.qna_update(vo);
		
	}

	@Override
	public void qna_delete(int id) {
		dao.qna_delete(id);
		
	}

	@Override
	public void qna_read(int id) {
		// TODO Auto-generated method stub
		dao.qna_read(id);
	}

	
	
	

}
