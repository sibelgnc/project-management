<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="additionNote" id="noteform" action="${pageContext.request.contextPath}/projectManagement/datedeneme">
<form:input  type="date"  class="form-control input-md"  path="noteDate"/>
<button  class='btn btn-info btn-lg' type="submit"><span class='glyphicon glyphicon-plus'></span></button>
</form:form>
</body>
</html>