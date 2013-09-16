package mod;

import java.util.ArrayList;

public class Group {
	int id;
	String name;
	ArrayList<User> userList;
	ArrayList<Message> messList;
	
	public Group() {
		super();
	}
	
	public Group(int id, String name, ArrayList<User> userList, ArrayList<Message> messList) {
		super();
		this.id = id;
		this.name=name;
		this.userList = userList;
		this.messList = messList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public ArrayList<Message> getMessList() {
		return messList;
	}

	public void setMessList(ArrayList<Message> messList) {
		this.messList = messList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
