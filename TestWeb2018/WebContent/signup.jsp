<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>用户注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">  
<link href="css/font-awesome.css" rel="stylesheet"> <!-- font-awesome icons --> 
<script src="js/jquery-2.2.3.min.js"></script>   
<link href="http://fonts.googleapis.com/css?family=Berkshire+Swash" rel="stylesheet"> 
<link href="http://fonts.googleapis.com/css?family=Yantramanav:100,300,400,500,700,900" rel="stylesheet">

</head>
<body> 
	<div class="banner about-w3bnr">
		<!-- header -->
		<div class="header">
			<div class="w3ls-header"><!-- header-one --> 
				<div class="container">
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
							
						</ul>
					</div>
					<div class="clearfix"> </div> 
				</div>
			</div>
			<div class="navigation agiletop-nav">
				<div class="container">
					<nav class="navbar navbar-default">
						<div class="navbar-header w3l_logo">
							
						</div> 
						<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="index.jsp">首页</a></li>
								<li class="dropdown">
									<a href="menu.jsp" >菜单 </a>
									
								</li>
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
		<div class="banner-text">	
			<div class="container">
				<h2>给你带来 <br> <span>最佳的服务。</span></h2>
			</div>
		</div>
	</div> 
	<div class="container">	
		<ol class="breadcrumb w3l-crumbs">
			<li><a href="#"><i class="fa fa-home"></i> 首页</a></li>
			<li class="active">注册</li>
		</ol>
	</div>
	
	<div class="login-page about">
		<img class="login-w3img" src="images/img3.jpg" alt="">
		<div class="container"> 
			<h3 class="w3ls-title w3ls-title1">注册您的账户</h3>
			<div class="login-agileinfo"> 
				<form action="signupServlet"> 	
				<span><h3>姓名:</h3></span>			
					<input class="agile-ltext" type="text" name="username" onblur="checkName(this.value)" id="account" placeholder="Username" >
					<span><h3>性别:</h3></span>					
					<input class="agile-ltext" type="text" name="sex" id="sex"  placeholder="Sex" >
					<span><h3>电话:</h3></span>
					<input class="agile-ltext" type="text" name="phone" id="phone" placeholder="Your Phone" >
					<span><h3>密码:</h3></span>
					<input class="agile-ltext" type="password" name="password" id="pwd"  placeholder="Password" >
					<span><h3>确认密码:</h3></span>
					<input class="agile-ltext" type="password" name="ConfirmPassword" id="pwd1"  placeholder="Confirm Password" >
					<div class="wthreelogin-text"> 
	
						<div class="clearfix"> </div>
					</div>   
					<input type="submit" value="Sign Up" onclick="return verify();">					
				</form>
				<p>已经有账户了?  <a href="login.jsp"> 立即登陆!</a></p>
			</div>	 
		</div>
	</div>	
	<div class="subscribe agileits-w3layouts"> 
		<div class="container">		
		</div>
	</div>	
	<div class="copyw3-agile"> 
		<div class="container">
			
		</div>
	</div>
	
	<script type="text/javascript">
	function verify()
	{
		var reg=/^[\u4e00-\u9fa5a-zA-Z_]+[\u4e00-\u9fa5a-zA-Z_a-z0-9]+$/;
		var str=document.getElementById("account").value;
		if(str=="")
		{
			alert("用户名不能为空");
           document.getElementById("account").focus();
			return false;
		}
		if(!str.match(reg))
		{
			alert("用户名输入不合法，请以字母或下划线或汉字开头");
			document.getElementById("account").value="";
			document.getElementById("account").focus();
			return false;
		}

		var str2=document.getElementById("sex").value;
		if(str2=="")
		{
			alert("性别不能为空，请输入男或者女!");
			document.getElementById("sex").focus();
			return false;
		}
		if(!(str2=="男"||str2=="女"))
		{
			alert("请输入男或者女!");
			document.getElementById("sex").value="";
			document.getElementById("sex").focus();
			return false;
		}

		var reg3=/^\d{11}$/;
		var str3=document.getElementById("phone").value;
		if(str3=="")
		{
			alert("手机号码不能为空");
			document.getElementById("phone").focus();
			return false;

		}
		if(!reg3.test(str3)){
			alert("手机号码格式有误，请输入7到11位号码");
			document.getElementById("phone").value="";
			document.getElementById("phone").focus();
			return false;
		}

		var reg1=/^\w{6,20}$/;
		if(document.getElementById("pwd").value=="")
		{
			alert("密码不能为空");
         document.getElementById("pwd").focus();
			return false;
		}
		if(!reg1.test(document.getElementById("pwd").value)){
			alert("请输入6到20的密码");
			document.getElementById("pwd").value="";
			document.getElementById("pwd").focus();
			return false;
		}

		if(document.getElementById("pwd1").value!=document.getElementById("pwd").value)
		{
			alert("请确认你的密码！");
			document.getElementById("pwd1").value="";
			document.getElementById("pwd1").focus();
			return false;
			}

	}	
    var xmlHttp;
    function getXMLHttpRequest() {
        if (window.XMLHttpRequest) {
            return new XMLHttpRequest();

        } else {
            return new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    function checkName(username) {
        xmlHttp = getXMLHttpRequest();
        xmlHttp.open("Get", "servlet/CheckUserNameServlet?username="+username, true);
        xmlHttp.onreadystatechange = checkNameCallBack;
        xmlHttp.send();

    }
    function checkNameCallBack() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var text = xmlHttp.responseText;
            if("0"==text){
                alert("用户名已存在，请重新输入");
                document.getElementById("account").value="";
            	document.getElementById("account").focus();
                return false;
            }else{
            	return true;
            }
        }

    }
</script>

	
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
</body>
</html>