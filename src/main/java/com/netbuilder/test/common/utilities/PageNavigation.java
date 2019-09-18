package com.netbuilder.test.common.utilities;


import com.netbuilder.test.common.session.Session;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PageNavigation {


    public static void goToLandingPage(Session session){
        WebDriver driver =  session.getDriver();

        try{
            driver.get(session.getBaseUrl());
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        } catch (Exception timeOut) {
            System.out.println("Page: " + session.getBaseUrl() + " did not load within 60 seconds!");
            timeOut.printStackTrace();
        }

    }

    public static void goToPage(Session session, String page){
        WebDriver driver =  session.getDriver();

        try{
            driver.get(page);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        } catch (Exception timeOut) {
           System.out.println("Page: " + session.getBaseUrl() + " did not load within 60 seconds!");
           timeOut.printStackTrace();
        }

    }

    public static void switchToReferenceEnvironment(Session session){
        String currentUrl = session.getDriver().getCurrentUrl();
        String referenceEquivalentUrl = currentUrl.replace(session.getBaseUrl(), session.getReferenceEnvironmentUrl());
        goToPage(session, referenceEquivalentUrl);
    }


}
