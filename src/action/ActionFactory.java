package action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	static HashMap<String, Action> hash = new HashMap<>();

	static {
		hash.put ("/users", new UserAction());
		hash.put ("/deleteUser", new DeleteAction());
		hash.put ("/addUser", new AddUserAction());
		hash.put ("/editUser", new EditUserAction());
		hash.put ("/saveUser", new SaveUserAction());
		hash.put ("/login", new LoginAction());
		hash.put ("/logged", new LoggedAction());
		hash.put ("/user", new UserMainAction());
		hash.put ("/logOut", new LogOutAction());
		hash.put ("/myGroups", new UserGroupsAction());
		hash.put ("/profile", new UserMainAction());
		hash.put ("/addGroup", new AddGroupAction());
		hash.put ("/deleteGroup", new DeleteGroupAction());
		hash.put ("/editGroup", new EditGroupAction());
		hash.put ("/saveGroup", new SaveGroupAction());
		hash.put ("/showGroup", new ShowGroupAction());
		hash.put ("/follow", new FollowGroupAction());
		hash.put ("/addMessage", new AddMessageAction());
		hash.put ("/deleteMessage", new DeleteMessageAction());
	}

	public static Action getAction (HttpServletRequest request) {
		String url = request.getPathInfo();
		System.out.println(url);
		return hash.get(url);
	}

}
