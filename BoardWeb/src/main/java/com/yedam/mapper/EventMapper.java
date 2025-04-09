package com.yedam.mapper;

import java.util.List;


import com.yedam.vo.EventVO;

public interface EventMapper {
	 //목록
	List<EventVO> selectEvent(); //이벤트 목록
	int insertEvent(EventVO evo); //이벤트 등록
	int deleteEvent(EventVO evo); //이벤트 삭제
	
}
