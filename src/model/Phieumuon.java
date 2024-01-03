package model;

import java.sql.Date;

public class Phieumuon {
	public String sopm;
	public String manm;
	public Date ngaymuon;
	public int soluongmuon;
	public String matb;
	public String dvt;
	public int soluong;
	public Phieumuon(String sopm, String manm, Date ngaymuon, int soluongmuon, String matb,String dvt, int soluong) {
		
		this.sopm = sopm;
		this.manm = manm;
		this.ngaymuon = ngaymuon;
		this.soluongmuon = soluongmuon;
		this.matb = matb;
		this.dvt = dvt;
		this.soluong = soluong;
	}
	public Phieumuon() {
	
	}
	public String getSopm() {
		return sopm;
	}
	public void setSopm(String sopm) {
		this.sopm = sopm;
	}
	public String getManm() {
		return manm;
	}
	public void setManm(String manm) {
		this.manm = manm;
	}
	public Date getNgaymuon() {
		return ngaymuon;
	}
	public void setNgaymuon(Date ngaymuon) {
		this.ngaymuon = ngaymuon;
	}
	public int getSoluongmuon() {
		return soluongmuon;
	}
	public void setSoluongmuon(int soluongmuon) {
		this.soluongmuon = soluongmuon;
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