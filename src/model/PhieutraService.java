package model;
import java.util.List;

import dao.taophieutraDAO;
public class PhieutraService {
	private taophieutraDAO phieutradao;
	
	public PhieutraService(dao.taophieutraDAO taophieutraDAO) {
		phieutradao = new taophieutraDAO();
	}
	public PhieutraService() {
	}
	public void addPhieutra(Phieutra phieutra) {
		
		phieutradao.addPhieutra(phieutra);
	}public List<Phieutra> getSoptBySopt(){
		return phieutradao.getSoptBySopt();
	}
}
