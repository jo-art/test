package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

/*
 *  멤버 서비스(인터페이스) 구현하는 클래스
 */
public class MemberServiceImpl  implements MemberService{
	
	SqlSession sqlSession =DataSource.getInstance().openSession(true);
	MemberMapper mapper= sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO login(String id, String pw) { //기능 구현 넣어야함
		return mapper.selectMember(id, pw);
	}
	@Override
	public boolean addMember(MemberVO member) {
		// TODO Auto-generated method stub
		return mapper.insertMember(member)== 1; //처리된 건수를 리턴
	}

}
