<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	1.	Hello : ${loginForm.name} <br>
	2. 	Your Id: ${loginForm.id} <br>
	3.  Image shown if present <br> 
	<logic:present name="base64code">
		Your image goes here -
		<img width='50' height='80' src='data:image/png;base64, <%= request.getAttribute("base64code") %>'>
	</logic:present>
	<br>
</body>
</html>