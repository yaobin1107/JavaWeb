<%@ page import="cn.yb.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>El获取域对象中对象,集合(List,Map)的属性值</title>
</head>
<body>
<%
    User user = new User();
    user.setPassword("1234");
    user.setUsername("yb");
    request.setAttribute("user", user);

    ArrayList list = new ArrayList();
    list.add("yb");
    list.add("zs");
    list.add(user);
    request.setAttribute("list", list);

    Map map = new HashMap();
    map.put("sex", "男");
    map.put("user", user);
    request.setAttribute("map", map);
%>

<h3>el获取对象中的值</h3>
${requestScope.u}<br>
${user}<br>
${user.username}<br><%--实际上是调用getter方法--%>
${user.password}<br>
<h3>el获取List集合中的值</h3>
${list}<br>
${list[0]}<br>
${list[1]}<br>
${list[10]}<br><%--角标越界显示空字符串--%>
<h3>list中存对象，获取属性</h3>
${list[2].username}<br>
\${list[2].username}<br>
<h3>el获取Map中的值</h3>
${map.sex}<br>
${map["sex"]}<%--两种不同写法--%>
<h3>map中存对象，获取属性</h3>
${map.user.username}<%--map中对象的属性--%><br>
\${map.user.username}
<h3>隐式对象</h3>
${pageContext.request}<br><%--获取request对象--%>
<%--动态获取虚拟目录--%>
${pageContext.request.contextPath}
</body>
</html>
