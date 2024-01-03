package model;

import java.util.List;

import dao.taophieunguoimuonDAO;
public class PhieumuonService {
	private taophieunguoimuonDAO phieumuondao;
	public PhieumuonService(dao.taophieunguoimuonDAO taophieunguoimuonDAO) {
		phieumuondao = new taophieunguoimuonDAO();
	}
	public PhieumuonService() {
	
	}
	public void addPhieumuon(Phieumuon phieumuon) {
		phieumuondao.addPhieumuon(phieumuon);
	}public Phieumuon getPhieumuonBySopm(String sopm) {
		return phieumuondao.getPhieumuonBySopm(sopm);
	}public List<Phieumuon> getSopmBySopm(){
		
		return phieumuondao.getSopmBySopm();
	}
}
