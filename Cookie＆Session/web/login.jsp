<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    window.onload = function () {
        img = document.getElementById("img").onclick = function () {
            this.src = "/CookieAndSession/checkCodeServlet?" + new Date().getTime();
        }
    }
</script>
<style>
    div {
        color: red;
    }
</style>
<body>
<form action="/CookieAndSession/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/CookieAndSession/checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登陆"></td>
        </tr>
    </table>
</form>

<div>
    <%=request.getAttribute("checkCodeError") == null ? "" : request.getAttribute("checkCodeError")%>
</div>
<div>
    <%=request.getAttribute("loginError") == null ? "" : request.getAttribute("loginError")%>
</div>
</body>
</html>
