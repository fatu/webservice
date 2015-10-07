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

<html>
  <head>
    <title></title>
  </head>
  <body>
  Hi There!

  <sql:query var="rs" dataSource="jdbc/spring">
      select id, name, email, text from offers
  </sql:query>


  <c:forEach var="row" items="${rs.rows}">
      ID: ${row.id}<br/>
      Name: ${row.name}<br/>
      Email: ${row.email}<br/>
      Text: ${row.text}<br/>
  </c:forEach>


  </body>
</html>
