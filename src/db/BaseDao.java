package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mod.Group;
import mod.GroupDao;
import mod.MessDao;
import mod.Message;
import mod.User;
import mod.UserDao;

public class BaseDao implements UserDao, GroupDao, MessDao {

	Connection connection=null;

	public BaseDao (Connection connection) {
		this.connection = connection;
	}

	@Override
	public ArrayList<Group> allGroups() {
		ArrayList<Group> list=new ArrayList<>();
		String query = "SELECT * FROM Community";
		ResultSet res;

		try {
			Statement stat = this.connection.createStatement();
			res = stat.executeQuery(query);	

			while (res.next()) {
				list.add(new Group (res.getInt(1), res.getString(2), res.getString(3)));	
			}				
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		

		return list;
	}

	@Override
	public ArrayList<Group> allUserGroups(int userId) {
		ArrayList<Group> list=new ArrayList<>();
		String query = "SELECT * FROM Community WHERE ";
		ResultSet res;

		try {
			Statement stat = this.connection.createStatement();
			res = stat.executeQuery(query);	

			while (res.next()) {
				list.add(new Group (res.getInt(1), res.getString(2), res.getString(3)));	
			}				
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		

		return list;
	}

	@Override
	public ArrayList<User> allUsers() {
		ArrayList<User> list=new ArrayList<>();
		String query = "SELECT * FROM User";
		ResultSet res;

		try {
			Statement stat = this.connection.createStatement();
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

	@Override
	public Group createGroup(Group group) {
		int id=0;		
		createGroupTable();

		String query = "INSERT INTO Community (id, name, description) VALUES (?, ?, ?);";
		String idQuery = "SELECT max(id) FROM Community";

		try (PreparedStatement stat = this.connection.prepareStatement(query);) {
			Statement stat1 = this.connection.createStatement();
			ResultSet res = stat1.executeQuery(idQuery);

			if (res.next()) {
				id=1+res.getInt(1);
			}

			stat.setInt(1, id);
			stat.setString(2, group.getName());
			stat.setString(3, group.getDescription());
			stat.execute();

			group.setId(id);
			System.out.println("User #"+group.getId()+" "+group.getName()+" "+group.getDescription()+" created\n");

			return group;
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	void createGroupTable() {
		String query = "CREATE TABLE IF NOT EXISTS Community (id INT NOT NULL PRIMARY KEY,"
				+ "name VARCHAR(50) NOT NULL, description VARCHAR(500)";

		String query2 = "CREATE TABLE IF NOT EXISTS MessageInCommunity (messageId INT, groupId INT "+
				"FOREIGN KEY(messageId) references Message(id), FOREIGN KEY(groupId) references Community(id));";

		try {
			Statement stat = this.connection.createStatement();
			stat.executeUpdate(query);
			stat.executeUpdate(query2);
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

	void createMessageTable() {
		String query = "CREATE TABLE IF NOT EXISTS Message (id INT NOT NULL PRIMARY KEY, text VARCHAR(500), date text, userId INT, "
				+ "FOREIGN KEY userId REFERENCES User(id));";
		try {
			Statement stat = this.connection.createStatement();
			stat.executeUpdate(query);
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User createUser(User user) {
		int id=0;		
		createUserTable();

		String query = "INSERT INTO User (id, email, password) VALUES (?, ?, ?);";
		String idQuery = "SELECT max(id) FROM User";

		try (PreparedStatement stat = this.connection.prepareStatement(query);) {
			Statement stat1 = this.connection.createStatement();
			ResultSet res = stat1.executeQuery(idQuery);

			if (res.next()) {
				id=1+res.getInt(1);
			}

			stat.setInt(1, id);
			stat.setString(2, user.getEmail());
			stat.setString(3, user.getPassword());
			stat.execute();

			user.setId(id);
			System.out.println("User #"+user.getId()+" "+user.getEmail()+" "+user.getPassword()+" created\n");

			return user;
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	void createUserTable() {
		String query = "CREATE TABLE IF NOT EXISTS User (id INT NOT NULL PRIMARY KEY,"
				+ "email VARCHAR(50) NOT NULL, password VARCHAR(200) NOT NULL,"
				+ "country VARCHAR(50), city VARCHAR(50),"
				+ "born DATE, interest VARCHAR(500), profession VARCHAR(100),"
				+ "name VARCHAR(50), surname VARCHAR(50));";
		String query2 = "CREATE TABLE IF NOT EXISTS UserInCommunity (userId INTEGER, groupId INTEGER, "
				+ "FOREIGN KEY (userId) references User(id), FOREIGN KEY (groupId) references Community(id));";

		try {
			Statement stat = this.connection.createStatement();
			stat.executeUpdate(query);
			stat.executeUpdate(query2);
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteGroup(Group group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		String query = "DELETE FROM User WHERE id=?";

		try (PreparedStatement stat = this.connection.prepareStatement(query);){
			stat.setInt(1, user.getId());			
			stat.execute();
			System.out.println("Deleting user#"+user.getId()+"\n");
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Group findGroupById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message findMessageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		User u = null;
		String query = "SELECT id, email, password FROM User WHERE email=?";
		ResultSet res;

		try (PreparedStatement stat = this.connection.prepareStatement(query);){
			stat.setString(1, email);
			res = stat.executeQuery();	
			if (res.next()) {
				u = new User (res.getInt(1), res.getString(2), res.getString(3));	
			}				
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User findUserById(int id) {
		User u = null;
		String query = "SELECT * FROM User WHERE id=?";
		ResultSet res;

		try (PreparedStatement stat = this.connection.prepareStatement(query);){
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
	public ArrayList<Message> getAllMessages(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group getGrouById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group updateGroup(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message updateMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		User u1=findUserById(user.getId());
		String query = "UPDATE User SET email=\""+u1.getEmail()+"\", password=\""+u1.getPassword()+"\", "
				+ "country=\""+user.getCountry()+"\", city=\""+user.getCity()+"\", "
				+ "born=\""+user.getBornDate()+"\", profession=\""+user.getProfession()+"\", "
				+ "name=\""+user.getName()+"\", surname=\""+user.getSurname() +"\" WHERE id=?;";

		System.out.println(query);

		try (PreparedStatement stat = this.connection.prepareStatement(query);){
			stat.setInt(1, user.getId());			
			stat.execute();
			System.out.println("User #"+user.getId()+" updated\n");

			return user;
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
