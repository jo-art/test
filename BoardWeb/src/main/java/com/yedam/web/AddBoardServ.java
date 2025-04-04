package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

@WebServlet("/addBoard")
public class AddBoardServ extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content =req.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		//maybatis 활용 jdbc 처리.
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper =sqlSession.getMapper(BoardMapper.class);
		int r = mapper.insertBoard(board);
		resp.getWriter().print(r+"건 처리");		
		//addForm.jsp -> 3개 값(title,writer,content)
		//?title=dfsdf(첫번째 파라미터)&wirter=sdfsdf&content=sdfsdf
	}//end of service.
	
}//end of class.
