<%--
  Created by IntelliJ IDEA.
  User: boaztu
  Date: 10/26/15
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
  <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery.js"></script>

  <tiles:insertAttribute name="includes"></tiles:insertAttribute>

</head>
<body>

<div class="header">
  <tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>
<div class="content">
  <tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>

<hr/>
<div class="footer">
  <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>


</body>
</html>
