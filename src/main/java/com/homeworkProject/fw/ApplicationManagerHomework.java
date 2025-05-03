package com.homeworkProject.fw;

import com.phonebook.fw.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManagerHomework{

    String browser;
    WebDriver driver;

    UserHelperHomework user;
    ContactHelperHomework contact;
    HomePageHelperHomework home;

    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(ApplicationManagerHomework.class);

    public ApplicationManagerHomework(String browser) {
        this.browser = browser;
    }

    public void initHomework() {
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Test start in Firefox browser");

        } else  if (browser.equalsIgnoreCase("firefox")){

            driver = new FirefoxDriver();
            logger.info("Test start in Firefox browser");
        }

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
