<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
		String logId=(String) session.getAttribute("logId");
%>
	<!-- addForm.jsp -->
	<form action="addBoard.do" method="post">
		<table class="table">
			<tr>
				<th>글제목</th>
				<td><input class="form-control" type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=logId %>
				<input class="form-control" type="hidden" name="writer" value ="<%=logId %>" required>
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea class="form-control" name="content" rows="3" cols="40"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" class="">
				<input type="reset" class=""></td>
			</tr>
			
		</table>
	</form>
