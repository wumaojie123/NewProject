<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
  <head>
    <title>物流管理后台</title>
    <%@ include file="/WEB-INF/jsp/common/base.jspf" %>

  </head>
  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
    
      <%@ include file="/WEB-INF/jsp/common/top.jspf" %>
    
      <%@ include file="/WEB-INF/jsp/common/menu.jspf" %>
        
      <div class="content-wrapper">
        <section class="content-header">
          <h1>会员管理</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i>系统管理</a></li>
            <li><a href="#">会员管理</a></li>
            <li class="active">列表</li>
          </ol>
        </section>
      
        <!-- Main content -->
        <section class="content">
        <div class="row">
        <!-- left column -->
        <div class="col-md-6">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Quick Example</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <!-- spring MVC 内置有请求方式转换器 -->
                    
            <form:form action="${pageContext.request.contextPath }/users/${user.userid}" method="post" commandName="user">
            <form:hidden path="userid"/>
            <input type="hidden" name="_method" value="PUT">
            <div class="box-body">
                <div class="form-group">
                  <label for="loginName">登录名</label>
                  <form:input path="loginName" cssClass="form-control" placeholder="请输入登录名"/>                  
                </div>
                <div class="form-group">
                  <label for="username">用户名</label>
                  <form:input path="username" cssClass="form-control" placeholder="请输入用户名"/>
                 
                </div>                            
              </div>
 
              <div class="box-footer">
                <button type="submit" class="btn btn-primary">保存</button>
              </div>
            </form:form>
            
            
            
            
          </div>
        </div>
        </section>
      </div>     
      <%@ include file="/WEB-INF/jsp/common/bottom.jspf" %>
    </div> 
  </body>
</html>