package com.homeworkProject.fw;

import com.homeworkProject.utils.MyListener;
import com.phonebook.fw.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManagerHomework{

    String browser;
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(ApplicationManagerHomework.class);
    //1:53:36 L28 - jenkins


    UserHelperHomework user;
    ContactHelperHomework contact;
    HomePageHelperHomework home;

    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));



    public ApplicationManagerHomework(String browser) {
        this.browser = browser;
    }

    public void initHomework() {
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Test start in Chrome browser");

        } else  if (browser.equalsIgnoreCase("firefox")){

            driver = new FirefoxDriver();
            logger.info("Test start in Firefox browser");
        }
        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://demowebshop.tricentis.com/");
        logger.info("Current url-->" + driver.getCurrentUrl());
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
