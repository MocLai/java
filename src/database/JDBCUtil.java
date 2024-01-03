package database;

import java.sql.*;
public class JDBCUtil {
		public static Connection getConnection() {
			Connection c =  null;	
			try {
				// Đăng kí MySQL Driver với DriverManager
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				String url = "jdbc:mySQL://localhost:3306/thietbi";
				String username ="root";
				String password = "";
				// Tạo kết nối
				c = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return c;
		}
		public static void closeConnection(Connection c) {
			try {
				if(c!=null) {
					c.close();	
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}



