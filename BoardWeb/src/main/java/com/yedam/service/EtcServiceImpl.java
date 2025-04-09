package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVO;




public class EtcServiceImpl implements EtcService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	EventMapper mapper = sqlSession.getMapper(EventMapper.class);
	
	
	@Override
	public boolean insertEvent(EventVO evo) {
		// TODO Auto-generated method stub
		return mapper.insertEvent(evo)==1;
	}
	@Override
	public boolean deleteEvent(EventVO evo) {
		// TODO Auto-generated method stub
		return mapper.deleteEvent(evo)== 1;
	}
	@Override
	public List<EventVO> eventList() {
		// TODO Auto-generated method stub
		return mapper.selectEvent();
	}
	
	
	


}
