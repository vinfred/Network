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
	}

	public static Action getAction (HttpServletRequest request) {
		String url = request.getServletPath();
		System.out.println(url);
		return hash.get(url);
	}

}
