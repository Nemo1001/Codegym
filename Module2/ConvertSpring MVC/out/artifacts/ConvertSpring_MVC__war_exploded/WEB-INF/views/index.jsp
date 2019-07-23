<%--
  Created by IntelliJ IDEA.
  User: Pham Huy Duc
  Date: 23/07/2019
  Time: 10:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Convert</title>
  </head>
  <body>

  <form method="get" action="/convert">
  <label>Rate:</label>
  <input type="text" name="rate" placeholder="RATE" value="22000"><br>
  <label>USD:</label>
  <input type="text" name="usd" placeholder="USD" value="0"><br>
  <input type="submit" name="submit" id="submit" value="Converter">

  </form>
  </body>
</html>
