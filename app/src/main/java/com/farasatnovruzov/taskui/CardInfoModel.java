package com.farasatnovruzov.taskui;

public class CardInfoModel {

    private String name;
    private String date;
    private String currency;
    private int image;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public CardInfoModel(String name, int image, String date, String currency) {
        this.name = name;
        this.image = image;
        this.date = date;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
