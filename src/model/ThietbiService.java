package model;
import java.util.List;
import dao.thietbiDAO;

public class ThietbiService {
	private thietbiDAO thietbidao;
	public ThietbiService(dao.thietbiDAO thietbiDAO) {
	
		thietbidao = new thietbiDAO();
	}
	public ThietbiService() {
		// TODO Auto-generated constructor stub 
	}
	public List<Thietbi> getAllThietbis(){
		
		return thietbidao.getAllThietbis();
	}
	public void addThietbi(Thietbi thietbi) {
		thietbidao.addThietbi(thietbi);
	}
	public void deleteThietbi(String matb) {
		thietbidao.deleteThietbi(matb);
	}
	public Thietbi getThietbiBymatb(String matb) {
		
		return thietbidao.getThietbiBymatb(matb);
	}
	public void updateThietbi(Thietbi thietbi) {
		thietbidao.updateThietbi(thietbi);
	}
	public List<Thietbi> TimKiem(String matb){
		return thietbidao.TimKiem(matb);
	}
	public void addloaithietbi(Thietbi thietbi) {
		thietbidao.addLoaithietbi(thietbi);
	}
	public List<Thietbi> getThietbiChuatras(String manm){
		return thietbidao.getThietbiChuatras(manm);
	}
	public void updatesoluongthietbi(String matb,int soluong) {
		thietbidao.updatesoluongthietbi(matb,soluong);
	}
}
