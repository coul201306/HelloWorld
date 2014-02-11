<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>helloworld</title>
<link href="themes/css/login.css" rel="stylesheet" type="text/css" />

</head>
  
  <body>
    This is my JSP page. <br>
    <form id="login_form" action="${pageContext.request.contextPath}/loginSub" method="post" >
    <label>username</label><input type="text" id="username" name="username"  value="" size="20" />
    <label>password</label><input type="password" id="password" name="password"  value="" size="20"/>
   	<input type="submit" id="sub" name="sub" value="login"/>
   	</form>
  </body>
</html>
