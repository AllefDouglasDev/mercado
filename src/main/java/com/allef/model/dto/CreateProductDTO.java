package com.allef.model.dto;

public class CreateProductDTO {
    private String name;
    private int amount;
    private String barCode;
    private int price;
    private int profitMargin;
    private int sellingValue;

    public CreateProductDTO(String name, int amount, String barCode, int price, int profitMargin, int sellingValue) {
        this.name = name;
        this.amount = amount;
        this.barCode = barCode;
        this.price = price;
        this.profitMargin = profitMargin;
        this.sellingValue = sellingValue;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
}
