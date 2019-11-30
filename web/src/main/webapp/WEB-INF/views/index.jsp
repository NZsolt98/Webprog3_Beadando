
<%@page isELIgnored = "false" %>
<html>
<body>
<h2>Üdvözlöm az édességnyilvántartó rendszerben!</h2>
<h1>${message}</h1>
<form action="${pageContext.servletContext.contextPath}/edessegek">
    <input type="submit" value="Edessegek">
</form>
<form action="${pageContext.servletContext.contextPath}/addEdesseg">
    <input type="submit" value="Add edesseg">
</form>
</body>
</html>
