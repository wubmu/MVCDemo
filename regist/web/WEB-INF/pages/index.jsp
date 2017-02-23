<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/2/6
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
<head>
    <title>网站登录</title>
</head>
<body>
    <c:if test="${sessionScope.user==null}">
        <a href="${pageContext.request.contextPath}LoginUIServlet">登陆</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}RegistUIServlet">注册</a>
    </c:if>
    <c:if test="${sessionScope.user!=null}">
        欢迎你：${sessionScope.user.username}&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}LogoutServlet">注销</a>
    </c:if>

</body>
</html>