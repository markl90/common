package com.netbuilder.test.common.session;


import com.netbuilder.test.common.utilities.ElementHelper;
import com.netbuilder.test.common.utilities.PageHelper;
import com.relevantcodes.extentreports.ExtentReports;
import cucumber.api.java.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class TestBase {

    @Autowired
    protected static Session session;
    protected WebDriver driver;
    protected ElementHelper helper;
    protected PageHelper page;

    protected static ExtentReports reports;



    public TestBase() {
        stepsInitialisation();
    }

    @PostConstruct
    public void stepsInitialisation(){
        try {
            session = SessionSingleton.getSession();
            driver = session.getDriver();
            helper = new ElementHelper(driver);
            page = new PageHelper();
            reports = new ExtentReports(System.getProperty("extent-report-path"), true);


        }
        catch (Exception e){
            System.out.println("Singleton Session creation issue.");
            e.getCause();
            e.getLocalizedMessage();
            e.printStackTrace();
            e.getMessage();
        }
    }


    @BeforeClass
    public static void extentSetup(){

    }

    @AfterClass
    public static void extentEnd(){
         session.stopDriver();
         reports.flush();
    }

//    @Finally
    public void after(){
        session.stopDriver();
    }







}
