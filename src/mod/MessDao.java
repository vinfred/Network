package mod;

public interface MessDao {
	Message createMessage(Message message);
	Message findMessageById(int id);
	Message updateMessage(Message message);
	void deleteMessage(Message message); 

}
