<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>物流管理后台</title>
    <%@ include file="/WEB-INF/jsp/common/base.jspf" %>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/table/bootstrap-table.css">
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
            <div class="col-xs-12">
              <div class="box box-success">
              
                <div class="box-body">
                
                  <!-- 添加搜索条件 -->
                  <div class="box-body">
                    <div class="row">
                      <form id="searchForm" action="" onsubmit="return false;">
                        <div class="col-xs-2">
                           <select class="form-control" name="key" id="query_key">
                             <option value="loginName">登录名</option>
                             <option value="username">名称</option>
                           </select>
                        </div>
                        
                        <div class="col-xs-2">
                          <input type="text" id="query_value" name="value" class="form-control" placeholder="关键字">
                        </div>
                        <div class="col-xs-2">
                           <button type="submit" class="btn bg-olive btn-flat">查询</button>
                        </div>
                      </form>
                    </div>
                  </div>
                  
                  <div id="toolbar">
                    <a href="${pageContext.request.contextPath }/users/saveUI" type="button" class="btn bg-maroon btn-flat">添加</a>
                    <button type="button" data-ope="delete" class="btn bg-olive btn-flat">删除</button>
                    <button type="button" data-ope="edit" class="btn bg-orange btn-flat">编辑</button>
                  </div>
                  <table id="user_table"></table>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
     
      <%@ include file="/WEB-INF/jsp/common/bottom.jspf" %>
      
      <script src="${pageContext.request.contextPath}/static/bower_components/table/bootstrap-table.js"></script>
      <script src="${pageContext.request.contextPath}/static/bower_components/table/bootstrap-table-zh-CN.js"></script>
    </div>
    <!-- <script src="${pageContext.request.contextPath}/static/dist/js/user.js"></script> -->
    
    <script type="text/javascript">
        <!-- 监听页面渲染完毕,jquery -->
        var $table;
        $(function(){
        	
        	//监听查询按钮的点击
        	//jquery
        	$("#searchForm").on("submit",function(){
                var param = $(this).serializeObject();  //将表单中的文本框 下拉框 根据name 属性 序列化成字符串
        		if(param.key && param.value){
        			var key = param.key;
        			var value = param.value;
        		    delete param['key'];
        		    delete param['value'];
        			param[key] = value;
        		}
        		$table.bootstrapTable('refresh',{query:param}); //table 插件的方法
        		return false;
        	});
        	
        	//监听按钮的点击事件
        	//$("#id") 根据id查找元素
        	$("#toolbar > button").on("click",function(){
        		var $it=$(this);     
        		var ope=$it.data("ope");//jquery对象.data("xxx") 获取标签中data-xx的值
        		var idArray=$table.bootstrapTable('getAllSelections');
        		if(idArray.length==0)
        			{
        			alert("至少选中一条记录");
        			return ;
        			}
        		
        		//至少选中一条
        		console.log(idArray);
        		idArray=$.map(idArray,function(item){
        			return item.userid;           
        		});
        		if("edit"==ope)
        			{       			
        			window.location.href="${pageContext.request.contextPath}/users/"+idArray[0]+"/editUI";
        			
        			}
        		else if("delete"==ope)
        			{
        			//获取需要删除的id
        			var ids=idArray.join(",");
        			//alert(ids);
        			//js 
        			//发送ajax请求 
        			
        			//{ids}",headers={"X-Requested-With=XMLHttpRequest"},method=RequestMethod.DELETE

        			//携带这样的数据_method=DELETE
        			$.ajax({
        				type : "POST",
        				url : sys.contextPath+"/users/"+ids,
        				data : "_method=DELETE",
        				cache: false,   
      				    async: true, //总是设置成true，这标志着在请求开始后，其他代码依然能够执行。强烈不建议把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死。
      				    success: function(data){  //响应成功
      				    	console.log(data);    //服务器返回的数据
      				        if(data.success){
      				        	$table.bootstrapTable('refresh'); //table 插件的方法
      				        }else{
      				        	alert(data.msg);
      				        }
      				    }        				        				
        			});
        			
        			}
        		
        	});
        	
        	
        	//发送请求
        	 var queryUrl = 'http://localhost:8080/PersonalSpace/users';
         	  $table = $('#user_table').bootstrapTable({
         		 url: queryUrl,                      //请求后台的URL（*）
                 method: 'GET',                      //请求方式（*）
                 toolbar: '#toolbar',                //工具按钮用哪个容器
                 striped: true,                      //是否显示行间隔色
                 cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                
                 pagination:true,                   //是否显示分页（*）
                 sortable: true,                     //是否启用排序
                 sortOrder: "asc",                   //排序方式
                 sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                 
                 pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
                 pageSize: 10,                       //每页的记录行数（*）
                 pageList: [1, 2, 50, 100],        //可供选择的每页的行数（*）
                    
                 clickToSelect: true,                //是否启用点击选中行
                 uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                 
                 //得到查询的参数
                 queryParams : function (params) {
                      var temp = {   
                          pageStart: (params.offset / params.limit) + 1,   //页码
                          sort: params.sort,      //排序列名  
                          sortOrder: params.order //排位命令（desc，asc） 
                      };
                    return temp;
                 },
                 columns: [{
                     checkbox: true,  
                     visible: true                  //是否显示复选框  
                 },{
                     field: 'username',
                     title: '名称'
                 },{
                     field: 'loginName',
                     title: '登录名'
                 },{
                     field: 'usersex',
                     title: '性别'
                 },{
                	 field: 'userphone',
                	 title: '手机号码'
                 }],                
                 onLoadError: function () {
                   //加载失败触发
                 },
                 responseHandler: function(res) {
                     return {
                         "total": res.total,//总页数
                         "rows": res.rows   //数据
                      };
                 }
             });
        });

        </script>
  </body>
</html>
    