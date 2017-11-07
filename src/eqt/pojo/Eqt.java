package eqt.pojo;

import pic.pojo.Pic;

public class Eqt {
	private int eqtId;
	private String eqtName;
	private int eqtLevel;
	private String eqtAttribute;
	private Pic pic;
	private int eqtPower;
	private String eqtType;
	private String eqtQuality;
	
	
	public Eqt() {
		super();
	}
	public Eqt(String eqtName, int eqtLevel, String eqtAttribute, Pic pic, int eqtPower, String eqtType,
			String eqtQuality) {
		super();
		this.eqtName = eqtName;
		this.eqtLevel = eqtLevel;
		this.eqtAttribute = eqtAttribute;
		this.pic = pic;
		this.eqtPower = eqtPower;
		this.eqtType = eqtType;
		this.eqtQuality = eqtQuality;
	}
	
	public Eqt(String eqtName, int eqtLevel, String eqtAttribute, int eqtPower, String eqtType, String eqtQuality) {
		super();
		this.eqtName = eqtName;
		this.eqtLevel = eqtLevel;
		this.eqtAttribute = eqtAttribute;
		this.eqtPower = eqtPower;
		this.eqtType = eqtType;
		this.eqtQuality = eqtQuality;
	}
	public Eqt(int eqtId, String eqtName, int eqtLevel, String eqtAttribute, Pic pic, int eqtPower, String eqtType,
			String eqtQuality) {
		super();
		this.eqtId = eqtId;
		this.eqtName = eqtName;
		this.eqtLevel = eqtLevel;
		this.eqtAttribute = eqtAttribute;
		this.pic = pic;
		this.eqtPower = eqtPower;
		this.eqtType = eqtType;
		this.eqtQuality = eqtQuality;
	}

	public int getEqtId() {
		return eqtId;
	}
	public void setEqtId(int eqtId) {
		this.eqtId = eqtId;
	}
	public String getEqtName() {
		return eqtName;
	}
	public void setEqtName(String eqtName) {
		this.eqtName = eqtName;
	}
	public int getEqtLevel() {
		return eqtLevel;
	}
	public void setEqtLevel(int eqtLevel) {
		this.eqtLevel = eqtLevel;
	}
	public String getEqtAttribute() {
		return eqtAttribute;
	}
	public void setEqtAttribute(String eqtAttribute) {
		this.eqtAttribute = eqtAttribute;
	}
	public Pic getPic() {
		return pic;
	}
	public void setPic(Pic pic) {
		this.pic = pic;
	}
	public int getEqtPower() {
		return eqtPower;
	}
	public void setEqtPower(int eqtPower) {
		this.eqtPower = eqtPower;
	}
	public String getEqtType() {
		return eqtType;
	}
	public void setEqtType(String eqtType) {
		this.eqtType = eqtType;
	}
	public String getEqtQuality() {
		return eqtQuality;
	}
	public void setEqtQuality(String eqtQuality) {
		this.eqtQuality = eqtQuality;
	}
	@Override
	public String toString() {
		return "Eqt [eqtId=" + eqtId + ", eqtName=" + eqtName + ", eqtLevel=" + eqtLevel + ", eqtAttribute="
				+ eqtAttribute + ", pic=" + pic + ", eqtPower=" + eqtPower + ", eqtType=" + eqtType + ", eqtQuality="
				+ eqtQuality + "]";
	}
	
}
