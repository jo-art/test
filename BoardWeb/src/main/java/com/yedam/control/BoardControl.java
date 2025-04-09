package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1. parameter : bno=9
		String boardNo= req.getParameter("bno");
		String page=req.getParameter("page");
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper= sqlSession.getMapper(BoardMapper.class);
		BoardVO board = mapper.selectOne(Integer.parseInt(boardNo)); // 단일 객체로 받아야 함
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		// board.jsp로 전달 //페이지 재지정
		req.getRequestDispatcher("board/board2.tiles").forward(req, resp);
		
	}
	
}

