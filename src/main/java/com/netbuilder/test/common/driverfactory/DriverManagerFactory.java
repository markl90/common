package com.netbuilder.test.common.driverfactory;

import com.netbuilder.test.common.driverfactory.drivermanagers.ChromeDriverManager;
import com.netbuilder.test.common.driverfactory.drivermanagers.FireFoxDriverManager;
import com.netbuilder.test.common.driverfactory.drivermanagers.InternetExplorerDriverManager;

public class DriverManagerFactory {

    public static DriverManager getLocalManager(DriverConfiguration configuration){

        DriverManager driverManager;

        switch(configuration.getDriverType()){
            case CHROME:
                driverManager = new ChromeDriverManager(configuration);
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager(configuration);
                break;
            case IE:
                driverManager = new InternetExplorerDriverManager(configuration);
                break;
            default:
                driverManager = new ChromeDriverManager(configuration);
        }
        return driverManager;
    }
}
