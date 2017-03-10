package com.homework.main.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigatorHelper extends HelperBase {

    public NavigatorHelper(WebDriver wd) {
        super(wd);
    }

    public void goToCreateAdd(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.id("postNewAdLink"));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
