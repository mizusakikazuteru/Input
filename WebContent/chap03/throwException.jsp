<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%><%--exception使用時 isErrorPage="true"にする必要がある --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>例外サンプル</title>
</head>
<body>
	<h3>例外を発生させる</h3>
	<p>例外発生!!!!!!!</p>
	<%
		response.setStatus(HttpServletResponse.SC_OK);

		exception.printStackTrace();

		out.print(exception.toString());
		out.print("<br />");

		out.print("exception instanceof NullPointerException : ");
		out.print(exception instanceof NullPointerException);
		out.print("<br />");
	%>


</body>
</html>