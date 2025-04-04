package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class loginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//파라미터 uname, psw 
		String id= req.getParameter("uname");
		String pw= req.getParameter("psw");
		
		//servicelogic 서비스 객체 처리
		MemberService svc = new MemberServiceImpl();
		MemberVO  mvo = svc.login(id, pw);
		
		if(mvo == null) {
			req.setAttribute("msg", "아이디와 비밀번호를 확인하세요!");
			req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
		}else {
			//로그인 성공=> 세션 객체. 로그인 정보 저장.
			HttpSession session = req.getSession();
			session.setAttribute("logId", id); //세션 객체의 attr에 저장
			session.setAttribute("userName", mvo.getMemname());
			session.setAttribute("responsibility", mvo.getResponsibility());
			session.setAttribute("img", mvo.getImages());
			if(mvo.getResponsibility().equals("User")) {
				//resp.sendRedirect("common/main.tiles");
				req.getRequestDispatcher("board/main.tiles").forward(req, resp);
			}else if(mvo.getResponsibility().equals("Admin")) {
				req.getRequestDispatcher("manager/main.tiles").forward(req, resp);
			}
			
		}
		//uname, psw --> db에 있는 지 확인 후 있으면 boardList 페이지로 이동
		//없으면 다시 로그인페이지에 머물러있는 기능
		
	}

}
