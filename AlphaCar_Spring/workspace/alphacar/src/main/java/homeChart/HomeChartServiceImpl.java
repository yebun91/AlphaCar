package homeChart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HomeChartServiceImpl implements HomeChartService {

	@Autowired private HomeChartDAO dao;

	@Override
	public List<ChartVO> month_list(ChartVO vo) {
		// TODO Auto-generated method stub
		return dao.month_list(vo);
	}

	@Override
	public List<ChartVO2> month_list() {
		// TODO Auto-generated method stub
		return dao.month_list();
	}

	

}
