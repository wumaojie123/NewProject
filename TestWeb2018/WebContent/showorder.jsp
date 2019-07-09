<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Order</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">  
<link href="css/font-awesome.css" rel="stylesheet"> <!-- font-awesome icons --> 

<script src="js/jquery-2.2.3.min.js"></script>  

<link href="http://fonts.googleapis.com/css?family=Berkshire+Swash" rel="stylesheet"> 
<link href="http://fonts.googleapis.com/css?family=Yantramanav:100,300,400,500,700,900" rel="stylesheet">
</head>
<body>

	<div class="banner about-w3bnr">
		<div class="header">
			<div class="w3ls-header"> 
				<div class="container">
					<div class="w3ls-header-left">
						<p>欢迎您：${ username}</p>
					</div>
					<div class="w3ls-header-right">
						<ul> 
						<li class="head-dpdn">
								<i class="fa fa-phone" aria-hidden="true"></i> Call us: 15767581439 
							</li>					
							<li class="head-dpdn">
								<a href="login.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i> 登录</a>
							</li> 
							<li class="head-dpdn">
								<a href="signup.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i> 注册</a>
							</li> 
							<li class="head-dpdn">
								<a href="Loginout"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
							</li>
						
						</ul>
					</div>
					<div class="clearfix"> </div> 
				</div>
			</div>
	<div class="navigation agiletop-nav">
		<div class="container">
			<nav class="navbar navbar-default">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header w3l_logo">
					<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						</button>  
						</div> 
						<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="index.jsp">首页</a></li>
						<li class="dropdown">
							<a href="menu.jsp" >菜单</a>							
						</li>
						<li><a href="deskOrderSerlvet">餐位预定</a></li>
						<li><a href="showorder.jsp">我的订单</a></li>			
					</ul>
				</div>
				<div class="cart cart box_1"> 
					<form action="#" method="post" class="last"> 
						<input type="hidden" name="cmd" value="_cart" />
						<input type="hidden" name="display" value="1" />
						<button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
					</form>   
				</div>
			</nav>
		</div>
	</div>
			
</div>
		
</div>	  
	<div class="container">	
		<ol class="breadcrumb w3l-crumbs">
			<li><a href="#"><i class="fa fa-home"></i> 首页</a></li>
			<li class="active">菜单</li>
		</ol>
	</div>	  	
	<div class="wthree-menu">  
		<img src="" class="w3order-img" alt=""/>
		<div class="container">
			<h3 class="w3ls-title">订单</h3>
			<div class="container">
			 <form action="submitOrder">
			<table class="table table-hover table-bordered table-responsive">
<tr>
<td>菜名</td>
<td>单价</td>
<td>数量</td>
<td>单品总价</td>
</tr>
<c:set var="position" value="1"/>
<c:forEach items="${v3}" var="order">
<tr>
<td><input name="_dishnames${position }" style="border: none;outline:none;cursor: pointer; width:80px" type="text"   value="${order.dishname }"> </td>
<td>${order.unitprice }</td>
<td><input name="_dishamounts${position}" style="border: none;outline:none;cursor: pointer; width:20px" type="text"   value="${order.amount }"></td>
<td><input name="_dishvalues${position }" style="border: none;outline:none;cursor: pointer; width:30px" type="text"   value="${order.values }"> </td>

</tr>
<c:set var="position" value="${position+1}"/>
</c:forEach>
</table>
			<h3 class="w3ls-title">预定信息</h3>		
			<table class="table table-hover table-bordered table-responsive">
<tr>
<td>餐桌号</td>
<td>座位</td>
<td>房间号</td>
</tr>
<c:forEach items="${v1desk}" var="desk1">
<tr>
<td> ${desk1.deskid }</td>
<td>${desk1.seatnumber }</td>
<td>${desk1.roomid}</td>
</tr>
</c:forEach>
</table>
			
		
<div class="col-md-3 col-sm-4">
<h4>请输入预约就餐时间</h3>
<input type="text" name="_ordertime" class="form-control" placeholder="2018/11/26/8:00">
<br>
<input type="submit" value="下订单">
</div>
</form>
	</div>		
		</div>
	</div>
	
	<script src="js/minicart.js"></script>
	<script>
        w3ls.render();

        w3ls.cart.on('w3sb_checkout', function (evt) {
        	var items, len, i;

        	if (this.subtotal() > 0) {
        		items = this.items();

        		for (i = 0, len = items.length; i < len; i++) { 
        		}
        	}
        });
    </script>  
	
	<script src="js/SmoothScroll.min.js"></script>  
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>	
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
			
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
	
    <script src="js/bootstrap.js"></script>
<div class="subscribe agileits-w3layouts"> 
		<div class="container">
			
		</div>
	</div>
    <div class="copyw3-agile"> 
		<div class="container">
		</div>
	</div>






</body>
</html>