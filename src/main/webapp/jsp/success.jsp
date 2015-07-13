<%@ page language="java"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
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
<shiro:guest><h2>游客，您好！成功页面！</h2></shiro:guest>
<shiro:user><h2><%=request.getAttribute("name") %>成功页面！</h2></shiro:user>
<shiro:guest>
	<h2>You are our guest!</h2>
We would love to make you a more permanent part of the family. <br />
How about <a href="/springMVC/index.jsp">Registering</a> ?
</shiro:guest>

<shiro:user>
	<shiro:authenticated>
		<h2>You are Authenticated!</h2>
		<p>It appears that you were authenticated successfully this
			session, not merely remembered!</p>
	</shiro:authenticated>
	<shiro:notAuthenticated>
		<h2>You are Unauthenticated!</h2>
		<p>
			Don't worry, it doesn't mean we don't remember you. We do!<br />
			But remembering you is subtly different from having you
			authenticated. Someone might have stolen your cookies!<br /> <a
				href="/identity/login">Login</a> and get all authenticated!
		</p>
	</shiro:notAuthenticated>

	<shiro:hasRole name="Test">
		<h2>Test Role</h2>
		<p>Whoot! You actually have a role, even if it is just a test
			role.</p>
	</shiro:hasRole>
	
	<shiro:hasRole name="Test111">
		<h2>Test Role</h2>
		<p>fuck you! role.</p>
	</shiro:hasRole>

	<shiro:hasPermission name="read">
		<h2>You Have Permission</h2>
		<p>To read this test!</p>
	</shiro:hasPermission>
	<c:choose>
		<c:when test='${identity != NULL}'>
			<strong>Identity ID:</strong> ${identity.id}      <br />
			<strong>User ID: </strong> [${identity.userid}]  <br />
		</c:when>
		<c:otherwise>
       It doesn't appear we found an identity. Is there one in the database? <br />
			<strong>Identity ID:</strong> ${identity.id}      <br />
			<strong>User ID: </strong> -${identity.userid}-  <br />
		</c:otherwise>
	</c:choose>

	<p>The time on the server is ${serverTime}.</p>

	<h2>The following services are bound to this application:</h2>
	<ul>
		<c:forEach items="${services}" var="service">
			<li><p>${service}</p></li>
		</c:forEach>
	</ul>
</shiro:user>
</body>
</html>
