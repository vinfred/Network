package mod;

public interface MessDao {
	Message createMessage(Message message, Group group);
	void deleteMessage(Message message);
	Message findMessageById(int id);
	Group findMessageGroup(Message message); 
	Message updateMessage(Message message);
}
