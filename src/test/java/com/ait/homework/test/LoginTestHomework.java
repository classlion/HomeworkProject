package com.ait.homework.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestHomework extends TestBaseHomework {

    @Test
    public void loginPositiveTest() {
        clickOnLoginButton();
        enterPersonalData("classlion1@gmail.com", "Aa123456$");
        clickOnLoginSubmitButton();
        isSignOutButtonPresent();
    }

    private void enterPersonalData(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    private void isSignOutButtonPresent() {
        Assert.assertTrue(appHomework.getHome().isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    private void clickOnLoginSubmitButton() {
        appHomework.getUser().click(By.xpath("//input[@value='Log in']"));
    }

    private void enterPassword(String password) {
        appHomework.getUser().type(By.cssSelector("#Password"), password);
    }

    private void enterEmail(String email) {
        appHomework.getUser().type(By.xpath("//*[@name='Email']"), email);
    }

    private void clickOnLoginButton() {
        appHomework.getUser().click(By.cssSelector("[href='/login']"));
    }
}
