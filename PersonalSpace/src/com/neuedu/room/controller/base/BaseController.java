package com.neuedu.room.controller.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import javax.servlet.ServletException;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.neuedu.room.domain.User;
import com.neuedu.room.query.UserQuery;
import com.neuedu.room.query.base.BaseQuery;
import com.neuedu.room.service.base.BaseService;
import com.neuedu.room.utils.JsonModel;

public class BaseController<T,E extends BaseQuery> {
	protected BaseService<T,E> baseService;
	private String prefix;
	private String simpleName;
	private Class<T> clazz;
	
	public BaseController()
	{   //获取<X,Y>
		ParameterizedType paramterizedType=(ParameterizedType)this.getClass().getGenericSuperclass();
	     //获取<X>
		clazz=(Class<T>)paramterizedType.getActualTypeArguments()[0];
		simpleName=clazz.getSimpleName().toLowerCase();
		prefix=simpleName +"s";
		
	}
	@RequestMapping("/list")
    public String listUI()
    {
    	return prefix+"/listUI";
    }
	
	@RequestMapping("")
	@ResponseBody   //将返回的内容转换成json字符串[对象的属性名当做是key,对象的属性值当做是value]
	public JsonModel<T> list(E e) throws ServletException, IOException {
		
		JsonModel<T> jsonModel = new JsonModel<T>();
		 jsonModel.setSuccess(true);
		 jsonModel.setMsg("查询用户成功");
		 
		 
		 PageInfo<T> pageInfo = baseService.find(e);
		 jsonModel.setRows(pageInfo.getList());
		 jsonModel.setTotal((int)pageInfo.getTotal());
		//转发到登录界面
		return jsonModel; 
	}
	
	/**
     * 转发到添加界面
     * **/
    @RequestMapping(value="/saveUI",method=RequestMethod.GET)
    public String saveUI(ModelMap modelMap)
    {   modelMap.addAttribute("user", new User());
    	return prefix+"/saveUI";
    }
    
    /**
     * 转发到添加界面
     * **/
    @RequestMapping(value="",method=RequestMethod.POST)
    public String save(T t)
    {   
    	baseService.add(t);
    	
    	//重定向到列表界面
    	return "redirect:/"+prefix+"/list";
    }
    
    /**
     * 转发到修改界面:传参在方法中
     * **/
    @RequestMapping(value="/{userid}/editUI",method=RequestMethod.GET)//{id}请求路径参数
    public String editUI(@PathVariable("userid") int userid,ModelMap modelMap )
    {    //通过userid查找相应的用户
    	T t=(T)baseService.findById(userid);
    	
    	if(t==null)
    	{
    		return null;
    	}
    	else
    	{
    		//查找当前记录
        	//跳转到编辑界面
    		//modelMap.addAttribute("user",user);
    		modelMap.addAttribute(simpleName, t);
        	//return "users/saveUI";
    		return prefix+"/saveUI";
    	}
    }
    	
   @RequestMapping(value="/{userid}",method=RequestMethod.PUT)
   public String edit(@PathVariable("userid") int userid,T t,ModelMap modelMap)
   {        
	        baseService.update(t);
	     //重定向到列表界面
    		return "redirect:/"+prefix+"/list";
    }
   
   /**
	 * 删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/{ids}",headers={"X-Requested-With=XMLHttpRequest"},method=RequestMethod.DELETE)
	@ResponseBody 
	public JsonModel delete(@PathVariable("ids") String ids){
		JsonModel jsonModel = new JsonModel();
		if(StringUtil.isEmpty(ids)){
			jsonModel.setSuccess(false);
			jsonModel.setMsg("参数错误");
			return jsonModel;
		}
		//切割 1,2,3,4
		String [] idArray = ids.split(",");
		int count = baseService.delete(idArray);
		
		jsonModel.setSuccess(true);
		jsonModel.setMsg("删除成功");
		return jsonModel;
	}
	

}
