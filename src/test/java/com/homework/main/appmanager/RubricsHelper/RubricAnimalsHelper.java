package com.homework.main.appmanager.RubricsHelper;

import com.homework.main.appmanager.HelperBase;
import com.homework.main.model.RubricModels.RubricAnimalModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RubricAnimalsHelper extends HelperBase {

    public RubricAnimalsHelper(WebDriver wd) {
        super(wd);
    }

    public void fillRubric(RubricAnimalModel model){
        type(By.name("data[param_price][1]"), model.getPrice());
        select(By.id("param137"), model.getBreed());
        select(By.id("targetid_private_business"), model.getBusiness());
        select(By.id("add-description"), model.getDescription());
    }
}
