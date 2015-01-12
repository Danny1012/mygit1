<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<P>
		<%
			out.println(Math.random() + "-->" + request.getParameter("HI"));
		%>
	</P>
	<P>
		<%
			out.println(request.getParameter("f"));
		%>
	</P>
	<p>用Maven创建web项目，测试Servlet</p>
	<a href="S1?action=login_input">登录(S1?action=login_input)</a>
</body>
</html>