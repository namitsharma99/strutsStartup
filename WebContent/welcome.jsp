<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<script></script>
</head>
<body>
<form name="myForm" method="post" id="myForm" onsubmit="return takeAction()" >
<h1>Hello World !! </h1>
<p><html:link page="/login.jsp">Click here to login</html:link></p> 
</form>
</body>
</html>