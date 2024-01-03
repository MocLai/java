package model;

import java.sql.Date;

public class Phieutra {
	public String sopt;
	public Date ngaytra;
	public int soluongtra;
	public String manm;
	public String matb;
	public String dvt;
	public int soluong;
	public Phieutra(String sopt, Date ngaytra, int soluongtra, String manm, String matb, String dvt,
			int soluong) {

		this.sopt = sopt;
		this.ngaytra = ngaytra;
		this.soluongtra = soluongtra;
		this.manm = manm;
		this.matb = matb;
		this.dvt = dvt;
		this.soluong = soluong;
	}
	public Phieutra() {

	}
	public String getSopt() {
		return sopt;
	}
	public void setSopt(String sopt) {
		this.sopt = sopt;
	}
	public Date getNgaytra() {
		return ngaytra;
	}
	public void setNgaytra(Date ngaytra) {
		this.ngaytra = ngaytra;
	}
	public int getSoluongtra() {
		return soluongtra;
	}
	public void setSoluongtra(int soluongtra) {
		this.soluongtra = soluongtra;
	}
	public String getManm() {
		return manm;
	}
	public void setManm(String manm) {
		this.manm = manm;
	}
	public String getMatb() {
		return matb;
	}
	public void setMatb(String matb) {
		this.matb = matb;
	}
	public String getDvt() {
		return dvt;
	}
	public void setDvt(String dvt) {
		this.dvt = dvt;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
}