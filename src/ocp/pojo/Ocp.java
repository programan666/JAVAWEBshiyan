package ocp.pojo;

import pic.pojo.Pic;

public class Ocp {
	private int ocpId;
	private String ocpName;
	private Pic pic;
	private String ocpAttribute;
	
	
	public Ocp() {
		super();
	}
	
	public Ocp(String ocpName, Pic pic, String ocpAttribute) {
		super();
		this.ocpName = ocpName;
		this.pic = pic;
		this.ocpAttribute = ocpAttribute;
	}

	public Ocp(int ocpId, String ocpName, Pic pic, String ocpAttribute) {
		super();
		this.ocpId = ocpId;
		this.ocpName = ocpName;
		this.pic = pic;
		this.ocpAttribute = ocpAttribute;
	}

	public int getOcpId() {
		return ocpId;
	}
	public void setOcpId(int ocpId) {
		this.ocpId = ocpId;
	}
	public String getOcpName() {
		return ocpName;
	}
	public void setOcpName(String ocpName) {
		this.ocpName = ocpName;
	}
	public Pic getPic() {
		return pic;
	}
	public void setPic(Pic pic) {
		this.pic = pic;
	}
	public String getOcpAttribute() {
		return ocpAttribute;
	}
	public void setOcpAttribute(String ocpAttribute) {
		this.ocpAttribute = ocpAttribute;
	}
	@Override
	public String toString() {
		return "Ocp [ocpId=" + ocpId + ", ocpName=" + ocpName + ", pic=" + pic + ", ocpAttribute=" + ocpAttribute + "]";
	}
	
	
}
