package com.homework.main.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void type(By locator, String text) {
        if(text != null && !text.equals(findElement(locator).getAttribute("value"))) {
            findElement(locator).clear();
            findElement(locator).sendKeys(text);
        }
    }

    public WebElement findElement(By locator) {
        return  wd.findElement(locator);
    }

    protected void select(By locator, String text){
        click(locator);
        click(By.linkText(text));
    }
}
