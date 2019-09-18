package com.netbuilder.test.common.driverfactory.drivermanagers;

import com.netbuilder.test.common.driverfactory.DriverConfiguration;
import com.netbuilder.test.common.driverfactory.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class ChromeDriverManager extends DriverManager {


    private DriverConfiguration configuration;

    public ChromeDriverManager(DriverConfiguration configuration) {
        this.configuration = configuration;
    }

    public void createDriver(){
        WebDriverManager.getInstance(CHROME).setup();
        if (configuration.getIsHeadlessTrue() == null || configuration.getIsHeadlessTrue() == false){
            final ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("start-maximized");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("--disable-notifications");
            driver = new ThreadLocal<WebDriver>() {
                @Override
                protected WebDriver initialValue(){
                    return new ChromeDriver(options);
                }
            };
        }
        else if(configuration.getIsHeadlessTrue()){
            final ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1280,800");
            options.addArguments("--allow-insecure-localhost");
            driver = new ThreadLocal<WebDriver>() {
                @Override
                protected WebDriver initialValue() {
                    return new ChromeDriver(options);
                }
            };
        }
    }
}
