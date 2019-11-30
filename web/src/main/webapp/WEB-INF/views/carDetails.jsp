<%--
  Created by IntelliJ IDEA.
  User: judit
  Date: 2019. 11. 18.
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>

<html>
<head>
    <title>${auto.rendszam} car details</title>
</head>
<body>
<table>
    <tr>
        <td>Rendszam</td>
        <td>${auto.rendszam}</td>
    </tr>
    <tr>
        <td>Márka</td>
        <td>${auto.marka}</td>
    </tr>
    <tr>
        <td>Típus</td>
        <td>${auto.tipus}</td>
    </tr>
    <tr>
        <td>Kivitel</td>
        <td>${auto.kivitel}</td>
    </tr>
</table>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Home">
</form>

</body>
</html>
