<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>登录界面</title>
  
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/css/AdminLTE.min.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/css/bootstrapValidator.min.css">
   
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="${pageContext.request.contextPath}/static/response/html5shiv.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/response/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font 
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
-->

</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="${pageContext.request.contextPath}/static/index2.html"><b>Admin</b>LTE</a>
  </div>  
  <div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session</p>
    <form action="${pageContext.request.contextPath}/users/login" method="post">
      <div class="form-group has-feedback">
      
      <div class="form-group">
        <input type="text" name="loginName" class="form-control" placeholder="登录名">
      </div>  
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
      <div class="form-group">
        <input type="password" name="password" class="form-control" placeholder="密码">
      </div>  
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
       
        <div class="col-xs-12">
          <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
          
        </div>      
      </div>
      <div class="row">
        <div class="col-xs-12">
          
           ${errorMag}
        </div>
      </div>
    </form>
  </div>
</div>
<script src="${pageContext.request.contextPath}/static/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
$(function () {
    $('form').bootstrapValidator({
     message: 'This value is not valid',
     feedbackIconsf: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
          },
        fields: {
            loginName: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    regexp:{
                    	regexp:/^[a-zA-z0-9_]+$/,
                    	message:'用户名只能包含大写、小写、数字和下划线'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }
        }
    });
});

</script>

</body>
</html>