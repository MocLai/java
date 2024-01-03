package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.JDBCUtil;
import model.Nguoimuon;
public class nguoimuonDAO {
	public List<Nguoimuon> nguoimuons;
	public List<Nguoimuon> getAllNguoimuons(){
		nguoimuons = new ArrayList<Nguoimuon>();
		Connection connection = JDBCUtil.getConnection();
		String sql = "SeLECT * FROM nguoimuon";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Nguoimuon nguoimuon = new Nguoimuon();
				nguoimuon.setManm(rs.getString("manm"));
				nguoimuon.setTennm(rs.getString("tennm"));
				nguoimuon.setDiachi(rs.getString("diachi"));
				nguoimuon.setSdt(rs.getString("sdt"));
				nguoimuons.add(nguoimuon);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nguoimuons;
	}
	public void addNguoimuon(Nguoimuon nguoimuon) {
		Connection connection = JDBCUtil.getConnection();
		
		try {
			String sql = "INSERT INTO nguoimuon(manm, tennm, diachi, sdt) VALUE(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nguoimuon.getManm());
			preparedStatement.setString(2, nguoimuon.getTennm());
			preparedStatement.setString(3, nguoimuon.getDiachi());		
			preparedStatement.setString(4, nguoimuon.getSdt());
			
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateNguoimuon(Nguoimuon nguoimuon) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "UPDATE nguoimuon SET tennm = ?,diachi = ?,sdt = ? Where manm=? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nguoimuon.getTennm());
			preparedStatement.setString(2, nguoimuon.getDiachi());
			preparedStatement.setString(3, nguoimuon.getSdt());
			preparedStatement.setString(4, nguoimuon.getManm());
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteNguoimuon(String manm) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "DELETE FROM nguoimuon where manm = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, manm);
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Nguoimuon getNguoimuonBymanm(String manm){
		Connection connection = JDBCUtil.getConnection();
		String sql = "SELECT * FROM nguoimuon WHERE manm = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, manm);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Nguoimuon nguoimuon = new Nguoimuon();
				nguoimuon.setManm(rs.getString("manm"));
				nguoimuon.setTennm(rs.getString("tennm"));
				nguoimuon.setDiachi(rs.getString("diachi"));
				nguoimuon.setSdt(rs.getString("sdt"));
				return nguoimuon;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Nguoimuon> TimKiem(String manm){
		Connection connection = JDBCUtil.getConnection();
		String sql = "SeLECT * FROM nguoimuon where manm = ?";
		try {
			nguoimuons.clear();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, manm);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Nguoimuon nguoimuon = new Nguoimuon();
				nguoimuon.setManm(rs.getString("manm"));
				nguoimuon.setTennm(rs.getString("tennm"));
				nguoimuon.setDiachi(rs.getString("diachi"));
				nguoimuon.setSdt(rs.getString("sdt"));
				nguoimuons.add(nguoimuon);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nguoimuons;
	}
}

