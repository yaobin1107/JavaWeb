<%@ page import="cn.yb.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Case</title>
</head>
<body>
<%
    List list = new ArrayList();
    User user1 = new User(1, "yb", "1234");
    User user2 = new User(2, "zs", "2367");
    User user3 = new User(3, "ls", "7809");
    list.add(user1);
    list.add(user2);
    list.add(user3);
    request.setAttribute("list", list);
%>
<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
