package com.yedam.service;

import com.yedam.vo.MemberVO;

/*
 * MemberService(인터페이스)-규칙.
 * MemberServiceDAO( Data Access Object) : jdbc 기능 구현
 * MemberServiceImpl : mybatis 기능구현 ---> 규칙 없이 구현 클래스들을 생성하면 충돌이 일어날수 있음 , 그래서 인터페이스 클래스를 생성하는 것
 */
public class MemberServiceDAO implements MemberService {

	@Override
	public MemberVO login(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMember(MemberVO member) {
		// TODO Auto-generated method stub
		return false;
	}

}
