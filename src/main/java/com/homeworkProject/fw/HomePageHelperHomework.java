package com.homeworkProject.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelperHomework extends BaseHelperHomework {
    public HomePageHelperHomework(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent(){
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }
}
