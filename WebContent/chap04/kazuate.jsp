<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>	数当ゲーム</title>
</head>
<body>
<h3>数当てゲーム</h3>
<form action="kazuate" method="post">
正解は、0～99の数値になります。<br />
正解だと思う値を入力して下さい :<input type="text" name="num" /><br />
<input type="submit" name="guess" value="当てる!"/><br/>
<input type="submit" name="newgame" value="新しいゲームを始める"/><br/>
</form>

<br />

<c:if test="${ not empty message }">
${ message }
</c:if>
</body>
</html>