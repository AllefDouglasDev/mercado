package com.allef.database;

import java.util.HashMap;

public class Seed {
	public HashMap<String, String[]> getSQLs() {
		HashMap<String, String[]> list = new HashMap<>();

		list.put("users", new String[] {
				this.createUsers(),
		});

		return list;
	}

	private String createUsers() {
		return "INSERT INTO users (username, password) VALUES ('admin', '123');";
	}
}
