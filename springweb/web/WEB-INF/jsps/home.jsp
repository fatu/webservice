<%--
  Created by IntelliJ IDEA.
  User: fatu
  Date: 10/7/15
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title></title>
</head>

<p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p>

<p><a href="${pageContext.request.contextPath}/createoffer">Add a new offer.</a></p>

<sec:authorize access="!isAuthenticated()">
    <p><a href="<c:url value='/login'/>">Login</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p><a href="<c:url value='/j_spring_security_logout'/>">Log out</a></p>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p><a href="<c:url value='/admin'/>">Admin</a></p>
</sec:authorize>


</body>
</html>
