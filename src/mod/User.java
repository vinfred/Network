package mod;

import help.Md5;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class User {
	private Calendar   bornDate;
	private String city;
	private String country;
	private String email;
	private int id;
	private String interests;	
	private String name;
	private String password;
	private String profession;
	private String surname;
	public User() {
		super();
	}


	public User(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password =  password;
	}

	public User(int id, String email, String password, String country,
			String city, Calendar bornDate, String interests, String profession,
			String name, String surname) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.email = email;
		this.password = password;
		this.bornDate = bornDate;
		this.interests = interests;
		this.profession = profession;
		this.name = name;
		this.surname = surname;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = Md5.getMd5(password);
	}

	public String getBornDate() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format1.format(this.bornDate.getTime());
		return formatted;
	}

	public String getCity() {
		return this.city;
	}

	public String getCountry() {
		return this.country;
	}

	public String getEmail() {
		return this.email;
	}

	public int getId() {
		return this.id;
	}

	public String getInterests() {
		return this.interests;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public String getProfession() {
		return this.profession;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setBornDate(Calendar bornDate) {
		this.bornDate = bornDate;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "User [id=" + this.id + ", email=" + this.email + ", password=" + this.password
				+ ", country=" + this.country + ", city=" + this.city + ", bornDate="
				+ this.bornDate + ", interests=" + this.interests + ", profession="
				+ this.profession + ", name=" + this.name + ", surname=" + this.surname + "]";
	}	
}
