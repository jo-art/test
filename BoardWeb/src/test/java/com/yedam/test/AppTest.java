package com.yedam.test;

import com.yedam.mapper.MemberMapper;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class AppTest {
	public static void main(String[] args) {
		
		MemberService svc = new MemberServiceImpl();
		MemberVO member = svc.login("hong1","hong1");
		System.out.println(member.toString());
	}
}
