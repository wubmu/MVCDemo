<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/2/6
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/Servlet/LoginServlet" method="post">
        用户名:<input type="text" name="username"/><br/>
        密 码:<input type="password" name="password"/><br/>
        <input type="submit" value="登陆"/>
    </form>

</body>
</html>
