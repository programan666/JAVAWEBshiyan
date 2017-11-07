package mng.pojo;

public class Mng {
	private int mngId;
	private String mngLoginName;
	private String mngPwd;

	public Mng() {
		super();
	}
	public Mng(String mngLoginName, String mngPwd) {
		super();
		this.mngLoginName = mngLoginName;
		this.mngPwd = mngPwd;
	}
	public Mng(int mngId, String mngLoginName, String mngPwd) {
		super();
		this.mngId = mngId;
		this.mngLoginName = mngLoginName;
		this.mngPwd = mngPwd;
	}
	public int getMngId() {
		return mngId;
	}
	public void setMngId(int mngId) {
		this.mngId = mngId;
	}
	public String getMngLoginName() {
		return mngLoginName;
	}
	public void setMngLoginName(String mngLoginName) {
		this.mngLoginName = mngLoginName;
	}
	public String getMngPwd() {
		return mngPwd;
	}
	public void setMngPwd(String mngPwd) {
		this.mngPwd = mngPwd;
	}
	@Override
	public String toString() {
		return "Mng [mngId=" + mngId + ", mngLoginName=" + mngLoginName + ", mngPwd=" + mngPwd + "]";
	}
	
	
	
}
