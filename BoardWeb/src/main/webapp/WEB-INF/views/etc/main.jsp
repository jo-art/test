<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<table class="table">
  <tr>
    <td>안녕하세요 ${!empty logId? userName:'guest'}!</td>
   <td> ${responsibility }</td>
    <td>권한은 ${!empty logId ? responsibility != null && responsibility=='User' ? '일반사용자' : '관리자' : '비회원'}</td>
  </tr>
</table>

