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
    <title>Zadanie 3</title>
</head>
<body>
    <p>
        <c:set var="someName" value="Witaj w coderslab."/>
            <c:if test = "${fn:contains(someName, 'coderslab')}">
                <p>OK</p>
            </c:if>
    </p>
</body>
</html>
