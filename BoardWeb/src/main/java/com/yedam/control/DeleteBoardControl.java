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

public class DeleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// bno=15&title=바뀐값&content=바뀐값 수정 후 목록이동
		String bno = req.getParameter("bno");
		String page= req.getParameter("page");
		// 매개값
		
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int r = mapper.deleteBoard(Integer.parseInt(bno));
		if(r>0) {
			resp.sendRedirect("boardList.do?page="+page);
		}else {
			System.out.println("수정오류");
		}
	}

}
