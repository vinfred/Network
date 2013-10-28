package mod;

import help.Md5;

import java.text.SimpleDateFormat;
import java.util.*;

public class User {
	private int id;
	private String email;
	private String password;
	private String country;
	private String city;	
	private Calendar   bornDate;
	private String interests;
	private String profession;
	private String name;
	private String surname;
	
	
	public User() {
		super();
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = Md5.getMd5(password);
	}
	
	public User(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password =  password;
	}

	public User(int id, String country,
			String city, Calendar bornDate, String interests, String profession,
			String name, String surname) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.bornDate = bornDate;
		this.interests = interests;
		this.profession = profession;
		this.name = name;
		this.surname = surname;
	}

	public String getBornDate() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
		String formatted = format1.format(bornDate.getTime());
		return formatted;
	}
	
	public void setBornDate(Calendar bornDate) {
		this.bornDate = bornDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}	
}
