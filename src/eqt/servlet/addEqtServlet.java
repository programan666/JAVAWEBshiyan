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
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// ��Ӧ�����
		OutputStream out = response.getOutputStream();
		PicDao picdao = DAOFactory.instance().getPicDao();
		EqtDao eqtdao = DAOFactory.instance().getEqtDao();
		
		//���Servlet�����Ķ���
		ServletContext context = this.getServletContext();
		
		//�����ļ��б�������
		DiskFileItemFactory afactory = new DiskFileItemFactory();
		
		//�����ڴ������С4KB
		afactory.setSizeThreshold(4*1024);
		
		//�����ݴ�������ʱĿ¼�����ϴ��ļ��������õ��ڴ���Сʱ�����ݴ���������ת
		File tempDir = new File(this.getServletContext().getRealPath("/temp"));
		
		//Ŀ¼�����ڣ��Զ�����
		if(!tempDir.exists())
			tempDir.mkdirs();
		
		afactory.setRepository(tempDir);
		
		//Servlet�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(afactory);
		try {
			//��������ϴ��ļ���СΪ1000m��������С�ᷢ���쳣
			upload.setSizeMax(1024*1024*1000);
			
			//��������ϴ��ļ����󼯺�
			List<FileItem> list = upload.parseRequest(request);
			
			
			
			//���װ����Ϣ
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
			
			
			//����ļ�����
			FileItem item = list.get(6);
			
			//����ļ�������
			InputStream is = item.getInputStream();
			
			//�ļ���С
			long fileSize = item.getSize();
			
			//MIME����
			String contentType = item.getContentType();
			
			//�ͻ����ļ�·��
			String fullName = item.getName();
			//�����ϴ��ļ�����ʱ�ļ��е�����·��
			String uploadPath = context.getRealPath("/temp");
			
			//�����ļ�����
			File file = new File(uploadPath + File.separator + fullName);
			
			Pic pic = new Pic(eqtName,"װ��",(int)fileSize,is,new Date());
			
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
