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

    public int getId() {
        return id;
    }
}
