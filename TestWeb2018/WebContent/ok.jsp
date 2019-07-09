<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
恭喜你，成功啦！
<p>当前用户：<%=session.getAttribute("username") %></p>
<p>当前状态：<%=session.getAttribute("n")%></p>
<p>会话ID：<%=session.getAttribute("id")%></p>
<a href=" <%=response.encodeURL("index.jsp")  %> ">重新登陆</a> 
<a href="<%=response.encodeURL("Loginout")   %> ">注销</a>
<img alt="" src="images/1.png" width="200px">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(basePath);
%>
<img src="<%=basePath%>/images/1.jpg">
</body>

</html>