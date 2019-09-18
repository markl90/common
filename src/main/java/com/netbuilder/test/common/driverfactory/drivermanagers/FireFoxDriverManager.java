package com.netbuilder.test.common.driverfactory.drivermanagers;

import com.netbuilder.test.common.driverfactory.DriverConfiguration;
import com.netbuilder.test.common.driverfactory.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

public class FireFoxDriverManager extends DriverManager {
    private DriverConfiguration configuration;

    public FireFoxDriverManager(DriverConfiguration configuration) {
        this.configuration = configuration;
    }

    public void createDriver(){
        WebDriverManager.getInstance(FIREFOX).setup();
        if (configuration.getIsHeadlessTrue() == null || configuration.getIsHeadlessTrue() == false){
            final FirefoxOptions options = new FirefoxOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--start-maximized");
            options.addArguments("--allow-insecure-localhost");
            driver = new ThreadLocal<WebDriver>() {
                @Override
                protected WebDriver initialValue(){
                    return new FirefoxDriver(options);
                }
            };
        }
        else if(configuration.getIsHeadlessTrue()){
            final FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-headless");
            options.addArguments("--window-size=1280,1024");
            options.addArguments("--width=1280");
            options.addArguments("--height=1024");
            options.addArguments("--allow-insecure-localhost");
            driver = new ThreadLocal<WebDriver>() {
                @Override
                protected WebDriver initialValue() {
                    return new FirefoxDriver(options);
                }
            };
        }
    }

}
