package com.homeworkProject.fw;

import com.homeworkProject.models.UserHomework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelperHomework extends BaseHelperHomework{

    public UserHelperHomework(WebDriver driver) {
        super(driver);
    }

    public void fillRagesterLoginForm(UserHomework user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("ConfirmPassword"), user.getConfirmPassword());

    }




}
