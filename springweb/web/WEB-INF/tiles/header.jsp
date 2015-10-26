<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<a class="title" href="<c:url value='/'/>">Offers</a>

<sec:authorize access="!isAuthenticated()">
    <a class="login" href="<c:url value='/login'/>">Login</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <a class="login" href="<c:url value='/j_spring_security_logout'/>">Log out</a>
</sec:authorize>