<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.acount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>下記の内容で登録します。よろしいですか？</p>
	<%
		acount account = (acount)session.getAttribute("input_data");
	%>
	名前：<%=account.getName() %><br>
	名前：<%=account.getAge() %><br>
	名前：<%=account.getGen() %><br>
	名前：<%=account.getPhon() %><br>
	メール：<%=account.getMail() %><br>
	パスワード：********<br>
	<a href="acount13">OK</a><br>
	<a href="acount1">戻る</a>
</body>
</html>