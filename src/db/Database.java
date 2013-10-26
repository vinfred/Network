package db;

import java.sql.*;

public class Database {
	 
		private Connection conn = null;
	 
		public Database(String url, String user_name, String password) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
	 
				this.conn = DriverManager.getConnection(url, user_name, password);
	 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	 
		public Connection getConnection() {
			return this.conn;
		}
	 
		public ResultSet querySql(String sql) throws SQLException {
			Statement sta = conn.createStatement();
			return sta.executeQuery(sql);
		}
		
		public void updateSql(String sql) throws SQLException {
			Statement sta = conn.createStatement();
			sta.executeUpdate(sql);
		}
		
		
}
