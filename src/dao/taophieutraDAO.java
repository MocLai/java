package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.JDBCUtil;
import model.Phieutra;
import model.Thietbi;

public class taophieutraDAO {
	public List<Phieutra> phieutras;
	public List<Phieutra> getSoptBySopt(){
		phieutras = new ArrayList<Phieutra>();
		Connection connection = JDBCUtil.getConnection();
		String sql = "SeLECT * FROM Phieutra";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Phieutra phieutra = new Phieutra();
				phieutra.setSopt(rs.getString("sopt"));
				phieutras.add(phieutra);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phieutras;
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
	}public void addPhieutra(Phieutra phieutra) {
	    Connection connection = JDBCUtil.getConnection();
	    String sql1 = "INSERT INTO phieutra(sopt, ngaytra, soluongtra, manm) VALUES (?, ?, ?, ?)";
	    String sql2 = "INSERT INTO chitietphieutra(sopt, matb, dvt, soluong) VALUES (?, ?, ?, ?)";
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
	        preparedStatement.setString(1, phieutra.getSopt());
	        preparedStatement.setDate(2, phieutra.getNgaytra());
	        preparedStatement.setInt(3, phieutra.getSoluongtra());        
	        preparedStatement.setString(4, phieutra.getManm());
	        int rs1 = preparedStatement.executeUpdate();
	        System.out.println(rs1);
	        
	        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
	        preparedStatement2.setString(1, phieutra.getSopt());
	        preparedStatement2.setString(2, phieutra.getMatb());
	        preparedStatement2.setString(3, phieutra.getDvt());      
	        preparedStatement2.setInt(4, phieutra.getSoluong());
	        int rs2 = preparedStatement2.executeUpdate();
	        System.out.println(rs2);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
}
