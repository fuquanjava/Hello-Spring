<%@ page contentType="text/html;charset=UTF-8" language="java" import="hello.springmvc.token.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>save</title>
    <meta http-equiv="content-type" content="text/html ; charset=UTF-8">
</head>
<body>
    <form action="${ctx}/token/save" method="post" >
        <input type="hidden" value="${tokenValue}" name="${tokenName}"/>
        Name:<input name="name" type="text"><br/>
        <input  type="submit" value="Submit"/>
    </form>
</body>
</html>