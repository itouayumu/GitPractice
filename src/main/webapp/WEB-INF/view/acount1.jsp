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
<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			acount ac = (acount)session.getAttribute("input_data");
	%>
		
		<h3>新規会員登録</h3>
		<form action="acount12" method="post">
			名前：<input type="text" name="name" value="<%=ac.getName()%>"><br>
			年齢：<input type="text" name="age" value="<%=ac.getAge()%>"><br>
			性別：<br>男：<input type="radio" name="gen" value="男"><br>
			女：<input type="radio" name="gen" value="女"><br>
			電話番号：<input type="text" name="phon" value="<%=ac.getPhon()%>"><br>
			メール：<input type="text" name="mail" value="<%=ac.getMail()%>"><br>
			パスワード：<input type="password" name="pw"><br>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
	<h3>新規会員登録</h3>
	<form action="acount12" method="post">
		名前：<input type="text" name="name" ><br>
			年齢：<input type="text" name="age" ><br>
			性別：<br>男：<input type="radio" name="gen" value="男"><br>
			女：<input type="radio" name="gen" value="女"><br>
			電話番号：<input type="text" name="phon" ><br>
			メール：<input type="text" name="mail"><br>
			パスワード：<input type="password" name="pw"><br>
			<input type="submit" value="登録">
	</form>
	<%
		}
	%>
</body>
</html>