<%--
  Created by IntelliJ IDEA.
  User: boaztu
  Date: 10/7/15
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />

<meta http-equiv="content-type" content="text/html; charset=US-ASCII">
    <title>Insert title here</title>
</head>
<body>


<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">

    <table class="formtable">
        <tr>
            <td class="label">Name: </td><td><sf:input class="control" path="name" name="name" type="text" /><br/><sf:errors path="name" cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">Email: </td><td><sf:input class="control" path="email" name="email" type="text" /><br/><sf:errors path="email" cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label">Your offer: </td><td><sf:textarea class="control" path="text" name="text" rows="10" cols="10"></sf:textarea><br/><sf:errors path="text" cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td class="label"> </td><td><input class="control" name="Create advert" type="submit" /></td>
        </tr>
    </table>

</sf:form>


</body>
</html>
