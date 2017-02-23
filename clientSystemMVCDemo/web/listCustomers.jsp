<%@ page import="com.wwwyb.domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/2/17
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>客户信息</title>
    <link type="text/css" href="css/main.css">
</head>
<body>
    <table width="88%">
        <tr>
            <td>
                <a href="addCustomer.jsp">添加</a>
                <a href="#">删除</a>
            </td>
        </tr>
        <tr>
            <td>
                <table border="1" width="100%">
                    <tr>
                        <th nowrap="nowrap">全选/全不选</th>
                        <th nowrap="nowrap">姓名</th>
                        <th owrap="nowrap">性别</th>
                        <th owrap="nowrap">类型</th>
                        <th nowrap="nowrap">操作</th>
                    </tr>

                    <c:forEach items="${cs}" var="c" varStatus="vs">
                        <tr>
                            <td nowrap="nowrap">
                                <input type="checkbox" name="ids" value="${c.id}">
                            </td>
                            <td nowrap="nowrap">${c.name}</td>
                            <td owrap="nowrap">${c.gender}</td>
                            <td owrap="nowrap">${c.type}</td>

                            <td nowrap="nowrap">
                                <a href="#">添加</a>
                                <a href="#">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>

</body>
</html>
