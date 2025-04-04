package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1.회원가입 하면.WEB-INF/views/signForm.jsp
		if (req.getMethod().equals("GET")) { // 요청방식이 겟방식이면 사인폼
			req.getRequestDispatcher("member/signForm.tiles").forward(req, resp);
		} else {
			// 2. 회원가입 처리.(파일 업로드:images.db등록)
			// 1) 요청정보 2)경로 3)최대크기 4)인코딩
			// 5)리네임 정책: 동일한 이름의 파일이 있다해서 기존을 삭제하는 상황이 생기면 안되게때문에 기존 이름을 바꾸는 정책
			String saveDir = req.getServletContext().getRealPath("images"); // 이미지경로
			int maxSize = 1024 * 1024 * 5;// 파일의 최대크기
			String enc = "UTF-8";// 인코딩방식
			MultipartRequest mr = new MultipartRequest(req, saveDir, maxSize, enc, new DefaultFileRenamePolicy());
			// 파라미터 & 값.
			String uid = mr.getParameter("userId");
			String upw = mr.getParameter("userPw");
			String unm = mr.getParameter("userName");
			String img = mr.getFilesystemName("userImg");

			MemberVO mvo = new MemberVO();
			mvo.setMemid(uid);
			mvo.setMemname(unm);
			mvo.setMempw(upw);
			mvo.setImages(img);
			// 업무처리
			MemberService svc = new MemberServiceImpl();
			if (svc.addMember(mvo)) {
				resp.sendRedirect("loginForm.do"); // 회원가입 시 로그인 화면으로 이동
			} else {
				System.out.println("처리오류");
			}

		}

	}

}
