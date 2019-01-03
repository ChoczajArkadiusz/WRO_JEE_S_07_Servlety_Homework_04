<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <title>Zadanie 10</title>
</head>
<body>
    <h4>  Zadanie 10  </h4><br>
    <%@include file="header.jsp" %>
    <p>
        Witaj na stronie 4
    </p>
    <br>
    <h4> Historia odwiedzonych stron: </h4>
    <c:forEach items="${history}" var="pageNumber">
        ${pageNumber} <br>
    </c:forEach>
    <br>
    <form action="/history" method="post">
        <input type="submit" value="Wyczyść historię">
    </form>
    <br>
    <%@include file="footer.jsp" %>
</body>
</html>
