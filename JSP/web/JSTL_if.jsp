<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签</title>
</head>
<body>
<%--常用的JSTL标签
	1. if:相当于java代码的if语句
		1. 属性：
            * test 必须属性，接受boolean表达式
                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
                * 一般情况下，test属性值会结合el表达式一起使用
   		 2. 注意：
       		 * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签
--%>
<c:if test="true"><h3>我是真</h3></c:if>
<c:if test="false"><h3>我是真</h3></c:if><%--不显示--%>
<%
    //判断request域中的list集合是否为空，不为空则显示遍历集合
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    request.setAttribute("list", list);
    request.setAttribute("number", 4);
%>
<%--集合不为空则遍历--%>
<c:if test="${not empty list}">
    遍历集合！
</c:if><br>
<%--判断奇偶数--%>
<c:if test="${number%2==0}">${number}是偶数</c:if>
<c:if test="${number%2!=0}">${number}是奇数</c:if>
</body>
</html>
