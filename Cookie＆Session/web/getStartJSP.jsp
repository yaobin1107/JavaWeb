<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

    <%--Java代码：在Service方法中--%>
    <%
        System.out.println("hello jsp");
        int i = 5;//局部变量

        String contextPath = request.getContextPath();
        out.print(contextPath);
    %>

    <%--java代码：在类的成员位置,定义的是成员变量或成员方法--%>
    <%!
        int i = 3;
    %>

    <%--输出代码块：将内容输出到页面--%>
    <%= "hello" %><%--out.print("hello")--%>
    <%= i %><%--输出i的值，就近原则--%>

    <h1>hi~ jsp!</h1>

    <%--Jsp内置对象--%>
    <% response.getWriter().write("response....."); %><%--response会先于out输出！--%>
</body>
</html>
