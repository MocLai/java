 package model;

import java.util.List;
import dao.*;
public class NguoimuonService {
	private nguoimuonDAO nguoimuondao;
	public NguoimuonService(dao.nguoimuonDAO nguoimuonDAO) {
	
		nguoimuondao = new nguoimuonDAO();
	}
	public NguoimuonService() {
		// TODO Auto-generated constructor stub
	}
	public List<Nguoimuon> getAllNguoimuons(){
		
		return nguoimuondao.getAllNguoimuons();
	}
	public List<Nguoimuon> TimKiem(String manm){
		
		return nguoimuondao.TimKiem(manm);
	} 
	public void addNguoimuon(Nguoimuon nguoimuon) {
		nguoimuondao.addNguoimuon(nguoimuon);
	}
	public void deleteNguoimuon(String manm) {
		nguoimuondao.deleteNguoimuon(manm);
	}
	public Nguoimuon getNguoimuonBymanm(String matb) {
		return nguoimuondao.getNguoimuonBymanm(matb);
	}
	public void updateNguoimuon(Nguoimuon nguoimuon) {
		nguoimuondao.updateNguoimuon(nguoimuon);
	}
} 
