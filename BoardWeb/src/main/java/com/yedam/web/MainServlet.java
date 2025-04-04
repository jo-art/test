package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

/*
 * tomcat(WAS)의 규칙에 따라 작성.
 * 1. url 패턴(ex :http://localhost/BoardWeb/welcome)
 * 2. 서블릿 클래스(init() -> service() -> destroy()) 서블릿의 생성주기
 */

public class MainServlet extends HttpServlet {
	// 생성자
	public MainServlet() {
		System.out.println("MainServlet() 호출.");
	}

	// 서블릿 생명 주기 init
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		System.out.println("최초  호출 한번만 실행 init()메소드.");
	}

	// 서블릿 생명 주기 service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		//List<BoardVO> list = dao.boadList();
		SqlSessionFactory sqlSessionFactroy = DataSource.getInstance();
		try (SqlSession session = sqlSessionFactroy.openSession()) {
			List<BoardVO> list = session.selectList("com.yedam.mapper.BoardMapper.selectBoard");

			System.out.println(" 호출될때마다 실행 service()메소드.");
			PrintWriter out = resp.getWriter();
			String html = "<h2>게시글목록</h3>";
			html += "<table border='2'>";
			html += "<thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th></tr></thead>";
			html += "<tbody>";
			for (BoardVO board : list) {
			    html += "<tr>";
			    html += "<td>" + board.getBoardNo() + "</td>";  // 수정된 부분
			    html += "<td > <a href='getBoard?board_no="+board.getBoardNo()+"'>" + board.getTitle() + "</a></td>";    // 수정된 부분
			    html += "<td>" + board.getWriter() + "</td>";   // 수정된 부분
			    html += "<td>" + board.getWriteDate() + "</td>";// 수정된 부분
			    html += "</tr>";
			}
			html += "</tbody></table>";
			out.print(html);

		}//end of try

	}//end of service

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println(" 서버 종료시 실행 destroy()메소드.");

	}

}
