package com.homework.test.ui;

import com.homework.main.appmanager.ApplicationManager;
import com.homework.main.model.User;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class UiBasicTestCase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    protected final User testUser = new User("romonkje@gmail.com", "secretpassword");

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}
