package mod;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Message {
	private Calendar date;
	private int id;
	private String text;
	private User user;

	public Message() {
		super();
	}

	public Message(int id, User user, String text, Calendar date) {
		super();
		this.id = id;
		this.user = user;
		this.text = text;
		this.date = date;
	}

	public Message(User user, String text, Calendar date) {
		super();
		this.user = user;
		this.text = text;
		this.date = date;
	}

	public String getDate() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		String formatted = format1.format(this.date.getTime());
		return formatted;
	}

	public int getId() {
		return this.id;
	}

	public String getText() {
		return this.text;
	}

	public User getUser() {
		return this.user;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUser(User user) {
		this.user = user;
	}



}
