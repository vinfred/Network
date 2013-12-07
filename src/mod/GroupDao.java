package mod;

import java.util.ArrayList;


public interface GroupDao {
	void addUserToGroup (User u, Group g);
	ArrayList<Group> allGroups ();
	ArrayList<Group> allUserGroups (int userId);
	Group createGroup(Group group);
	void deleteGroup(Group group);
	Group findGroupById(int id);
	ArrayList<Message> getAllMessages (int id);
	Group updateGroup(Group group);


}
