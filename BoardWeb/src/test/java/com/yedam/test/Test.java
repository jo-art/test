package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.MemberMapper;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;
import com.yedam.vo.ReplyVO;

public class Test {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		ReplyMapper mapper= sqlSession.getMapper(ReplyMapper.class);
		
		
		ReplyVO rvo= new ReplyVO();
		rvo.setBoardNo(103);
		rvo.setReply("댓글테스트");
		rvo.setReplyer("user99");
		int cnt = mapper.insertReply(rvo);
		if(cnt>0) {
			System.out.println("성공");
		}
		List<ReplyVO> list = mapper.selectList(103);
		for(ReplyVO reply :list) {
			System.out.println(reply.toString());
		}
	}
}
