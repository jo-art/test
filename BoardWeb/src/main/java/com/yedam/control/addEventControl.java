package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.EtcService;
import com.yedam.service.EtcServiceImpl;
import com.yedam.vo.EventVO;

public class addEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		String title=req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		//이벤트 등록
		EventVO evo = new EventVO();
		evo.setTitle(title);
		evo.setStartDate(start);
		evo.setEndDate(end);
		
		System.out.println(evo);
		
		//등록 서비스 호출
		Gson gson= new GsonBuilder().create();
		
		EtcService svc = new EtcServiceImpl();
		if(svc.insertEvent(evo)) {
			resp.getWriter().print("{\"retCode\": \"OK\"}");

		}else {
		
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
		
	}

}
