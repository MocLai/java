package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.JDBCUtil;
import model.Thongkebaocao;
public class thongkeDAO {
	public List<Thongkebaocao> thongkebaocaos;
	public List<Thongkebaocao> getAllThongkes(){
		thongkebaocaos = new ArrayList<Thongkebaocao>();
		Connection connection = JDBCUtil.getConnection();
		String sql1 = "SeLECT * FROM phieumuon";
		String sql2 = "SeLECT * FROM chitietphieumuon";
		try {
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			ResultSet rs1 = preparedStatement1.executeQuery();
			while(rs1.next()) {
				Thongkebaocao thongke = new Thongkebaocao();
				thongke.setNgaymuon(rs1.getDate("ngaymuon"));
				thongke.setManm(rs1.getString("manm"));
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				ResultSet rs2 = preparedStatement2.executeQuery();
				while(rs2.next()) {
					thongke.setMatb(rs2.getString("matb"));
					thongke.setSoluong(rs2.getString("soluong"));	
					String matb = thongke.getMatb();
					String sql3 = "SeLECT * FROM thietbi where matb = ?";
					PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
					preparedStatement3.setString(1, matb);
					ResultSet rs3 = preparedStatement3.executeQuery();
					while(rs3.next()) {
						thongke.setTentb(rs3.getString("tentb"));
						thongke.setTrangthai(rs3.getString("trangthai"));
						break;
					}
					}
				thongkebaocaos.add(thongke);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thongkebaocaos;
	}
	
}
