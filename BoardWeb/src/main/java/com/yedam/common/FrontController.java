package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.DeleteFormControl;
import com.yedam.control.JSControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.MainControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.RLDatatable;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyCountControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.SignUpControl;
import com.yedam.control.loginControl;
import com.yedam.control.logoutControl;
import com.yedam.control.ModifyBoardControl; // 클래스 이름 변경 (오타 수정)

//*.do 실행
public class FrontController extends HttpServlet{
	//요청 url <=> 실행 컨트롤
	Map<String,Control> map;
	
	//생성자.
	public FrontController() {
		map = new HashMap<String,Control>();
	}
	//intit
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/board.do", new BoardControl());
		map.put("/boardList.do", new BoardListControl());//목록
		//글등록
		map.put("/addBoard.do", new AddBoardControl());//글등록
		map.put("/modifyForm.do", new ModifyFormControl());//수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl());//수정처리 (오타 수정 및 통일)
		map.put("/deleteForm.do", new DeleteFormControl()); //삭제화면
		map.put("/deleteBoard.do", new DeleteBoardControl());// 삭제처리
		map.put("/loginForm.do", new LoginFormControl()); //로그인화면
		map.put("/login.do", new loginControl()); // 로그인처리
		map.put("/logout.do", new logoutControl()); //로그아웃
		//회원가입
		map.put("/signForm.do", new SignUpControl()); //회원가입 화면
		map.put("/signUp.do", new SignUpControl()); //회원가입 처리
		map.put("/javascript.do", new JSControl());//js 연습
		//댓글관련
		map.put("/replyList.do", new ReplyListControl()); //댓글 데이터
		map.put("/removeReply.do", new RemoveReplyControl()); //삭제
		map.put("/addReply.do", new AddReplyControl()); // 추가.
		map.put("/replyCount.do", new ReplyCountControl()); //댓글수
		//연습용
		map.put("/replyListDatatable.do", new RLDatatable());//댓글목록
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//url vs uri
		//http:// localhost:8080/BoardWeb/board.do
		String uri =req.getRequestURI();
		System.out.println("요청 uri: "+uri);// /BoardWeb/board.do
		String context = req.getContextPath();
		String page= uri.substring(context.length()); //   /board.do
		System.out.println(page);
		Control sub =map.get(page); //키(url)=> control 반환.
		sub.exec(req,resp);
	}
	
}

