<%--
  Created by IntelliJ IDEA.
  User: judit
  Date: 2019. 11. 04.
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form"
          uri ="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edesseg hozzadasa</title>
</head>
<body>

${message}
<h2>Edesseg adatai:</h2>
<form:form method="post" action="addEdesseg">
    <form:label path="termekszam">Termékszám</form:label>
    <form:input path="termekszam"/>
    <br>
    <form:label path="marka">Márka</form:label>
    <form:input path="marka"/>
    <br>
    <form:label path="ize">Íze</form:label>
    <form:input path="ize"/>
    <br>
    <form:label path="mennyiseg">Mennyiség</form:label>
    <form:input path="mennyiseg" />
    <br>
    <form:label path="gyartas_eve">Gyártás éve</form:label>
    <form:input path="gyartas_eve"/>
    <br>
    <form:label path="lejarat_datuma">Lejárat dátuma</form:label>
    <form:input type="date" path="lejarat_datuma"/>
    <br>
    <form:label path="kivitel">Mennyiség típus szerint</form:label>
    <form:select path="kivitel">
        <form:options items="${mennyisegTipusok}"/>
    </form:select>
    <br>
    <form:label path="tipus">Tipus</form:label>
    <form:select path="tipus" multiple="false">
        <form:options items="${tipusTipusok}"/>
    </form:select>
    <input type="submit" value="Küldés">
</form:form>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Mégse">
</form>

</body>
</html>
