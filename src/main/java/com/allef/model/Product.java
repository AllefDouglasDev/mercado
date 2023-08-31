package com.allef.model;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private int amount;
    private String barCode;
    private int entryValue;
    private int profitMargin;
    private int sellingValue;
    private int isDeleted;
    private Date createdAt;
    private Date updatedAt;

    public Product(String name, int amount, String barCode, int entryValue, int profitMargin, int sellingValue) {
        this.name = name;
        this.amount = amount;
        this.barCode = barCode;
        this.entryValue = entryValue;
        this.profitMargin = profitMargin;
        this.sellingValue = sellingValue;
    }

    public Product(int id, String name, int amount, String barCode, int entryValue, int profitMargin, int sellingValue, int isDeleted, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.barCode = barCode;
        this.entryValue = entryValue;
        this.profitMargin = profitMargin;
        this.sellingValue = sellingValue;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(String name, int amount, String barCode, int entryValue, int profitMargin, int sellingValue, int isDeleted, Date createdAt, Date updatedAt) {
        this.name = name;
        this.amount = amount;
        this.barCode = barCode;
        this.entryValue = entryValue;
        this.profitMargin = profitMargin;
        this.sellingValue = sellingValue;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public int getEntryValue() {
		return entryValue;
	}

	public void setEntryValue(int entryValue) {
		this.entryValue = entryValue;
	}

	public int getProfitMargin() {
		return profitMargin;
	}

	public void setProfitMargin(int profitMargin) {
		this.profitMargin = profitMargin;
	}

	public int getSellingValue() {
		return sellingValue;
	}

	public void setSellingValue(int sellingValue) {
		this.sellingValue = sellingValue;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", barCode='" + barCode + '\'' +
                ", entryValue=" + entryValue +
                ", profitMargin=" + profitMargin +
                ", sellingValue=" + sellingValue +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
