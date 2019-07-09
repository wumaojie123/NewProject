
        var $table;
        $(function(){
        	
        	//监听查询按钮的点击
        	//jquery
        	$("#searchForm").on("submit",function(){
                var param = $(this).serializeObject();  
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
        			//判断是否选中，判断选中的条数
        			window.location.href="${pageContext.request.contextPath}/users/"+idArray[0]+"/editUI";
        			
        			}
        		else if("delete"==ope)
        			{
        			
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
                 pageSize: 1,                       //每页的记录行数（*）
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
