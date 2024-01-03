package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.JDBCUtil;
import model.Phieumuon;
import model.Thietbi;

public class taophieunguoimuonDAO {
	public List<Phieumuon> phieumuons;
	public List<Phieumuon> getSopmBySopm(){
		phieumuons = new ArrayList<Phieumuon>();
		Connection connection = JDBCUtil.getConnection();
		String sql = "SeLECT * FROM phieumuon";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Phieumuon phieumuon = new Phieumuon();
				phieumuon.setSopm(rs.getString("sopm"));
				phieumuons.add(phieumuon);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phieumuons;
	}
	public List<Thietbi> getAllThietbis(){
		List<Thietbi> thietbis = new ArrayList<Thietbi>();
		Connection connection = JDBCUtil.getConnection();
		String sql = "SeLECT * FROM thietbi";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Thietbi thietbi = new Thietbi();
				thietbi.setMatb(rs.getString("matb"));
				thietbi.setTentb(rs.getString("tentb"));
				thietbi.setDvt(rs.getString("dvt"));
				thietbi.setSoluong(rs.getInt("soluong"));
				thietbis.add(thietbi);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thietbis;
	}
	public void addPhieumuon(Phieumuon phieumuon) {
	    Connection connection = JDBCUtil.getConnection();
	    String sql1 = "INSERT INTO phieumuon(sopm, ngaymuon, soluongmuon, manm) VALUES (?, ?, ?, ?)";
	    String sql2 = "INSERT INTO chitietphieumuon(sopm, matb, dvt, soluong) VALUES (?, ?, ?, ?)";
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
	        preparedStatement.setString(1, phieumuon.getSopm());
	        preparedStatement.setDate(2, phieumuon.getNgaymuon());
	        preparedStatement.setInt(3, phieumuon.getSoluongmuon());        
	        preparedStatement.setString(4, phieumuon.getManm());
	        int rs1 = preparedStatement.executeUpdate();
	        System.out.println(rs1);
	        
	        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
	        preparedStatement2.setString(1, phieumuon.getSopm());
	        preparedStatement2.setString(2, phieumuon.getMatb());
	        preparedStatement2.setString(3, phieumuon.getDvt());      
	        preparedStatement2.setInt(4, phieumuon.getSoluong());
	        int rs2 = preparedStatement2.executeUpdate();
	        System.out.println(rs2);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public Phieumuon getPhieumuonBySopm(String matb) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT * FROM chitietphieumuon WHERE matb = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, matb);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Phieumuon phieumuon = new Phieumuon();
				phieumuon.setSoluong(rs.getInt("soluong"));
				return phieumuon;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
