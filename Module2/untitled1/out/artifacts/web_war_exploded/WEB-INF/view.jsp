<%--
  Created by IntelliJ IDEA.
  User: Pham Huy Duc
  Date: 22/07/2019
  Time: 4:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: lekhachanh
  Date: 18/07/2019
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>product details</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name:</td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${requestScope["product"].getEmail()}</td>
    </tr>

</table>
</body>
</html>
