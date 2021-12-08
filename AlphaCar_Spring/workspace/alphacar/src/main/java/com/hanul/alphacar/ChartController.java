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
		ChartVO vo = new ChartVO();
		vo.setStore_number(234);
		List<ChartVO> list222  =service.month_list(vo);
	
		
		
		return gson.toJson(list222);
	}
}
