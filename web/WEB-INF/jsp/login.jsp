<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/user/login.do" method="post">
        <input type="text" name="username" placeholder="请输入登录名"><br/>
        <button type="submit">登陆</button>
    </form>
<h1>${msg}</h1>
</body>
</html>
