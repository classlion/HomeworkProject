package com.ait.homework.test;


import com.homeworkProject.data.UserData;
import com.homeworkProject.models.UserHomework;
import com.homeworkProject.utils.DataProviders;
import com.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTestHomework extends TestBaseHomework {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void newUserRegistrationPositiveTest(){

        appHomework.getUser().click(By.cssSelector("[href='/register']"));
        appHomework.getUser().fillRagesterLoginForm(new UserHomework()
                .setFirstName(UserData.FIRSTNAME)
                .setLastName(UserData.LASTNAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.CONFIRMPASSWORD));
        appHomework.getUser().click(By.id("register-button"));
        Assert.assertTrue(appHomework.getUser().isElementPresent(By.xpath("//h1[.='Register']")));
    }

    @Test(dataProvider = "addNewUser", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderTest(String firstName,
                                                                String lastName,
                                                                String email,
                                                                String password,
                                                                String confirmPassword){

        appHomework.getUser().click(By.cssSelector("[href='/register']"));
        appHomework.getUser().fillRagesterLoginForm(new UserHomework()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword));
        appHomework.getUser().click(By.id("register-button"));
        Assert.assertTrue(appHomework.getUser().isElementPresent(By.xpath("//h1[.='Register']")));
    }

    @Test(dataProvider = "addNewUserWithCSV", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderWithFileTest(UserHomework userHomework){

        appHomework.getUser().click(By.cssSelector("[href='/register']"));
        appHomework.getUser().fillRagesterLoginForm(userHomework);
        appHomework.getUser().click(By.id("register-button"));
        Assert.assertTrue(appHomework.getUser().isElementPresent(By.xpath("//h1[.='Register']")));
    }

    @Test
    public void newUserRegistrationNegativeTest(){
        //click on Login Link
        int i=(int)(System.currentTimeMillis()/1000)%3600;
        appHomework.getUser().click(By.cssSelector("[href='/register']"));
        appHomework.getUser().fillRagesterLoginForm(new UserHomework()
                        .setFirstName(UserData.FIRSTNAME)
                        .setLastName(UserData.LASTNAME)
                        .setEmail(UserData.EMAIL)
                        .setPassword(UserData.PASSWORD)
                        .setConfirmPassword("ELSE"));
        appHomework.getUser().click(By.id("register-button"));
        softAssert.assertFalse(appHomework.getUser().isElementPresent(By.xpath("field-validation-error")));
        //softAssert.assertTrue(isErrorMessagePresent());
        softAssert.assertAll();
    }
}
