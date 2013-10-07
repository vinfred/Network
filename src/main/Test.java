package main;

import mod.User;
import db.BaseDao;

public class Test {

	public static void main(String[] args) {
		BaseDao db = new BaseDao();
		
		db.createUser(new User("Panasik", "Anchous"));

	}

}
