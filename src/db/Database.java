package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection conn = null;

	public Database(String url, String user, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			this.conn = DriverManager.getConnection(url, user, password);

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
		Statement sta = this.conn.createStatement();
		return sta.executeQuery(sql);
	}

	public void updateSql(String sql) throws SQLException {
		Statement sta = this.conn.createStatement();
		sta.executeUpdate(sql);
	}


}
