package com.homework.main.appmanager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public final static Logger logger = Logger.getLogger(ApplicationManager.class);

    public WebDriver wd;
    private String browser;
    private SessionHelper sessionHelper;
    private NavigatorHelper navigatorHelper;
    private CreateAdHelper createAdHelper;
    private RubricHelper rubricHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        initWebDriver(this.browser);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void initWebDriver(String browserType) {
        switch (browserType) {
            case BrowserType.FIREFOX:
                wd = new FirefoxDriver();
                break;
            case BrowserType.CHROME:
                wd = new ChromeDriver();
                break;
            case BrowserType.IE:
                wd = new InternetExplorerDriver();
                break;
            default:
                wd = new FirefoxDriver();
        }
        logger.info("Initiate webDriver for " + browserType);
    }

    public void init(){
        wd.get("https://www.olx.ua");
        logger.info("Go to https://www.olx.ua page");
        sessionHelper = new SessionHelper(wd);
        navigatorHelper = new NavigatorHelper(wd);
        createAdHelper = new CreateAdHelper(wd);
        rubricHelper = new RubricHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public NavigatorHelper getNavigatorHelper(){
        return navigatorHelper;
    }

    public SessionHelper getSessionHelper(){
        return sessionHelper;
    }

    public CreateAdHelper getCreateAdHelper() {
        return createAdHelper;
    }

    public RubricHelper getRubricHelper(){
        return rubricHelper;
    }
}
