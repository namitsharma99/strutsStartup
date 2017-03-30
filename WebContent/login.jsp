<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<html:form action="loginAction" focus="id"><%--  enctype="multipart/form-data"> --%>
		ID: <html:text property="id"></html:text>
		Name: <html:text property="name"></html:text>
		<%-- Upload File: <html:file property="myFile"></html:file>
		Upload Image: <html:img/> --%>
		<html:submit value="Submit"></html:submit>
	</html:form>
</body>
</html>