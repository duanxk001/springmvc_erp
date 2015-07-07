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
<script type="text/javascript">
	$(function(){
		$("#nameInput").focus(function(){
			$("#context").text("xixi");
		});
		$("#nameInput").blur(function(){
			//$("#context").text("xixi");
			$.post("check.do",function(data){
				$("context").text(data);
			});
		});
	});
</script>

</head>
<body>
<h2>欢迎访问测试页面！</h2>
<form action="login.do">
	<input type="text" id="nameInput"><span id="context"></span>
	<input type="submit">
</form>
</body>
</html>
