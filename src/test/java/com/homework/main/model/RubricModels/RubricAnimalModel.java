package com.homework.main.model.RubricModels;

public class RubricAnimalModel {

    private String price;
    private String breed;
    private String business;
    private String description;

    public RubricAnimalModel(){
    }

    public RubricAnimalModel withPrice(String price) {
        this.price = price;
        return this;
    }

    public RubricAnimalModel withBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public RubricAnimalModel withBusiness(String business) {
        this.business = business;
        return this;
    }

    public RubricAnimalModel withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public String getBreed() {
        return breed;
    }

    public String getBusiness(){
        return business;
    }

    public String getDescription() {
        return description;
    }
}
