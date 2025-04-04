package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class GetBoardServ
 */
@WebServlet("/getBoard")
public class GetBoardServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 //http://localhost/BoarWeb/getBoard? board_no=13
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		String boardNo=req.getParameter("board_no");
		
		
		//maybatis 활용 jdbc 처리.
				SqlSession sqlSession = DataSource.getInstance().openSession(true);
				BoardMapper mapper =sqlSession.getMapper(BoardMapper.class);
				BoardVO board = mapper.selectOne(Integer.parseInt(boardNo));
				PrintWriter out= resp.getWriter();
				String html="<h3>상세조회</h3>";
				
				html += "글번호 : "+board.getBoardNo()+"글제목: "+board.getTitle()+"글쓴이:" +board.getWriter();
				html +="<p><a href='MainServlet'>목록으로 </a></p>";
				
				out.print(html);
	}

}
