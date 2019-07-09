package cn.edu.lingnan.servlet;

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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.lingnan.dao.DishDAO;

public class FileUpload_1 extends HttpServlet{
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
				
				String  test=request.getSession().getServletContext().getRealPath("/")+"images\\";				
				try{
					item.write(saveFile);							
					out.println("<p align='center'>图片添加成功！</p>");
					//response.sendRedirect(request.getContextPath()+"/admin/insertDish.jsp");
				}
				catch(Exception e)
				{
					e.printStackTrace();
					out.println("<p align='center'>图片添加失败！</p>");
				}
			}
		}
	}
}
