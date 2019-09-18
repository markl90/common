package com.netbuilder.test.common.driverfactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected ThreadLocal<WebDriver> driver;
    protected abstract void createDriver();


    public WebDriver getDriver(){
        if (driver == null){
            createDriver();
        }
        return driver.get();
    }

    public void stopDriver() {
        if (driver != null) {
            driver.get().quit();
            driver=null;
        }
    }

}
