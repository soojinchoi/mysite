<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.bit2015.mysite.vo.MemberVo"%>
<%@ page import="com.bit2015.mysite.vo.BoardVo"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%
	MemberVo authUser = (MemberVo)session.getAttribute( "authUser" );
	String keyword = (String)request.getAttribute("kwd");
	List<BoardVo> list = (List<BoardVo>)request.getAttribute( "list" );
%> --%>
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
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>	
					<%-- <%
						int totalCount = list.size();
						int index = 0;
						for( BoardVo vo : list ) {
					%>	 --%>		
					<c:set var='count' value='${fn:length(list)}'></c:set>
					<c:forEach items='${list}' var="list" varStatus="status">
					<tr>
						<td>[${count-status.index}]</td>
						<td><a href="/mysite/board?a=contentview&no=${list.no}">${list.title}</a></td>
						<td>${list.memberName}</td>
						<td>${list.viewCnt}</td>
						<td>${list.regDate}</td>
						<td>
						<%-- <% 
							if( authUser != null && authUser.getNo() == vo.getMemberNo() ) {
						
						%> --%>	
						<c:choose>
						<c:when test="${(not empty authUser) && (authUser.no == list.memberNo)}">
							<a href="/mysite/board?a=delete&no=${list.no}" class="del">삭제</a>
						</c:when>
						<c:otherwise>
							&nbsp;
						</c:otherwise>
						</c:choose>	

						</td>
					</tr>
					</c:forEach>
				</table>
				<div class="bottom">
				<%-- <% 
					if( authUser != null ) {
				%> --%>
				<c:choose>
					<c:when test="${not empty authUser}">
						<a href="/mysite/board?a=writeform" id="new-book">글쓰기</a>
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