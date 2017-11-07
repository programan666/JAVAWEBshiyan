package pic.pojo;

import java.io.InputStream;
import java.util.Date;

public class Pic {
	private int picId;
	private String picName;
	private String info;
	private int picSize;
	private InputStream picData;
	private Date picDatetime;
	
	public Pic() {
		super();
	}
	
	public Pic(int picId) {
		super();
		this.picId = picId;
	}

	public Pic(int picId, String picName, String info, InputStream picData) {
		super();
		this.picId = picId;
		this.picName = picName;
		this.info = info;
		this.picData = picData;
	}

	public Pic(int picId, String picName, String info, int picSize, Date picDatetime) {
		super();
		this.picId = picId;
		this.picName = picName;
		this.info = info;
		this.picSize = picSize;
		this.picDatetime = picDatetime;
	}

	public Pic(String picName, String info, int picSize, InputStream picData, Date picDatetime) {
		super();
		this.picName = picName;
		this.info = info;
		this.picSize = picSize;
		this.picData = picData;
		this.picDatetime = picDatetime;
	}

	public Pic(String picName, String info, InputStream picData) {
		super();
		this.picName = picName;
		this.info = info;
		this.picData = picData;
	}

	public Pic(String picName, InputStream picData) {
		super();
		this.picName = picName;
		this.picData = picData;
	}

	public Pic(int picId, String picName, String info, int picSize, InputStream picData, Date picDatetime) {
		super();
		this.picId = picId;
		this.picName = picName;
		this.info = info;
		this.picSize = picSize;
		this.picData = picData;
		this.picDatetime = picDatetime;
	}

	public int getPicId() {
		return picId;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPicSize() {
		return picSize;
	}
	public void setPicSize(int picSize) {
		this.picSize = picSize;
	}
	public InputStream getPicData() {
		return picData;
	}
	public void setPicData(InputStream picData) {
		this.picData = picData;
	}
	public Date getPicDatetime() {
		return picDatetime;
	}
	public void setPicDatetime(Date picDatetime) {
		this.picDatetime = picDatetime;
	}

	@Override
	public String toString() {
		return "Pic [picId=" + picId + ", picName=" + picName + ", info=" + info + ", picSize=" + picSize + ", picData="
				+ picData + ", picDatetime=" + picDatetime + "]";
	}
	
}
