package mod;

public interface UserDao {
	User createUser(User user);
	User findUserById(int id);
	User updateUser(User user);
	void deleteUser(User user); 

}
