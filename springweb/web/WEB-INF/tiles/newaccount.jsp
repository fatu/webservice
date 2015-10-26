<%--
  Created by IntelliJ IDEA.
  User: boaztu
  Date: 10/7/15
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Create new account</h2>

<sf:form id="/>details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">

<table class="formtable">
    <tr>
        <td class="label">Name:</td>
        <td><sf:input class="control" path="username" name="name" type="text"/><br/>

            <div class="error"><sf:errors path="username"></sf:errors></div>
        </td>
    </tr>
    <tr>
        <td class="label">Email:</td>
        <td><sf:input class="control" path="email" name="email" type="text"/>
            <div class="error"><sf:errors path="email"></sf:errors></div>
        </td>
    </tr>
    <tr>
        <td class="label">Password:</td>
        <td><sf:input id="password" class="control" path="password" name="password" type="password"/>
            <div class="error"><sf:errors path="password"></sf:errors></div>
        </td>
    </tr>
    <tr>
        <td class="label">Confirm Password:</td>
        <td><input id="confirmpass" class="control" name="confirmpass" type="password"/>

            <div id="matchpass"></div>
        </td>
    </tr>
    <tr>
        <td class="label"></td>
        <td><input class="control" value="Create account" type="submit"/></td>
    </tr>
</table>

</sf:form>
