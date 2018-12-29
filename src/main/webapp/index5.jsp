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
    <title>Zadanie 5</title>
</head>
<body>
    <h4>  ***  Airports  ***  </h4><br>
    <p>
   <form method='post' action='/Servlet_02'>
        <label> Wybierz lotnisko wylotu:
            <select name='departure'>
                <c:forEach items="${airports}" var="airport">
                    <option value="${airport.name}">${airport.name}</option>
                </c:forEach>
            </select>
        </label>
        <label>  Czas startu:
            <input type="datetime-local" name="departureTime">
        </label>
        <br>
        <label> Wybierz lotnisko przylotu:
            <select name='arrival'>
                <c:forEach items="${airports}" var="airport">
                    <option value="${airport.name}">${airport.name}</option>
                </c:forEach>
            </select>
        </label>
        <label>Długość lotu [h]: <input type="number" min="0" step="1"  name="duration" placeholder="Podaj czas przelotu" /></label><br>
        <label>Cena: <input type="number" min="0.00" step="0.01"  name="price" placeholder="Podaj cenę" /></label><br>
        <br>
        <br>
       <input type='submit' name='userSubmit' value='Zatwierdź'/>
    </form>
    <br />
    </p>
</body>
</html>
