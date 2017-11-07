package reg.pojo;
// µÃÂ¿‡
public class Reg {
	private int regId;
	private String regName;	
	public Reg() {
		super();
	}
	public Reg(int regId, String regName) {
		super();
		this.regId = regId;
		this.regName = regName;
	}

	public Reg(String regName) {
		super();
		this.regName = regName;
	}
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String toString() {
		return "Reg [regId=" + regId + ", regName=" + regName + "]";
	}
	
	
}
