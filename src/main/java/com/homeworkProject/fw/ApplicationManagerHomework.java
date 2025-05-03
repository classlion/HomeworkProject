package com.homeworkProject.fw;

import com.phonebook.fw.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManagerHomework{

    WebDriver driver;

    UserHelperHomework user;
    ContactHelperHomework contact;
    HomePageHelperHomework home;

    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));
    Logger logger = LoggerFactory.getLogger(ApplicationManagerHomework.class);

    public void initHomework() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelperHomework(driver);
        contact = new ContactHelperHomework(driver);
        home = new HomePageHelperHomework(driver);

    }

    public void stopHomework() {
        driver.quit();
    }

    public UserHelperHomework getUser() {
        return user;
    }

    public ContactHelperHomework getContact() {
        return contact;
    }

    public HomePageHelperHomework getHome() {
        return home;
    }

    //    public boolean isErrorMessagePresent() {
//        return appHomework.isElementPresent(By.xpath("//li[normalize-space()='The specified email already exists']"));
//    }
}
