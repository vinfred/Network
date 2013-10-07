package action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	static HashMap<String, Action> hash = new HashMap<>();
	
	static {
		hash.put ("users", new UserAction());
		hash.put ("deleteUser", new DeleteAction());
	}
	
	public static Action getAction (HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		String[] tokens = url.split("/");
		String lastToken = tokens[tokens.length-1];
		return hash.get(lastToken);
	}

}
