package com.homework.main.appmanager;

import com.homework.main.model.CreateAdModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAdHelper extends HelperBase {

    public CreateAdHelper(WebDriver wd) {
        super(wd);
    }

    public void fillAdCreationForm(CreateAdModel model, boolean isContactData){
        type(By.id("add-title"), model.getTitle());
        type(By.id("add-description"), model.getDescription());

        if(isContactData){
            type(By.id("mapAddress"), model.getLocation());
            click(By.id("autosuggest-geo-ul"));
            type(By.id("add-person"), model.getContact());
        }
    }

    public void postAd(){
        click(By.id("save"));
    }
}
