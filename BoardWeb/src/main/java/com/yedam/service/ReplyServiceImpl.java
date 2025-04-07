package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl  implements ReplyService{
	SqlSession sqlSession =DataSource.getInstance().openSession(true);
	ReplyMapper mapper= sqlSession.getMapper(ReplyMapper.class);
	@Override
	public List<ReplyVO> replyList(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.selectList(boardNo);
	}

	@Override
	public boolean addReply(ReplyVO rvo) { //입사: 사원생성, 금여생성, 근태 생성
		// TODO Auto-generated method stub
		return mapper.insertReply(rvo)==1;
	}

	@Override
	public boolean removeReply(int replyNo) {
		// TODO Auto-generated method stub
		return mapper.deleteReply(replyNo)==1;
	}

	@Override
	public ReplyVO getReply(int replyNo) {
		// TODO Auto-generated method stub
		return mapper.selectReply(replyNo);
	}
	
}
