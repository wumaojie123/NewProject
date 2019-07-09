<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cn.edu.lingnan.dao.*" %>
<%@ page import="cn.edu.lingnan.dto.*" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加订单</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css"/>
<link rel="stylesheet" href="assets/css/admin.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/app.js"></script>



</head>


<body>
<header class="am-topbar admin-header">
    <div class="am-topbar-brand"><img src="assets/i/logo.png"></div>
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    </div>
</header>
<div class="am-cf admin-main">
    <div class="nav-navicon admin-main admin-sidebar">
        <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：${username }</div>
        <div class="sideMenu">
            <h3 class="am-icon-flag"><em></em>餐品管理</h3>
            <ul>
                <li><a href="ddminFindDishServlet">餐品列表</a></li>
                <li ><a href="insertDish.jsp">添加新餐品</a></li>
            </ul>
            <h3 class="am-icon-sellsy"><em></em>餐位管理</h3>
            <ul>
                <li><a href="deskListServlet">餐位列表</a></li>
                <li><a href="insertDesk.jsp">添加新餐位</a></li>

            </ul>
            <h3 class="am-icon-cart-plus"><em></em> 订单管理</h3>
            <ul>
                <li><a href="orderListServlet">订单列表</a></li>
                <li><a href="sureUnOrderServlet">确认未完成订单</a></li>
                <li><a href="sureHiOrderServlet">确认预定中订单</a></li>
                <li><a href="insertOrder.jsp">添加订单</a></li>
            </ul>
            <h3 class="am-icon-users"><em></em>用户管理</h3>
            <ul>
                <li><a href="adminFindUserServlet">用户列表</a> </li>
                <li><a href="insertUser.jsp">添加用户</a></li>
            </ul>
            
            <h3 class="am-icon-gears"><em></em> 管理者管理</h3>
            <ul>
                <li><a href="adminMangerServlet">修改信息</a></li>
				<li><a href="insertManger.jsp">添加管理员</a></li>
            </ul>
        </div>
    
    <script type="text/javascript">
			jQuery(".sideMenu").slide({
				titCell:"h3", 
				targetCell:"ul", 
				effect:"slideDown", 
				delayTime:300 , 
				triggerTime:150, 
				defaultPlay:true,
				returnDefault:true 
				});
		</script> 


</div>
<div class=" admin-content">
		<div class="daohang">
</div>
<div class="admin-biaogelist">
	
    <div class="listbiaoti am-cf">
      <ul class="am-icon-flag on"> 订单管理</ul>
      
      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">添加订单列表</a></dl>

    </div>
    
    <form class="am-form am-g" action="insertOrderServlet" name="formoforder">
          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            
            <tbody>                      
              <tr>
              <td>用户号</td>  <td><input type="text" name="_userid" ></td>
              </tr>
              <tr>
              <td>餐品号</td>  <td><input type="text" name="_dishid" ></td>
              </tr>
              <tr>
              <td>数量</td>  <td><input type="text" name="_buynumber" ></td>
              </tr> 
              <tr>
              <td>总价</td>  <td><input type="text" name="_sumprice" ></td>
              </tr>           
              <tr>
              <td>预定就餐时间</td>  <td><input type="text" name="_ordertime" placeholder="2018/12/20/12:00" ></td>
              </tr>                                    
               <tr>
              <td>操作</td>  <td><input type="submit" name="确认" value="添加" onclick="return verify()"></td>
              </tr>       
            </tbody>
            
          </table>
          </form>
         <script type="text/javascript">
		function verify()
		{
			var str1=document.formoforder._userid.value;
			var str2=document.formoforder._dishid.value;
			var str3=document.formoforder._buynumber.value;	
			var str4=document.formoforder._sumprice.value;
			var str5=document.formoforder._ordertime.value;
			if(str1=="")
				{
				alert("请输入用户ID！");
				document.formoforder._userid.focus();
				return false;
				}
			if(str2=="")
				{
				alert("请输入餐品号！");
				document.formoforder._dishid.focus();
				return false;
				}
			if(str3=="")
			{
			alert("请输入购买数！");
			document.formoforder._buynumber.focus();
			return false;
			}
			if(str4=="")
			{
			alert("请输入商品总价！");
			document.formoforder._sumprice.focus();
			return false;
			}
			if(str5=="")
			{
			alert("请输入预定就餐时间！");
			document.formoforder._ordertime.focus();
			return false;
			}
			
		}
		</script>  
    
 <div class="foods">
  <dl>
    <a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
  </dl>
</div>
</div>
</div>
</div>
<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]--> 

<!--[if (gte IE 9)|!(IE)]><!--> 
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->



</body>
</html>