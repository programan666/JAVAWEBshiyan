package ocp.servlet;

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
import eqt.pojo.Eqt;
import ocp.dao.OcpDao;
import ocp.pojo.Ocp;
import pic.dao.PicDao;
import pic.pojo.Pic;

@WebServlet("/addOcpServlet")
public class addOcpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// ��Ӧ�����
		OutputStream out = response.getOutputStream();
		PicDao picdao = DAOFactory.instance().getPicDao();
		OcpDao ocpdao = DAOFactory.instance().getOcpDao();
		
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
			String ocpName = list.get(0).getString();
			ocpName = new String(ocpName.getBytes("iso-8859-1"),"utf-8");

			String addOcpAttribute = list.get(1).getString();
			addOcpAttribute = new String(addOcpAttribute.getBytes("iso-8859-1"),"utf-8");

			//����ļ�����
			FileItem item = list.get(2);
			
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
			
			Pic pic = new Pic(ocpName,"ְҵ",(int)fileSize,is,new Date());
			
			picdao.insert(pic);
			
			Ocp ocp = new Ocp(ocpName,picdao.queryById(picdao.queryByName(ocpName)),addOcpAttribute);
			ocpdao.insert(ocp);
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
