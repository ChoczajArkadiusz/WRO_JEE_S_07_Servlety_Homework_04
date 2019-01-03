<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 02.01.19
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zadanie 8</title>
</head>
<body>
    <c:if test="${showNewsletterForm > 0 }">
        <h4>Zapisz się na newsletter</h4>
        <form method='post' action='/newsletter'>
            <fieldset>
                <legend>Dane do newslettera:</legend>
                <label>Adres email: <input type="text" name="email" placeholder="Podaj adres email" /></label><br>
                <label>Imie i Nazwisko: <input type="text" name="name" placeholder="Podaj imię i nazwisko" /></label><br>
                <br>
                <br>
                <input type='submit' name='submitAccept' value='Zapisz mnie'/>
                <input type='submit' name='submitReject' value='Nie chcę newslettera'/>
                <br>
            </fieldset>
        </form>
    </c:if>
    <h4>Newsletter</h4>
    &emsp;Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pharetra, nisi vitae aliquet pellentesque, purus justo convallis magna, et condimentum nibh sem a diam. Vivamus convallis nisl in velit lacinia, non mattis nibh accumsan. Suspendisse dignissim eros dignissim tortor finibus, sit amet condimentum lectus blandit. Quisque quis lorem id turpis facilisis volutpat. Maecenas placerat velit rutrum dignissim porta. In varius sollicitudin turpis, et elementum enim semper et. Cras et nibh eget neque ultricies congue sed ac justo. Nullam semper molestie dui, in feugiat mi. Sed nisi mi, ultricies et nibh sed, interdum elementum nunc. Maecenas ligula massa, molestie sed ligula a, facilisis commodo felis. Vestibulum dictum et neque ac rutrum. Nulla lectus mi, dignissim eget pulvinar a, mattis aliquam nisi. Proin et ultrices ligula. Cras eu porta eros. Nullam elit ligula, bibendum in orci ac, facilisis ultricies quam.
    <br><br>
    &emsp; Nulla feugiat dapibus ipsum vitae tincidunt. Cras nec sagittis nisl. Mauris vel purus lorem. In felis mi, tincidunt non ornare sit amet, dictum vitae nulla. Ut sed eros pulvinar, egestas purus et, auctor dolor. Nunc eu pharetra metus. Mauris lectus justo, rutrum a dui quis, porttitor malesuada metus. Ut vulputate semper tortor rutrum gravida. Phasellus aliquet ante ante, suscipit efficitur sem commodo congue.
    <br><br>
    &emsp; Ut eget magna arcu. Curabitur tincidunt augue at ipsum bibendum placerat. Curabitur aliquet, justo non lobortis molestie, enim sapien porta sapien, vel dapibus quam nibh at dui. Duis sed sodales augue. Etiam nec vehicula magna. Quisque lorem velit, faucibus sit amet nulla sed, convallis sagittis orci. Quisque consectetur dolor eget convallis egestas.
    <br><br>
    &emsp; Mauris in elit ullamcorper, fermentum mauris eu, pulvinar eros. Nunc sodales, est quis imperdiet euismod, sapien tellus molestie dolor, luctus eleifend purus velit sit amet ex. Quisque interdum nulla neque, ac fermentum arcu volutpat vitae. Donec id condimentum dui, non molestie arcu. Vestibulum blandit tempor pharetra. Integer velit ipsum, rutrum ut turpis nec, eleifend pharetra libero. Curabitur est ipsum, aliquet ac accumsan et, tincidunt sit amet mauris. Nunc aliquet velit eget nunc fermentum, sed sodales massa porttitor. Pellentesque non ligula lectus. Nam ornare, quam in pretium vulputate, lacus urna fringilla lectus, sed tempus nisi nulla ac urna. Proin hendrerit lacus massa, eu faucibus ex consectetur sit amet. Sed hendrerit odio et quam pulvinar dignissim. Morbi eget sapien et augue dapibus fringilla.
    <br><br>
    &emsp; Vestibulum cursus magna in nisl mollis fringilla. Nam consequat metus turpis, accumsan porta lacus posuere id. Vestibulum bibendum nunc et interdum condimentum. Vivamus varius, enim ut interdum venenatis, velit elit pellentesque ante, et finibus nibh lacus id quam. Quisque porta vel nisi non rutrum. Sed rhoncus luctus massa ac tincidunt. Suspendisse sed condimentum ante. Nulla dapibus viverra gravida.
    <br><br>
</body>
</html>
