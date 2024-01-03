package model;

import java.sql.Date;
 
public class Thongkebaocao {
	public String matb;
	public String tentb;
	public Date ngaymuon;
	public Date ngaytra;
	public String soluong;
	public String manm;
	public String trangthai;

	public Thongkebaocao(String matb, String tentb, Date ngaymuon, Date ngaytra, String soluong, String manm,
			String trangthai) {
		this.matb = matb;
		this.tentb = tentb;
		this.ngaymuon = ngaymuon;
		this.ngaytra = ngaytra;
		this.soluong = soluong;
		this.manm = manm;
		this.trangthai = trangthai;
	}
	public Thongkebaocao() {
		
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
	public Date getNgaymuon() {
		return ngaymuon;
	}
	public void setNgaymuon(Date ngaymuon) {
		this.ngaymuon = ngaymuon;
	}
	public Date getNgaytra() {
		return ngaytra;
	}
	public void setNgaytra(Date ngaytra) {
		this.ngaytra = ngaytra;
	}
	public String getSoluong() {
		return soluong;
	}
	public void setSoluong(String soluong) {
		this.soluong = soluong;
	}
	public String getManm() {
		return manm;
	}
	public void setManm(String manm) {
		this.manm = manm;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	
}
