package com.netbuilder.test.common.session;

import com.netbuilder.test.common.configuration.EnvironmentConfig;
import com.netbuilder.test.common.driverfactory.DriverConfiguration;
import com.netbuilder.test.common.driverfactory.DriverManager;
import com.netbuilder.test.common.driverfactory.DriverManagerFactory;
import com.netbuilder.test.common.driverfactory.DriverType;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class Session {

    // Driver config and general config objects
    private DriverType driverType;
    private DriverManager driverManager;
    private DriverConfiguration driverConfiguration;
    private EnvironmentConfig configuration;
    // Shared data map to pass & retrieve data during tests
    private Map<String, Object> sharedData;


    public Session() {
        // pull configuration to get paramaters (e.g. --headless & driver type).
        configuration = new EnvironmentConfig();
        // Set the driver type (according to config).
        driverType = configureDriverType();
        // Create the correct driver manager (according to browser in config).
        driverManager = createManager();
        // Create a HashMap to store data during a test case.
        sharedData = new HashMap<>();
    }

    public DriverManager createManager(){
        driverConfiguration = new DriverConfiguration(driverType, configuration);
        driverManager = DriverManagerFactory.getLocalManager(driverConfiguration);
        return driverManager;
    }

    public DriverType configureDriverType() {
        String type = System.getProperty("browser").toLowerCase();
        DriverType driver;
        driver = (      type.contains("chr")) ? DriverType.CHROME :
                        type.contains("fox") ? DriverType.FIREFOX :
                        type.equals("ie")|| type.equals("internetexplorer") ? DriverType.IE : DriverType.CHROME;
        if (type == null) {
            return DriverType.CHROME;
        }
        return driver;
    }

    public WebDriver getDriver(){
        return driverManager.getDriver();
    }

    public EnvironmentConfig getConfiguration(){
        return configuration;
    }

    public String getBaseUrl(){
        return configuration.getBaseUrl();
    }

    public String getReferenceEnvironmentUrl(){
        return configuration.getReferenceUrl();
    }

    public void addData(String key, String value) {
        sharedData.put(key, value);
    }

    public String getData(String key) {
        return sharedData.get(key).toString();
    }

    public void stopDriver() {
        driverManager.stopDriver();
    }

}
