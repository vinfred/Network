package db;

import java.sql.*;
import java.util.*;
import mod.*;

public class BaseDao implements UserDao, GroupDao, MessDao {
	
	Connection connection=null;
	
	public BaseDao (Connection connection) {
		this.connection = connection;
	}

//
//	void openConnection() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("Driver loaded\n");
//			
//			connection = DriverManager.getConnection("jdbc:mysql://localhost/ee_network", "mirka", "booboo");
//			System.out.println("DB loaded\n");
//		} 
//		
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}		
//	}
	
	
	void createUserTable() {
		//openConnection();	
		
		String query = "CREATE TABLE IF NOT EXISTS User (id INT NOT NULL PRIMARY KEY,"
				+ "name VARCHAR(50) NOT NULL, surname VARCHAR(50) NOT NULL );";

		try {
			Statement stat = connection.createStatement();
			stat.executeUpdate(query);
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public Message createMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message findMessageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message updateMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public Group createGroup(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group findGroupById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group updateGroup(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGroup(Group group) {
		// TODO Auto-generated method stub

	}

	@Override
	public User createUser(User user) {
		int id=0;
		
		createUserTable();
		//openConnection();
		String query = "INSERT INTO User (id, name, surname ) VALUES (?, ?, ?);";
		String idQuery = "SELECT max(id) FROM User";

		try (PreparedStatement stat = connection.prepareStatement(query);) {
			Statement stat1 = connection.createStatement();
			ResultSet res = stat1.executeQuery(idQuery);
			
			if (res.next()) {
				id=1+res.getInt(1);
			}
			
			stat.setInt(1, id);
			stat.setString(2, user.getName());
			stat.setString(3, user.getSurname());
			stat.execute();
			user.setId(id);
			System.out.println("User #"+user.getId()+" "+user.getName()+" "+user.getSurname()+" created\n");
			
			connection.close();
			return user;
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User findUserById(int id) {
		User u = null;
		String query = "SELECT * FROM User WHERE id=?";
		ResultSet res;
		//openConnection();
		try (PreparedStatement stat = connection.prepareStatement(query);){
			stat.setInt(1, id);
			res = stat.executeQuery();	
			if (res.next()) {
				u = new User (id, res.getString(2), res.getString(3));	
			}
				
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User updateUser(User user) {
		String query = "UPDATE User SET name=user.getName(), surname=user.getSurname() WHERE id=?;";
		
		//openConnection();
		try (PreparedStatement stat = connection.prepareStatement(query);){
			stat.setInt(1, user.getId());			
			stat.execute();
			System.out.println("User #"+user.getId()+" updated\n");
			
			connection.close();
			return user;
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public void deleteUser(User user) {
		String query = "DELETE FROM User WHERE id=?";
		
		//openConnection();
		try (PreparedStatement stat = connection.prepareStatement(query);){
			stat.setInt(1, user.getId());			
			stat.execute();
			System.out.println("Deleting user#"+user.getId()+"\n");
			
			connection.close();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public ArrayList<User> allUsers() {
		ArrayList<User> list=new ArrayList<>();
		String query = "SELECT * FROM User";
		ResultSet res;
		//openConnection();
		try {
			Statement stat = connection.createStatement();
			res = stat.executeQuery(query);	
			
			while (res.next()) {
				list.add(new User (res.getInt(1), res.getString(2), res.getString(3)));	
			}
				
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return list;
	}
}
