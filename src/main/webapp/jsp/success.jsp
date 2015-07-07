<%@ page language="java"  pageEncoding="utf-8" %>
<%@ page import="java.lang.String"%>
<%@ page import="java.lang.Math"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script src="js/lib/jquery-1.8.0.min.js" type="text/javascript"></script>

</head>
<body>
<h2><%=request.getAttribute("name") %>成功页面！</h2>
</body>
</html>
