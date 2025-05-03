package com.ait.homework.test;//package com.phonbook.tests;
//
//import com.homeworkProject.models.UserHomework;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//public class CreateAccountTestHomework extends TestBaseHomework {
//
//    SoftAssert softAssert = new SoftAssert();
//
//    @Test
//    public void newUserRegistrationPositiveTest(){
//        //click on Login Link
//
//        appHomework.getUser().click(By.cssSelector("[href='/register']"));
//        appHomework.getUser().fillRagesterLoginForm(new UserHomework.NewUserHomework()
//                .setFirstName("Oliver")
//                .setLastName("Smith")
//                .setEmail("1234EWRWRE@gmail.com")
//                .setPassword("something")
//                .setConfirmPassword("something"));
//        appHomework.getUser().click(By.id("register-button"));
//        Assert.assertTrue(appHomework.getUser().isElementPresent(By.xpath("//h1[.='Register']")));
//    }
//
//    @Test
//    public void newUserRegistrationNegativeTest(){
//        //click on Login Link
//        int i=(int)(System.currentTimeMillis()/1000)%3600;
//        appHomework.getUser().click(By.cssSelector("[href='/register']"));
//        appHomework.getUser().fillRagesterLoginForm(new UserHomework.NewUserHomework()
//                        .setFirstName("Oliver")
//                        .setLastName("Smith")
//                        .setEmail("1234@gmail.com")
//                        .setPassword("something")
//                        .setConfirmPassword("ELSE"));
//        appHomework.getUser().click(By.id("register-button"));
//        softAssert.assertFalse(appHomework.getUser().isElementPresent(By.xpath("field-validation-error")));
//        //softAssert.assertTrue(isErrorMessagePresent());
//        softAssert.assertAll();
//    }
//}
