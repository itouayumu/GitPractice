<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List" %>
    <%@page import="java.util.ArrayList" %>
    <%@page import="dto.acount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>名前</th>
<th>年齢</th>
<th>性別</th>
<th>電話番号</th>
</tr>
<% 
List<acount> list = (ArrayList<acount>)request.getAttribute("list");
	for(acount s : list) {
	%>
		<tr>
			<td><%=s.getId() %></td>
			<td><%=s.getName() %></td>
			<td><%=s.getAge() %></td>
			<td><%=s.getGen() %></td>
			<td><%=s.getPhon() %></td>
			
		</tr>
	<%} %>
	</table>
	<a href="./"class="button">戻る</a>
</body>
</html>