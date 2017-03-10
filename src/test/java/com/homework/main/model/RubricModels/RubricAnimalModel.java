package com.homework.main.model.RubricModels;

public class RubricAnimalModel {

    private String price;
    private String breed;
    private String business;
    private String description;
    private String currency;
    private boolean isContractPrice;

    public RubricAnimalModel(){
    }

    public RubricAnimalModel withPrice(String price) {
        this.price = price;
        return this;
    }

    public RubricAnimalModel withCurrency(String currency){
        this.currency = currency;
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

    public RubricAnimalModel withContractPrice(boolean isContractPrice){
        this.isContractPrice = isContractPrice;
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

    public String getCurrency() {
        return currency;
    }

    public boolean isContractPrice() {
        return isContractPrice;
    }
}
