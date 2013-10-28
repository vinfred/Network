package mod;

import java.util.ArrayList;

public interface UserDao {
	User createUser(User user);
	User findUserById(int id);
	User findUserByEmail(String email);
	User updateUser(User user);
	void deleteUser(User user); 
	ArrayList<User> allUsers();

}
