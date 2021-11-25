package homeNotice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeNoticeServiceImpl implements HomeNoticeService {
	
	@Autowired private HomeNoticeDAO dao;

	@Override
	public void notice_insert(HomeNoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HomeNoticePage notice_list(HomeNoticePage page) {
		// TODO Auto-generated method stub
		return dao.notice_list(page);
	}

	@Override
	public void notice_reply_insert(HomeNoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HomeNoticeVO> notice_list() {
		return dao.notice_list();
	}

	@Override
	public HomeNoticeVO notice_detail(int id) {
		return dao.notice_detail(id);
	}

	@Override
	public void notice_update(HomeNoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notice_delete(int id) {
		dao.notice_delete(id);
		
	}

	@Override
	public void notice_read(int id) {
		dao.notice_read(id);
	}
	
	

}
