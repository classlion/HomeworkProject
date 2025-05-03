package com.ait.homework;

import com.homeworkProject.fw.ApplicationManagerHomework;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseHomework {

    protected ApplicationManagerHomework appHomework = new ApplicationManagerHomework();

    @BeforeMethod
    public void setUp(){
        appHomework.initHomework();
    }

    @AfterMethod(enabled = false)
    public void tearDown(){

        appHomework.stopHomework();
    }


}
