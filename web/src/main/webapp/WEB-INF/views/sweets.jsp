<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: judit
  Date: 2019. 11. 18.
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Sweets</title>
</head>
<body>

<c:if test="${!empty sweets}">

<h2>Sweets in the database</h2>

<table frame="border" width="250" rules="all">
    <c:forEach items="${sweets}" var="edesseg">
        <tr>
          <td> <a href="${pageContext.servletContext.contextPath}/auto/${edesseg.termekszam}">
                  ${edesseg.termekszam}</a>
           </td>
            <td>${edesseg.marka}</td>
            <td>${edesseg.ize}</td>
            <td>${edesseg.gyartas_eve}</td>
            <td>${edesseg.mennyiseg}</td>
            <td>${edesseg.lejarat_datuma}</td>
        </tr>

    </c:forEach>
</table>
</c:if>
<c:if test="${empty sweets}">
No cars in the database
</c:if>

<form action="${pageContext.servletContext.contextPath}/addEdesseg">
    <input type="submit" value="Add auto">
</form>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Home">
</form>
</body>
</html>
