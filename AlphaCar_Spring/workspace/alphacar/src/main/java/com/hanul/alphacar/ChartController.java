package com.hanul.alphacar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import homeChart.ChartVO;
import homeChart.HomeChartServiceImpl;
	

@Controller
public class ChartController {
	
	@Autowired private HomeChartServiceImpl service;
	
//	@RequestMapping("/")
//	public String chart(Model model) {
//		ArrayList<ChartVO> list = new ArrayList<ChartVO>();
//	
//		
//		model.addAttribute("list", list);
//		return  "home";
//	}
	
	
	@ResponseBody
	@RequestMapping("/month_list")
	public String month_list(Model model) {
		Gson gson = new Gson();
		List<ChartVO> list = new ArrayList<ChartVO>();
		ArrayList<Integer> log = new ArrayList<Integer>();
		ChartVO vo = new ChartVO(0, null, null);
		for (int i =0; i< 12; i++){
			log.add(i);
			vo.setMonth_log(log);
			
		}
		list = service.month_list(vo);
		for (int i = 0; i < list.size(); i++) {
			
			list.add(new ChartVO(1,i+"월","rgba(255, 99, 132, 1)"));
		}
		
		
		return gson.toJson(list);
	}
}
