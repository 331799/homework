package com.homework.main.appmanager;

import com.homework.main.appmanager.RubricsHelper.RubricAnimalsHelper;
import com.homework.main.model.RubricModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RubricHelper extends HelperBase {

    private RubricAnimalsHelper rubricAnimalsHelper;

    public RubricHelper(WebDriver wd) {
        super(wd);
    }

    public void chooseRubric(String name){
        click(By.linkText(name));
    }

    public void chooseSubheading(String name){
        click(By.linkText(name));
    }

    public void chooseSubSubHeading(String name){
        click(By.linkText(name));
    }

    public void chooseRubric(RubricModel rubricModel){
        click(By.id("choose-category-ilu"));

        if(rubricModel.getRubric() != null){
            chooseRubric(rubricModel.getRubric());
        }
        if(rubricModel.getSubRubric() != null){
            chooseSubheading(rubricModel.getSubRubric());
        }
        if(rubricModel.getSubSubRubric() != null){
            chooseSubSubHeading(rubricModel.getSubSubRubric());
        }

        initRubric();
    }

    private void initRubric() {
        rubricAnimalsHelper = new RubricAnimalsHelper(wd);
    }

    public void fillRubric(RubricModel rubric) {

    }

    public RubricAnimalsHelper getAnimalsRubricHelper(){
        return rubricAnimalsHelper;
    }
}
