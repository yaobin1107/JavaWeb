<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" buffer="8kb" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--JSP指令：
    * 格式：
    <%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>
    三种指令：
        1.page      ：配置JSp页面
            * contentType：响应消息体mime类型及字符集
            * 设置当前jsp页面编码（高级IDE），低级工具要设置pageEncoding属性设置当前页编码
            * buffer 缓冲区大小
            * import：导包
            * errorPage：当前页发生错误后会自动跳转到
            * isErrorPage：是否是错误页面（true则可以使用内置对象exception）
        2.include   ：导入页面资源文件（导入另一个页面）
        2.taglib    ：导入资源
    内置对象：
			变量名					真实类型						作用
		* pageContext				PageContext					当前页面共享数据，还可以获取其他八个内置对象
		* request					HttpServletRequest			一次请求访问的多个资源(转发)
		* session					HttpSession					一次会话的多个请求间
		* application				ServletContext				所有用户间共享数据
		* response					HttpServletResponse			响应对象
		* page						Object						当前页面(Servlet)的对象  this
		* out						JspWriter					输出对象，数据输出到页面上
		* config					ServletConfig				Servlet的配置对象
		* exception					Throwable					异常对象
--%>
<c:forEach var="" items="">
</c:forEach>
</body>
</html>
