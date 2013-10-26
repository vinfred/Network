package mod;

public interface GroupDao {
	Group createGroup(Group group);
	Group findGroupById(int id);
	Group updateGroup(Group group);
	void deleteGroup(Group group); 

}
