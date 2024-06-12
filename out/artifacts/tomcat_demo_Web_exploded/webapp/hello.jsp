<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/6/12
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello jsp</h1>
<%--内容直接放到_jspService()中--%>
<%
    System.out.println("Hello Jsp");
    int i = 3;
%>
<%--内容放到out.print()中--%>
<%=i%>
<%--内容放到_jspService()之外，被类直接包含--%>
<%!%>
</body>
</html>
