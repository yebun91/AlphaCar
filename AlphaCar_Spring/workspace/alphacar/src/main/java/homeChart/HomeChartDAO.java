package homeChart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class HomeChartDAO implements HomeChartService {

	@Autowired private SqlSession sql;

	@Override
	public List<ChartVO> month_list(ChartVO vo) {
		// TODO Auto-generated method stub
		return sql.selectList("homeChart.mapper.month_list", vo);
	}

	@Override
	public List<ChartVO2> month_list() {
		// TODO Auto-generated method stub
		return sql.selectList("homeChart.mapper.month_list2");
	}

	


}
