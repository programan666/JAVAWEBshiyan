package rol.pojo;

import eqt.pojo.Eqt;
import ocp.pojo.Ocp;
import pic.pojo.Pic;
import reg.pojo.Reg;

public class Rol {
	private int rolId;
	private String rolName;
	private String rolLoginName;
	private String rolPwd;
	private String rolEmail;
	private String rolMood;
	private Pic pic;
	private Reg reg;
	private Ocp ocp;
	private int rolPower;
	private Eqt eqt;
	
	
	
	
	public Rol() {
		super();
	}




	public Rol(int rolId) {
		super();
		this.rolId = rolId;
	}

	


	public Rol(int rolId, String rolName, String rolLoginName, String rolPwd, String rolEmail, String rolMood, Pic pic,
			Reg reg, Ocp ocp, int rolPower) {
		super();
		this.rolId = rolId;
		this.rolName = rolName;
		this.rolLoginName = rolLoginName;
		this.rolPwd = rolPwd;
		this.rolEmail = rolEmail;
		this.rolMood = rolMood;
		this.pic = pic;
		this.reg = reg;
		this.ocp = ocp;
		this.rolPower = rolPower;
	}




	public Rol(String rolName, String rolLoginName, String rolPwd, String rolEmail, String rolMood, Pic pic, Reg reg,
			Ocp ocp, int rolPower, Eqt eqt) {
		super();
		this.rolName = rolName;
		this.rolLoginName = rolLoginName;
		this.rolPwd = rolPwd;
		this.rolEmail = rolEmail;
		this.rolMood = rolMood;
		this.pic = pic;
		this.reg = reg;
		this.ocp = ocp;
		this.rolPower = rolPower;
		this.eqt = eqt;
	}




	public Rol(int rolId, String rolName, String rolLoginName, String rolPwd, String rolEmail, String rolMood, Pic pic,
			Reg reg, Ocp ocp, int rolPower, Eqt eqt) {
		super();
		this.rolId = rolId;
		this.rolName = rolName;
		this.rolLoginName = rolLoginName;
		this.rolPwd = rolPwd;
		this.rolEmail = rolEmail;
		this.rolMood = rolMood;
		this.pic = pic;
		this.reg = reg;
		this.ocp = ocp;
		this.rolPower = rolPower;
		this.eqt = eqt;
	}




	public int getRolId() {
		return rolId;
	}




	public void setRolId(int rolId) {
		this.rolId = rolId;
	}




	public String getRolName() {
		return rolName;
	}




	public void setRolName(String rolName) {
		this.rolName = rolName;
	}




	public String getRolLoginName() {
		return rolLoginName;
	}




	public void setRolLoginName(String rolLoginName) {
		this.rolLoginName = rolLoginName;
	}




	public String getRolPwd() {
		return rolPwd;
	}




	public void setRolPwd(String rolPwd) {
		this.rolPwd = rolPwd;
	}




	public String getRolEmail() {
		return rolEmail;
	}




	public void setRolEmail(String rolEmail) {
		this.rolEmail = rolEmail;
	}




	public String getRolMood() {
		return rolMood;
	}




	public void setRolMood(String rolMood) {
		this.rolMood = rolMood;
	}




	public Pic getPic() {
		return pic;
	}




	public void setPic(Pic pic) {
		this.pic = pic;
	}




	public Reg getReg() {
		return reg;
	}




	public void setReg(Reg reg) {
		this.reg = reg;
	}




	public Ocp getOcp() {
		return ocp;
	}




	public void setOcp(Ocp ocp) {
		this.ocp = ocp;
	}




	public int getRolPower() {
		return rolPower;
	}




	public void setRolPower(int rolPower) {
		this.rolPower = rolPower;
	}




	public Eqt getEqt() {
		return eqt;
	}




	public void setEqt(Eqt eqt) {
		this.eqt = eqt;
	}




	@Override
	public String toString() {
		return "Rol [rolId=" + rolId + ", rolName=" + rolName + ", rolLoginName=" + rolLoginName + ", rolPwd=" + rolPwd
				+ ", rolEmail=" + rolEmail + ", rolMood=" + rolMood + ", pic=" + pic + ", reg=" + reg + ", ocp=" + ocp
				+ ", rolPower=" + rolPower + ", eqt=" + eqt + "]";
	}
	
	
	
	
}
