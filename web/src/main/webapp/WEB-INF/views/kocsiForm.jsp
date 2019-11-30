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
    <title>Kocsi hozzaadasa</title>
</head>
<body>

${message}
<h2>Kocsi adatai:</h2>
<form:form method="post" action="addKocsi">
    <form:label path="rendszam">Rendszam</form:label>
    <form:input path="rendszam"/>
    <br>
    <form:label path="marka">Márka</form:label>
    <form:input path="marka"/>
    <br>
    <form:label path="tipus">Tipus</form:label>
    <form:input path="tipus"/>
    <br>
    <form:label path="ajtok_szama">Ajtók Száma</form:label>
    <form:input path="ajtok_szama" />
    <br>
    <form:label path="evjarat">Évjárat</form:label>
    <form:input path="evjarat"/>
    <br>
    <form:label path="hengerurtartalom">Hengerűrtartalom</form:label>
    <form:input path="hengerurtartalom"/>
    <br>
    <form:label path="muszaki_ervenyesseg">Műszaki érvényesség</form:label>
    <form:input type="date" path="muszaki_ervenyesseg"/>
    <br>
    <form:label path="szin_hexakod">Szín hexa kódban megadva</form:label>
    <form:input path="szin_hexakod"/>
    <br>
    <form:label path="teljesitmeny">Teljesítmény</form:label>
    <form:input path="teljesitmeny"/>
    <br>
    <form:label path="kivitel">Kivitel</form:label>
    <form:select path="kivitel">
        <form:options items="${kivitelTipusok}"/>
    </form:select>
    <br>
    <form:label path="allapot">Állapot</form:label>
    <form:select path="allapot" multiple="true">
        <form:options items="${allapotTipusok}"/>
    </form:select>
    <input type="submit" value="Küldés">
</form:form>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Mégse">
</form>

</body>
</html>
