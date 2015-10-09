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
  <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
  <title></title>
</head>
<table class="offers">
  <tr><td>Name</td><td>Email</td><td>OFfer</td></tr>
  <c:forEach var="offer" items="${offers}">
    <tr>
      <td><c:out value="${offer.name}"></c:out></td>

      <td><c:out value="${offer.email}"></c:out></td>

      <td><c:out value="${offer.text}"></c:out></td>

    </tr>
  </c:forEach>
</table>



</body>
</html>
