package mod;

import java.math.*;
import java.security.*;
import java.util.*;

public class User {
	private int id;
	private String email;
	private String password;
	private String country;
	private String city;	
	private Date   bornDate;
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
		this.password = md5(password);
	}
	
	public User(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = md5(password);
	}

	public User(int id, String email, String password, String country,
			String city, Date bornDate, String interests, String profession,
			String name, String surname) {
		super();
		this.id = id;
		this.email = email;
		this.password = md5(password);
		this.country = country;
		this.city = city;
		this.bornDate = bornDate;
		this.interests = interests;
		this.profession = profession;
		this.name = name;
		this.surname = surname;
	}

	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
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

	public String md5 (String input) {
         
        String md5 = null;
         
        if(null == input) return null;
         
        try {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        
        
        digest.update(input.getBytes(), 0, input.length());
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } 
        catch (NoSuchAlgorithmException e) { 
            e.printStackTrace();
        }
        
        return md5;
    }
}
