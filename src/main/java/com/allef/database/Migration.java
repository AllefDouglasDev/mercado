package com.allef.database;

public class Migration {
	public String[] getSQLs() {
		return new String[] {
				this.createUsersTable(),
				this.createProductsTable(),
				this.createSalesTable(),
		};
	}

	private String createUsersTable() {
		return "CREATE TABLE IF NOT EXISTS users (\n"
				+ "    id INTEGER PRIMARY KEY,\n"
				+ "    username TEXT,\n"
				+ "    password TEXT\n"
				+ ");";
	}
	
	private String createProductsTable() {
		return "CREATE TABLE IF NOT EXISTS products (\n"
				+ "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    name TEXT NOT NULL,\n"
				+ "    amount INTEGER NOT NULL,\n"
				+ "    bar_code TEXT NOT NULL,\n"
				+ "    entry_value REAL NOT NULL,\n"
				+ "    profit_margin REAL NOT NULL,\n"
				+ "    selling_value REAL NOT NULL,\n"
				+ "    is_deleted INTEGER DEFAULT 0,\n"
				+ "    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
				+ "    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP\n"
				+ ");";
	}

	private String createSalesTable() {
		return "CREATE TABLE IF NOT EXISTS sales (\n"
				+ "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
				+ "    name TEXT NOT NULL,\n"
				+ "    entry_value REAL NOT NULL,\n"
				+ "    quantity INTEGER NOT NULL,\n"
				+ "    selling_value REAL NOT NULL,\n"
				+ "    bar_code TEXT NOT NULL,\n"
				+ "    hours TIME NOT NULL,\n"
				+ "    total REAL NOT NULL,\n"
				+ "    is_deleted INTEGER DEFAULT 0,\n"
				+ "    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
				+ "    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP\n"
				+ ");";
	}
}
