package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public List<ReplyVO> replyList(SearchDTO search) {
		return mapper.selectList(search);
	}

	@Override
	public boolean addReply(ReplyVO rvo) { // 입사: 사원생성, 금여생성, 근태 생성
		return mapper.insertReply(rvo) == 1;
	}

	@Override
	public boolean removeReply(int replyNo) {
		return mapper.deleteReply(replyNo) == 1;
	}

	@Override
	public ReplyVO getReply(int replyNo) {
		return mapper.selectReply(replyNo);
	}

	@Override
	public int getTotalCnt(int boardNo) {
		return mapper.selectReplyCnt(boardNo);
	}

	@Override
	public List<Map<String, Object>> replyListForDT(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.selectListForDT(boardNo);
	}

}
