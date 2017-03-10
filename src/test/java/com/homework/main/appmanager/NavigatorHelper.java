package com.homework.main.appmanager;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatorHelper extends HelperBase {

    public final static Logger logger = Logger.getLogger(NavigatorHelper.class);

    public NavigatorHelper(WebDriver wd) {
        super(wd);
    }

    public void goToCreateAdd(){
        new WebDriverWait(wd, 6).until(ExpectedConditions.elementToBeClickable(By.id("postNewAdLink")));
        click(By.id("postNewAdLink"));
        logger.info("Click to postNewAdLink");
    }


}
