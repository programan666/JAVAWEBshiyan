package pic.servlet;

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
import pic.dao.PicDao;
import pic.pojo.Pic;


@WebServlet("/updatePicServlet")
public class updatePicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// ��Ӧ�����
		OutputStream out = response.getOutputStream();
		PicDao picdao = DAOFactory.instance().getPicDao();
		
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
			
			//���ͼƬid
			String picIdd = list.get(0).getString();
			int picId = Integer.parseInt(picIdd);
	/*		System.out.println("eqtPicId=" + eqtPicId);*/
			
			//����ļ�����
			FileItem item = list.get(1);
			
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
			
			Pic oldPic = picdao.queryById(picId);
			
			Pic pic = new Pic(oldPic.getPicId(),oldPic.getPicName(),oldPic.getInfo(),(int)fileSize,is,new Date());
			
			picdao.update(pic);
			
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
