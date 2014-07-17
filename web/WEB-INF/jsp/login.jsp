<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
    <title>login</title>
    <meta http-equiv="content-type" content="text/html ; charset=UTF-8">
    <style type="text/css" >
        .btn { width: 120px;}
        .main{text-align: center; margin-top: 40px;}
        .main input {margin: 10px;}
    </style>
</head>
<body>
    <form METHOD="post" ACTION="${ctx}/user/login2">
         <div class="main">
            UserName: <input  type="text" name="name" value="admin"/><br/>
            PassWord: <input  type="password" name="password" value="123"/><br/>
             <input type="submit" value="Login System" class="btn"/>
         </div>

    </form>
</body>
</html>