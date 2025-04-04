<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	BoardVO board =(BoardVO) request.getAttribute("board");
	String paging = (String) request.getAttribute("page");
%>
<!-- /WEB-INF/views/deleteForm.jsp -->
	<form action="deleteBoard.do" method="post">
	<input type="hidden" value="<%=board.getBoardNo()%>" name="bno">
		<input type="hidden" name="page" value="<%=paging%>">
		<table class="table">
			<tr>
				<th>글제목</th>
				<td><input class="form-control" type="text" name="title" value="<%=board.getTitle()%>"></td>
				
			</tr>
			<tr>
				<th>작성자</th>
				<td><input class="form-control" type="text" name="writer" value="<%=board.getWriter()%>"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea class="form-control" name="content" rows="3" cols="40"><%=board.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button type="submit" class="btn btn-danger">삭제</button></td>
			</tr>
		</table>
	</form>
