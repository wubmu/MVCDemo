<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/2/14
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <jsp:forward page="/serverlet/Controller">
      <jsp:param name="op" value="showAllCustomers"></jsp:param>
    </jsp:forward>
  </body>
</html>
