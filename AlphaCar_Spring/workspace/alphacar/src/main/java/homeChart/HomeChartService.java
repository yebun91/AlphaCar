package homeChart;


import java.util.List;


public interface HomeChartService {
	//월별 이용자 수 조회
	List<ChartVO> month_list(ChartVO vo);
	
	List<ChartVO2> month_list();
}
