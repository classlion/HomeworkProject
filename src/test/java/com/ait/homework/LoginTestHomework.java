package com.ait.homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestHomework extends TestBaseHomework {


    @Test
    public void loginPositiveTest() {
        appHomework.getUser().click(By.cssSelector("[href='/login']"));

        appHomework.getUser().type(By.name("email"), "classlion1@gmail.com");

        appHomework.getUser().type(By.name("password"), "Aa123456$");

        appHomework.getUser().click(By.name("login"));

        Assert.assertTrue(appHomework.getHome().isElementPresent(By.xpath("//button[.='Sign Out']")));
    }
}
