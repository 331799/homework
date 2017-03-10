package com.homework.main.appmanager;

import com.homework.main.model.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SessionHelper extends HelperBase {

    public final static Logger logger = Logger.getLogger(SessionHelper.class);

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String user, String password) {
        logger.info("Input userName: " + user);
        type(By.id("userEmail"), user);
        logger.info("Input password: " + password);
        type(By.id("userPass"), password);
        logger.info("Click login button");
        click(By.id("se_userLogin"));

    }

    public void login(User user){
        new WebDriverWait(wd, 6).until(ExpectedConditions.elementToBeClickable(By.id("userEmail")));
        login(user.getUserName(), user.getUserPassword());
    }
}
