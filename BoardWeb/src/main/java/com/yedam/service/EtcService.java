package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;


public interface EtcService {

	List<EventVO> eventList();
	boolean insertEvent(EventVO evo);
	boolean deleteEvent(EventVO evo);
	
}
