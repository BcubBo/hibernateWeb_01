<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>起始页面</title>
</head>
<body>
This is the start page!!!!!
<div>
	<a href="CtrlServlet?id=20">select dept 20 </a>
	<br/>
	<c:if test="${not empty requestScope.result }">
	<c:out value="${requestScope.result.deptName }"/><br/>
	<hr/>
	<c:forEach items="${requestScope.result.emps }" var="emp">
	
		${emp.empName }<br/>
	
	
	</c:forEach>
</c:if>
</div>
</body>
</html>