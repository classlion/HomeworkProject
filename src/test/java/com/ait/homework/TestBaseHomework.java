package com.ait.homework;

import com.homeworkProject.fw.ApplicationManagerHomework;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseHomework {

    protected ApplicationManagerHomework appHomework = new ApplicationManagerHomework(System.getProperty("browser",
            Browser.CHROME.browserName()));

    @BeforeMethod
    public void setUp(){
        appHomework.initHomework();
    }

    @AfterMethod(enabled = false)
    public void tearDown(){

        appHomework.stopHomework();
    }


}
