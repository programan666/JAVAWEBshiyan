package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import commen.DAOFactory;
import pic.dao.PicDao;
import pic.pojo.Pic;

public class TestPicDao {
	PicDao dao = DAOFactory.instance().getPicDao();
	
	@Test
	public void testInsert() throws SQLException, FileNotFoundException{
		File file = new File("C:\\Users\\Administrator\\Desktop\\ËØ²Ä\\touxiang.png");
		int fileSize = (int)file.length();
		FileInputStream fis = new FileInputStream(file);
		Pic pic = new Pic("touxiangmodel.png","Í·Ïñ",fileSize,fis,new Date());
		dao.insert(pic);
	}
	
	@Test
	public void testQueryById() throws SQLException, FileNotFoundException,IOException{
		Pic pic = dao.queryById(23);
		System.out.println(pic);
		InputStream is = pic.getPicData();
		FileOutputStream fos = new FileOutputStream("F:\\linshi\\zhss.png");
		byte[] b = new byte[1024*8];
		int len = is.read(b);
		while(len != -1){
			fos.write(b,0,len);
			len = is.read(b);
		}
		fos.close();
		is.close();
	}
	
	@Test
	public void updatePic() throws FileNotFoundException, SQLException{
		File file = new File("C:\\Users\\Administrator\\Desktop\\ËØ²Ä\\touxiang.png");
		int fileSize = (int)file.length();
		System.out.println(file);
		FileInputStream fis = new FileInputStream(file);
		Pic pic = new Pic(86,"touxiangmodel.png","Í·Ïñ",fileSize,fis,new Date());
		dao.update(pic);
	}
}
