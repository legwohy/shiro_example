<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body id="bodyClick">
    <h1 >登陆成功! ${msg}</h1>
    <h3><a href="<%=request.getContextPath()%>/user/logout">退出</a> </h3>
</body>

<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#bodyClick").click(function () {
            alert("test");
            window.location.reload(); //刷新当前页面
        });

    })
</script>

</html>
