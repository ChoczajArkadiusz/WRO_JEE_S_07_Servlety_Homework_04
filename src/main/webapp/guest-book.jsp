<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 03.01.19
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zadanie 9</title>
</head>
<body>
    <h4>Wpisz się do księgi gości!</h4>
    <form method='post' action='/guest-book'>
        <fieldset>
            <legend>Twój wpis:</legend>
            <label>nazwa Użytkownika: <input type="text" name="name" placeholder="Podaj swoją nazwę" /></label><br>
            <label>Treść wpisu: <input type="text" name="message" placeholder="Podaj treść wpisu" size="90%"/></label><br>
            <br>
            <input type='submit' name='submitAccept' value='Wpisz mnie'/>
            <br>
        </fieldset>
    </form>
    <br><br>
    <h4>Lista wpisów w księdze gości:</h4>
    <c:if test="${not empty entries}">
        <table border="1" cellpadding="5">
            <tr>
                <th> Data i czas wpisu </th>
                <th> Nazwa Użytkownika </th>
                <th> Treść wpisu </th>
            </tr>
            <c:forEach items="${entries}" var="entry">
                <tr>
                    <td>${entry.timestamp}</td>
                    <td>${entry.name}</td>
                    <td>${entry.message}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty entries}">
        brak wpisów
    </c:if>
    <br><br>
</body>
</html>
