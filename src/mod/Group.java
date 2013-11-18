package mod;

import java.util.ArrayList;

public class Group {
	int id;
	ArrayList<Message> messList;
	String name, description;
	ArrayList<User> userList;

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

	public Group(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Group(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public int getId() {
		return this.id;
	}

	public ArrayList<Message> getMessList() {
		return this.messList;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<User> getUserList() {
		return this.userList;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMessList(ArrayList<Message> messList) {
		this.messList = messList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}





}
