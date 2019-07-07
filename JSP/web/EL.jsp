<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--在指令中配置isELIgnored="true"表示忽略本页面的所有EL表达式--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
${3>4}<br>
\${3>4}:加反斜线表示忽略此EL表达式
<hr>
<%--算数运算符--%>
${3+4}<br>
${3-4}<br>
${3*4}<br>
${3/4}<br>
${3 div 4}<br>
${3%4}<br>
${3 mod 4}<br>
<%--比较运算符--%>
${3 == 4}<br>
<%--逻辑运算符--%>
${3 > 4 && 3 < 4}<br>
${3 > 4 || 3 < 4}<br>
<%--空运算符：empty
    功能：用于判断字符串，集合，数组对象是否为null，并且长度是否为零
    ${empty list}
--%>
<%
    request.setAttribute("str", "name");
%>
${empty str}<%--是否为空为null--%>
${not empty str}<%--是否不为空不为null--%>
</body>
</html>
