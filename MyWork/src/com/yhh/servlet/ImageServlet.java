package com.yhh.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import com.yhh.dao.PhotoDao;
import com.yhh.pojo.*;
import com.yhh.service.ImageService;
import com.yhh.service.impl.ImageServiceImpl;

public class ImageServlet extends HttpServlet {
	
	ImageService is=new ImageServiceImpl();
	
	Logger logger =Logger.getLogger(ImageServlet.class);
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String oper2=req.getParameter("oper2");
		if("add".equals(oper2)){
			addImage(req,resp);
		}else if("watch".equals(oper2)){
			watchImage(req,resp);	
		}else if("delete".equals(oper2)){
			deleteImage(req,resp);	
		}else if("update".equals(oper2)){
			updateImage(req,resp);
		}else{
			logger.debug("没有找到对应操作符"+oper2);
		}
	}
	
	protected void addImage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		String name=((User)req.getSession().getAttribute("user")).getUname();

		
		Map<String, String> params = new HashMap<String, String>();
		
		
		
		List<String> list=new ArrayList<String>();
		String filename=PhotoDao.getPhotoNewName();
		System.out.println("new name:"+filename);
		ServletContext servletContext=null;
		servletContext=req.getSession().getServletContext();
		
		List<FileItem> items=PhotoDao.getRequsetFileItems(req,servletContext);
		boolean isLoadToSQL=false;
		if(items==null){
			//System.out.println(" i am empty");
		}
		for(FileItem item:items) {
			if(!item.isFormField()){
				//判断后缀名是否是jpg
				if(PhotoDao.isGif(item)) {
					String path=this.getServletContext().getRealPath("/myImage");
					isLoadToSQL=PhotoDao.saveFile(item,filename,path);
				}else {
					System.out.println("后缀格式有误，保存文件失败");
				}
			}else{
				String itemName = item.getFieldName();
				String value = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
				params.put(itemName, value);
			}
		}
		
		String country=params.get("country");
		String position=params.get("position");
		String resolution=params.get("resolution");
		String longitude=params.get("longitude");
		String latitude=params.get("latitude");
		String acquisition_time=filename;
		String scale=params.get("scale");
		
		
		
		
		
		
		
		
		Image img=new Image(0,name,country,position,resolution,longitude,latitude,acquisition_time,scale);
		int judge=is.addImageService(img);
		if(judge==0){
			
			
			req.getRequestDispatcher("doImages/successAdd.jsp").forward(req, resp);
			//TODO
			//上传成功
		}
		
	}
		
		
		protected void watchImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
			String name=req.getParameter("name");
			String country=req.getParameter("country");
			String position=req.getParameter("position");
			String resolution=req.getParameter("resolution");
			String longitude=req.getParameter("longitude");
			String latitude=req.getParameter("latitude");
			String acquisition_time=req.getParameter("acquisition_time");
			String scale=req.getParameter("scale");
			Image img=new Image(0,name,country,position,resolution,longitude,latitude,acquisition_time,scale);
			//System.out.println(img);
			List<Image> li=is.watchImageService(img);
			System.out.println("查询完成");
//			for(Image ii:li){
//				System.out.println(ii.getName());
//			}
			if(!li.isEmpty()){
				req.setAttribute("li",li);
				req.getRequestDispatcher("/doImages/showImage.jsp").forward(req, resp);
				return;
			}else{
				req.getRequestDispatcher("/doImages/notFoundDelete.jsp").forward(req, resp);
			}
			
			return;
		}
		
		protected void deleteImage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
			//管理员在查询功能中可以看到时间字符串，即我们的name，因此删除时可以输入时间字符串来删除对应项
			//此处加不加文件后缀名要和name属性统一，最好加
			String acquisition_time=req.getParameter("acquisition_time");
			
			int judge=is.deleteImageService(acquisition_time);
			
			if(judge==1){
				String dpath=this.getServletContext().getRealPath("/myImage");
				File deleteFile=new File(dpath+File.separator+acquisition_time);
				deleteFile.delete();
				req.getRequestDispatcher("doImages/successDelete.jsp").forward(req, resp);
			}else if(judge==0){
				req.getRequestDispatcher("doImages/NotFoundDelete.jsp").forward(req, resp);
			}
		}
		
		protected void updateImage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

			String acquisition_time=req.getParameter("acquisition_time");

			String country=req.getParameter("country");
			String position=req.getParameter("position");
			String resolution=req.getParameter("resolution");
			String longitude=req.getParameter("longitude");
			String latitude=req.getParameter("latitude");
			
			String scale=req.getParameter("scale");
			Image img=new Image(0,"",country,position,resolution,longitude,latitude,acquisition_time,scale);
			int judge=is.updateImageService(img);
			if(judge>0){
				req.getRequestDispatcher("doImages/successAdd.jsp").forward(req, resp);
				
			}else if(judge==0){
				req.getRequestDispatcher("doImages/notFoundDelete.jsp").forward(req, resp);
			}
		}
		
	}


