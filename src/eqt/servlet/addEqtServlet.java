package eqt.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import commen.DAOFactory;
import eqt.dao.EqtDao;
import eqt.pojo.Eqt;
import pic.dao.PicDao;
import pic.pojo.Pic;

@WebServlet("/addEqtServlet")
public class addEqtServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 响应输出流
		OutputStream out = response.getOutputStream();
		PicDao picdao = DAOFactory.instance().getPicDao();
		EqtDao eqtdao = DAOFactory.instance().getEqtDao();
		
		//获得Servlet上下文对象
		ServletContext context = this.getServletContext();
		
		//磁盘文件列表工厂对象
		DiskFileItemFactory afactory = new DiskFileItemFactory();
		
		//设置内存区块大小4KB
		afactory.setSizeThreshold(4*1024);
		
		//设置暂存容器临时目录，当上传文件大于设置的内存块大小时，用暂存容器做中转
		File tempDir = new File(this.getServletContext().getRealPath("/temp"));
		
		//目录不存在，自动创建
		if(!tempDir.exists())
			tempDir.mkdirs();
		
		afactory.setRepository(tempDir);
		
		//Servlet文件上传对象
		ServletFileUpload upload = new ServletFileUpload(afactory);
		try {
			//设置最大上传文件大小为1000m，超出大小会发生异常
			upload.setSizeMax(1024*1024*1000);
			
			//获得所有上传文件对象集合
			List<FileItem> list = upload.parseRequest(request);
			
			
			
			//获得装备信息
			String eqtName = list.get(0).getString();
			eqtName = new String(eqtName.getBytes("iso-8859-1"),"utf-8");

			String eqtLevell = list.get(1).getString();
			int eqtLevel = Integer.parseInt(eqtLevell);

			String eqtAttribute = list.get(2).getString();
			eqtAttribute = new String(eqtAttribute.getBytes("iso-8859-1"),"utf-8");

			String eqtPowerr = list.get(3).getString();
			int eqtPower = Integer.parseInt(eqtPowerr);

			String eqtType = list.get(4).getString();
			eqtType = new String(eqtType.getBytes("iso-8859-1"),"utf-8");
			
			String eqtQuality = list.get(5).getString();
			eqtQuality = new String(eqtQuality.getBytes("iso-8859-1"),"utf-8");
			
			
			//获得文件对象
			FileItem item = list.get(6);
			
			//获得文件数据流
			InputStream is = item.getInputStream();
			
			//文件大小
			long fileSize = item.getSize();
			
			//MIME类型
			String contentType = item.getContentType();
			
			//客户端文件路径
			String fullName = item.getName();
			//设置上传文件和临时文件夹的物理路径
			String uploadPath = context.getRealPath("/temp");
			
			//创建文件对象
			File file = new File(uploadPath + File.separator + fullName);
			
			Pic pic = new Pic(eqtName,"装备",(int)fileSize,is,new Date());
			
			picdao.insert(pic);
			
			Eqt eqt = new Eqt(eqtName,eqtLevel,eqtAttribute,picdao.queryById(picdao.queryByName(eqtName)),eqtPower,eqtType,eqtQuality);
			eqtdao.insert(eqt);
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
