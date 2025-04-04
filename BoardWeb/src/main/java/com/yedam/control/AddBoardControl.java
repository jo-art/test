package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control{

	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청 재지정
		req.setCharacterEncoding("utf-8");
		if(req.getMethod().equals("GET")) {
			req.getRequestDispatcher("board/addForm.tiles").forward(req, resp);

		}else if(req.getMethod().equals("POST")) {
			//등록
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content =req.getParameter("content");
			
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			//mybatis 활용해서 jdbc 처리,,이렇게 하면 별루임... 
			SqlSession sqlSession = DataSource.getInstance().openSession(true);
			BoardMapper mapper =sqlSession.getMapper(BoardMapper.class);
			int r = mapper.insertBoard(board);
			if(r>0) {
				resp.sendRedirect("boardList.do");//요청 재지정

			}else {
				System.out.println("실패");
			}
			//전달할 파라미터가 없는 경우 센드 리 다이렉트 메소드 
			
		}

	}
}
