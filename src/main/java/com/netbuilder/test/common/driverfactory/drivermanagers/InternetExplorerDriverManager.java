package com.netbuilder.test.common.driverfactory.drivermanagers;

import com.netbuilder.test.common.driverfactory.DriverConfiguration;
import com.netbuilder.test.common.driverfactory.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import static io.github.bonigarcia.wdm.DriverManagerType.IEXPLORER;

public class InternetExplorerDriverManager extends DriverManager {

    private DriverConfiguration configuration;

    public InternetExplorerDriverManager(DriverConfiguration configuration) {
        this.configuration = configuration;
    }

    public void createDriver(){
        WebDriverManager.getInstance(IEXPLORER).setup();

        final InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        options.setCapability("requireWindowFocus", true);

        String message = (configuration.getIsHeadlessTrue()) ? "NOTE: Running headless is not supported by Internet Explorer" : "";
        System.out.println(message);

        driver = new ThreadLocal<WebDriver>() {
            @Override
            protected WebDriver initialValue(){
                return new InternetExplorerDriver(options);
            }
        };
    }

}
