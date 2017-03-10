package com.homework.main.appmanager;

import com.homework.main.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String user, String password) {
        type(By.id("userEmail"), user);
        type(By.id("userPass"), password);
        click(By.id("se_userLogin"));
    }

    public void login(User user){
        login(user.getUserName(), user.getUserPassword());
    }
}
