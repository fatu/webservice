<%--
  Created by IntelliJ IDEA.
  User: fatu
  Date: 10/14/15
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <%
      String data="hello world";
      boolean flag=true;
      if (flag==true) {
        out.println("<h1>" +data.toUpperCase()+ "</h1>");
      }
    %>

  </body>
</html>
