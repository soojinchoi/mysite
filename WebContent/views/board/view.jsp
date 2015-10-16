<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.bit2015.mysite.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bit2015.mysite.vo.BoardVo"%>
<% 
	String newLine = "\n";
	pageContext.setAttribute("newLine", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/views/include/header.jsp"></c:import>
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${board.title}</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
							${fn:replace(board.content, newLine,'<br>')}
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="/mysite/board?a=board">글목록</a>
					<c:choose>
						<c:when test="${(not empty authUser) && (authUser.no == board.memberNo)}">
						<a href="/mysite/board?a=modifyform&no=${board.no}">글수정</a>
						</c:when>
						<c:otherwise>
							&nbsp;
						</c:otherwise>
					</c:choose>					
				</div>
			</div>
		</div>
		<c:import url="/views/include/navigation.jsp"></c:import>
		<c:import url="/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>