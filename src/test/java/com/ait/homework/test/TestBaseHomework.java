package com.ait.homework.test;

import com.homeworkProject.fw.ApplicationManagerHomework;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

import static com.homeworkProject.fw.ApplicationManagerHomework.app;

public class TestBaseHomework {

    Logger logger = LoggerFactory.getLogger(TestBaseHomework.class);

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

    @BeforeMethod
    public void startTest(Method method, Object[] p){
        logger.info("Start test"+method.getName()+ Arrays.asList(p));

    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED: "+result.getMethod().getMethodName());
        } else {
            logger.error("FAILLD: "+result.getMethod().getMethodName()+"Screenshot path:"+
                    app.getUser().takeScreenshot());
        }

        logger.info("====================================================================");

        logger.info("Stop test");
    }


}
