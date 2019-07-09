<%@ page import="cn.edu.lingnan.dao.*" %>
<%@ page import="cn.edu.lingnan.dto.*" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
 <div class="container">
<table class="table table-hover table-bordered table-responsive">
<tr>
<td>编号</td>
<td>名称</td>
<td>原价</td>
<td>优惠价</td>
<td>简介</td>
</tr>
 
<c:forEach items="${listss}" var="person">


<tr>
<td>${person.dishid}</td>
<td>${person.dishname }</td>
<td>${person.original_price }</td>
<td>${person.prefer_price }</td>
<td width="300px" >${person.dishinformation }</td>

</tr>
</c:forEach>
</table>
<br>
<c:if test="${pageNos>1 }">
<a href="PageServlet?pageNos=1" >首页</a>
<a href="PageServlet?pageNos=${pageNos-1 }">上一页</a>
</c:if>
<c:if test="${pageNos <recordCount }">
<a href="PageServlet?pageNos=${pageNos+1 }">下一页</a>
<a href="PageServlet?pageNos=${recordCount }">末页</a>
</c:if>
<form action="PageServlet">
<h4 align="center">共${recordCount}页  
<input type="text" value="${pageNos}" name="pageNos" size="1">页
<input type="submit" value="到达">
</h4>
</form>
</div>
</body>
</html>