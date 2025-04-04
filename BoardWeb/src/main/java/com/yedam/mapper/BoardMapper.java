package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardMapper {
	//목록
	List<BoardVO> selectBoard(SearchDTO search);
	//emd
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	int deleteBoard(int board);
	//상세 조회
	BoardVO selectOne(int boardVO);
	//전체 건수.
	int selectTotal(SearchDTO search);
}
