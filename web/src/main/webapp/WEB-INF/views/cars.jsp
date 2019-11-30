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
    <title>Cars</title>
</head>
<body>

<c:if test="${!empty cars}">

<h2>Cars in the database</h2>

<table frame="border" width="250" rules="all">
    <c:forEach items="${cars}" var="auto">
        <tr>
          <td> <a href="${pageContext.servletContext.contextPath}/auto/${auto.rendszam}">
                  ${auto.rendszam}</a>
           </td>
            <td>${auto.marka}</td>
            <td>${auto.tipus}</td>
            <td>${auto.evjarat}</td>
        </tr>

    </c:forEach>
</table>
</c:if>
<c:if test="${empty cars}">
No cars in the database
</c:if>

<form action="${pageContext.servletContext.contextPath}/addKocsi">
    <input type="submit" value="Add auto">
</form>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Home">
</form>
</body>
</html>
