<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Zadanie 2</title>
</head>
<body>
    <p>
        <c:forEach begin="2" end="10" step="2" var="i">
            ${i}<br />
        </c:forEach>
    </p>
</body>
</html>
