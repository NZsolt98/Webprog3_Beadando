
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>

<html>
<head>
    <title>${edesseg.termekszam} sweet details</title>
</head>
<body>
<table>
    <tr>
        <td>Termekszam</td>
        <td>${edesseg.termekszam}</td>
    </tr>
    <tr>
        <td>Márka</td>
        <td>${edesseg.marka}</td>
    </tr>
    <tr>
        <td>Íze</td>
        <td>${edesseg.ize}</td>
    </tr>
    <tr>
        <td>Gyartas eve</td>
        <td>${edesseg.gyartas_eve}</td>
    </tr>
    <tr>
        <td>Mennyiseg</td>
        <td>${edesseg.mennyiseg}</td>
    </tr>
    <tr>
        <td>Lejarat datuma</td>
        <td>${edesseg.lejarat_datuma}</td>
    </tr>
</table>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Home">
</form>

</body>
</html>
