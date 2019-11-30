
<%@page isELIgnored = "false" %>
<html>
<body>
<h2>Hello World!</h2>
<h1>${message}</h1>
<form action="${pageContext.servletContext.contextPath}/autok">
    <input type="submit" value="Autok">
</form>
<form action="${pageContext.servletContext.contextPath}/addKocsi">
    <input type="submit" value="Add auto">
</form>
</body>
</html>
