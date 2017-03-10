package com.homework.main.model;

public class CreateAdModel {
    private String title;
    private String description;

    private String location;
    private String contact;

    public CreateAdModel(String title, String description, String location, String contact) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public String getLocation() {
        return location;
    }
    public String getContact(){
        return contact;
    }
}
