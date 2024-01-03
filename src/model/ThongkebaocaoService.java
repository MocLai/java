package model;

import java.util.List;

import dao.thongkeDAO;

public class ThongkebaocaoService {
	private thongkeDAO thongkedao;

	public ThongkebaocaoService(thongkeDAO thongkedao) {
		this.thongkedao = thongkedao;
	}
	public ThongkebaocaoService() {
		thongkedao = new thongkeDAO();
	}
	public List<Thongkebaocao> getAllThongkes(){
		return thongkedao.getAllThongkes();
	}
}
