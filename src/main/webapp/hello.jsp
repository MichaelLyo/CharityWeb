<%--
  Created by IntelliJ IDEA.
  User: lsl
  Date: 2017/10/6
  Time: 下午4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <title>hello MVC</title>
    </head>
    <body>
    <h2>${message}</h2>
    <p>directly: ${requestScope.message}</p>
    <p>indirectly: ${requestScope.get("message")}</p>
    </body>
</html>
