package model;
public class Nguoimuon {
	public String manm;
	public String tennm;
	public String diachi;
	public String sdt;
	public Nguoimuon(String manm, String tennm, String diachi, String sdt) {
		this.manm = manm;
		this.tennm = tennm;
		this.diachi = diachi;
		this.sdt = sdt;
	}
	public Nguoimuon() {
		super();
	}
	public String getManm() {
		return manm;
	}
	public void setManm(String manm) {
		this.manm = manm;
	}
	public String getTennm() {
		return tennm;
	}
	public void setTennm(String tennm) {
		this.tennm = tennm;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	 
	
	
}
