<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/2/6
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新用户注册</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/Servlet/RegistServlet" method="post">
      <table  border="1" width="438">
          <tr>
              <td>用户名:</td>
              <td>
                  <input type="text" name="username" value="${formBean.username}">
              </td>
              <td>${forBean.errors.username}</td>
          </tr>
          <tr>
              <td>密码</td>
              <td>
                  <input type="text" name="password" value="${formBean.password}">
              </td>
              <td>${forBean.errors.password}</td>
          </tr>
          <tr>
              <td>重复密码：</td>
              <td>
                  <input type="text" name="repassword" value="${forBean.repassword}">
              </td>
              <td>${forBean.errors.repassword}</td>
          </tr>
          <tr>
              <td>邮箱:</td>
              <td>
                  <input type="text" name="email" value="${forBean.email}">
              </td>
              <td>${forBean.errors.email}</td>
          </tr>
          <tr>
              <td>
                  <input type="submit"  value="注册">
              </td>
              <td></td>
          </tr>
      </table>

  </form>
</body>
</html>
