<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 20.12.18
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zadanie 1</title>
</head>
<body>
    <p>Wybrany autor: ${empty param.author ? "----" : param.author}</p>
</body>
</html>
