<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/2/18
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>添加客户信息</title>
    <link type="text/css" href="css/main.css">
</head>
<body>
    <center>
    <form action="/serverlet/Controller?op=addCustomer" method="post" >
        <table border="1">
            <tr>
                <td nowrap="nowrap">姓名</td>
                <td nowrap="nowrap">
                    <input type="text" name="name"/>
                </td>
            </tr>
            <tr>
                <td nowrap="nowrap">性别</td>
                <td nowrap="nowrap">
                    <input type="radio" name="gender" value="male" checked>男<br>
                    <input type="radio" name="gender" value="female">女<br>
                </td>
            </tr>
            <tr>
                <td nowrap="nowrap">生日</td>
                <td nowrap="nowrap">
                    <input type="text" name="birthday">
                </td>
            </tr>
            <tr>
                <td nowrap="nowrap">电话</td>
                <td nowrap="nowrap">
                    <input type="text" name="cellphone">
                </td>
            </tr>
            <tr>
                <td nowrap="nowrap">邮箱</td>
                <td nowrap="nowrap">
                    <input type="text" name="email">
                </td>
            </tr>
            <tr>
                <td nowrap="nowrap">爱好</td>
                <td nowrap="nowrap">
                    <input type="checkbox" name="hobbies" value="吃饭" >吃饭
                    <input type="checkbox" name="hobbies" value="睡觉">睡觉
                    <input type="checkbox" name="hobbies" value="学JAVA"}>学JAVA
                </td>
            </tr>
            <tr>
                <td nowrap="nowrap">描述</td>
                <td nowrap="nowrap">
                    <textarea rows="3" cols="38" name="description"></textarea>
                </td>
            </tr>
            <tr>
                <td nowrap="norap"colspan="2">
                    <input type="submit" value="保存">
                </td>
            </tr>
        </table>
    </form>
    </center>
</body>
</html>
