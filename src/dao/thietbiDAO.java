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

public class thietbiDAO {
	private List<Thietbi> thietbis;
	public List<Thietbi> getAllThietbis(){
		thietbis = new ArrayList<Thietbi>();
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
				thietbi.setLoaitb(rs.getString("loaitb"));
				thietbi.setTrangthai(rs.getString("trangthai"));
				thietbis.add(thietbi);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return thietbis;
	}
	public void addThietbi(Thietbi thietbi) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "INSERT INTO thietbi(matb, tentb, dvt, soluong, trangthai) VALUE(?,?,?,?,?)";
		try { 
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, thietbi.getMatb());
			preparedStatement.setString(2, thietbi.getTentb());
			preparedStatement.setString(3, thietbi.getDvt());
			preparedStatement.setInt(4, thietbi.getSoluong());
			preparedStatement.setString(5, thietbi.getTrangthai());
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addLoaithietbi(Thietbi thietbi) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "UPDATE thietbi SET loaitb = ? where matb = ?";
		try { 
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, thietbi.getLoaitb());
			preparedStatement.setString(2, thietbi.getMatb());
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateThietbi(Thietbi thietbi) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "UPDATE thietbi SET tentb = ?,dvt = ?,soluong = ?,trangthai = ? where matb = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, thietbi.getTentb());
			preparedStatement.setString(2, thietbi.getDvt());
			preparedStatement.setInt(3, thietbi.getSoluong());
			preparedStatement.setString(4, thietbi.getTrangthai());
			preparedStatement.setString(5, thietbi.getMatb());
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteThietbi(String matb) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "DELETE FROM thietbi where matb = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, matb);
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Thietbi getThietbiBymatb(String matb){
		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT * FROM thietbi WHERE matb = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, matb);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Thietbi thietbi = new Thietbi();
				thietbi.setMatb(rs.getString("matb")); 
				thietbi.setTentb(rs.getString("tentb"));
				thietbi.setDvt(rs.getString("dvt"));
				thietbi.setSoluong(rs.getInt("soluong"));
				thietbi.setTrangthai(rs.getString("trangthai"));
				return thietbi;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Thietbi> TimKiem(String matb){
		Connection connection = JDBCUtil.getConnection();
		String sql = "SeLECT * FROM thietbi where matb = ?";
		try {
			thietbis.clear();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, matb);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Thietbi thietbi = new Thietbi();
				thietbi.setMatb(rs.getString("matb"));
				thietbi.setTentb(rs.getString("tentb"));
				thietbi.setLoaitb(rs.getString("loaitb"));
				thietbi.setDvt(rs.getString("dvt"));
				thietbi.setSoluong(rs.getInt("soluong"));
				thietbi.setTrangthai(rs.getString("trangthai"));
				thietbis.add(thietbi);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thietbis;
	}public List<Thietbi> getThietbiChuatras(String manm){
		List<Thietbi> thietbichuatras = new ArrayList<Thietbi>();
		Connection connection = JDBCUtil.getConnection();
		String sql = "SeLECT * FROM phieumuon where manm = ?";
		String sql1 = "SeLECT * FROM chitietphieumuon where sopm = ?";
	
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, manm);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Thietbi thietbi = new Thietbi();
				Phieumuon phieumuon = new Phieumuon();
				phieumuon.setSopm(rs.getString("sopm"));
				PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
				preparedStatement1.setString(1, phieumuon.getSopm());
				ResultSet rs1 = preparedStatement1.executeQuery();
				while(rs1.next()) {
		            thietbi.setMatb(rs1.getString("matb"));
		            getThietbiBymatb(thietbi.getMatb());
		            thietbi.setTentb(thietbi.getMatb());
		            thietbi.setNgaymuon(rs.getDate("ngaymuon"));
		            thietbi.setSoluongmuon(rs.getInt("soluongmuon"));
		            thietbichuatras.add(thietbi);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thietbichuatras;
	}
	public void updatesoluongthietbi(String matb, int soluong) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		String sql = "UPDATE thietbi SET soluong = ? where matb = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, soluong);
			preparedStatement.setString(2, matb);
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
