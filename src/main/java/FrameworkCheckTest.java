package main.java;

import com.netbuilder.test.common.session.TestBase;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;


public class FrameworkCheckTest extends TestBase {

    private ExtentTest test;

    @Before
    public void init(){
        test = reports.startTest("TEST_COMMON Check");
        test.getDescription();
        test.getStartedTime();
    }

    @After
    public void complete(){
        reports.endTest(test);
    }


    @Test
    public void frameworkCheckTest(){
        String testUrl = "https://www.google.co.uk/";
        test.log(LogStatus.INFO, "Going to " + testUrl);
        driver.get(testUrl);
        assertEquals(testUrl,  session.getDriver().getCurrentUrl());
        if ((testUrl.equals(driver.getCurrentUrl()))) {
            test.log(LogStatus.PASS, "url is correct " + testUrl);
        } else {
            test.log(LogStatus.FAIL, "url is incorrect, expected " + testUrl);
        }

        LogStatus status = (testUrl.equals(driver.getCurrentUrl())) ? LogStatus.PASS : LogStatus.FAIL;
        String message = (testUrl.equals(driver.getCurrentUrl())) ? "url is correct " + testUrl : "url is incorrect, expected " + testUrl;
        test.log(status, message);
    }


    @Test
    public void test2_0(){

        for (int i = 0; i < 10; i++) {
            ExtentTest test = reports.startTest("Test "+i);
            test.getDescription();
            test.log(LogStatus.INFO, "Going to INFO No. " + i);
            Random random = new Random();
            int j = random.nextInt(100);
            boolean condition = (j> 50);
            LogStatus status = condition ? LogStatus.PASS : LogStatus.FAIL;
            String message = condition ? "correct PASS ->" + Double.parseDouble(String.valueOf(Float.parseFloat(String.valueOf(i)))) : "FAIL, i == " + i;
            test.log(status, message);
            reports.endTest(test);
        }
    }

    @Test
    public void test3(){

    }



}
