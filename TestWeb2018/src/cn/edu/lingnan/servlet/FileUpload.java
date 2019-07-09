package cn.edu.lingnan.servlet;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.lingnan.dao.DishDAO;
import cn.edu.lingnan.dto.DishDTO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FileUpload extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String uploadpath="";
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		int maxsize=5*1024*1024;
		upload.setHeaderEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<FileItem> items=null;
		try
		{
			items=upload.parseRequest(request);
			
		}
		catch(FileUploadException e)
		{
			e.printStackTrace();
		}
		String dishname=request.getParameter("_dishname");
		//System.out.println(dishname);
		
		Iterator<FileItem> iterator=items.iterator();
		//File uploadFile=new File(request.getSession().getServletContext().getRealPath("/")+"images/");
		File uploadFile=new File("E:\\javaweb\\TestWeb2018\\WebContent\\images");
		uploadpath=uploadFile.getAbsolutePath()+File.separator+uploadpath;
		//System.out.println(uploadpath);
		if(uploadFile.exists()==false)
		{
			uploadFile.mkdir();
		}
		while(iterator.hasNext())
		{
			FileItem item=(FileItem)iterator.next();
			if(!item.isFormField())
			{
				String filePath=item.getName();
				//System.out.println(filePath);
				if(filePath!=null)
				{
					File filename=new File(item.getName());
					//System.out.println(filename);
				}
				if(item.getSize()>maxsize)
				{
					out.print("<p align='center'>上传失败，文件大小不得超过5MB</p>");
					break;
				}
           
				File saveFile=new File(uploadpath,filePath.substring(filePath.lastIndexOf("\\")+1));
				String filename_2=filePath.substring(filePath.lastIndexOf("\\")+1);
				//System.out.println(filename_2);
				
				String  test=request.getSession().getServletContext().getRealPath("/")+"images\\";
				//System.out.println(test);
				Integer dishid=(Integer)session.getAttribute("dishid");
	          	DishDAO dishdao=new DishDAO();
	          	dishdao.updateDishPhoto(filename_2, dishid);
	            System.out.println("sdf  "+dishid);
				try{
					item.write(saveFile);							
					out.println("<p align='center'>图片更新成功！</p>");
					
					//String path = request.getContextPath();
					//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					//System.out.println(basePath);
					//out.println("<img src='" + basePath + "/images/"+ filename_2 + "'>");
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
					out.println("<p align='center'>图片更新失败！</p>");
				}
			}
		}
	}
	

}
