<%--
  Created by IntelliJ IDEA.
  User: boaztu
  Date: 10/7/15
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title></title>
</head>

<c:forEach var="offer" items="${offers}">
  <p><c:out value="${offer}"></c:out></p>
</c:forEach>


</body>
</html>
