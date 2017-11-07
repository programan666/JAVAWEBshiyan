package pic.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import commen.DAOFactory;
import pic.dao.PicDao;
import pic.pojo.Pic;


public class ImagesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 响应输出流
		OutputStream out = response.getOutputStream();
		PicDao picdao = DAOFactory.instance().getPicDao();

		int option = Integer.parseInt(request.getParameter("option"));
		int picId = Integer.parseInt(request.getParameter("picId"));
		
		//自身操作
		String mBlock = "style='display:block'";
		String mNone = "style='display:none'";
		
		switch(option){
		case 1:
			try {
					Pic pic = picdao.queryById(picId);
					InputStream fis = pic.getPicData();
					byte[] b = new byte[1024*8];
					int len = fis.read(b);
					while(len != -1){
						out.write(b,0,len);
						len = fis.read(b);
					}
					out.flush();
					fis.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			/*FileItem item = request.getParameter("imgFile");*/
			break;
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
