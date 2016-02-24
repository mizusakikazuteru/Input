<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContextサンプル</title>
</head>
<body>
<h3>pageContextサンプル</h3>

<%
	String val ="Hello, pageContext!";
	pageContext.setAttribute("val",val);

	JspWriter jspWriter = pageContext.getOut();
	jspWriter.println(pageContext.getAttribute("val"));

%>


</body>
</html>