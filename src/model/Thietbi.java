package model;

import java.sql.Date;

public class Thietbi {
	public String matb;
	private String tentb;
	private String dvt;
	private int soluong;
	private String trangthai;
	private String loaitb;
	private Date ngaymuon;
	private int soluongmuon;
	public Thietbi(String matb, String tentb,String loaitb, String dvt, int soluong, String trangthai, Date ngaymuon, int soluongmuon) {
		this.matb = matb;
		this.tentb = tentb;
		this.loaitb = loaitb;
		this.dvt = dvt;
		this.soluong = soluong;
		this.trangthai = trangthai;
		this.ngaymuon = ngaymuon;
		this.soluongmuon = soluongmuon;
	}
	public Thietbi() {

	}
	public String getMatb() {
		return matb;
	}
	public void setMatb(String matb) {
		this.matb = matb;
	}
	public String getTentb() {
		return tentb;
	}
	public void setTentb(String tentb) {
		this.tentb = tentb;
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
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getLoaitb() {
		return loaitb;
	}
	public void setLoaitb(String loaitb) {
		this.loaitb = loaitb;
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
	
}
