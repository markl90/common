package com.netbuilder.test.common.driverfactory;

import com.netbuilder.test.common.configuration.EnvironmentConfig;

public class DriverConfiguration {

    private DriverType driverType;
    private Boolean isHeadless;


    public DriverConfiguration(DriverType driverType, EnvironmentConfig configuration) {
        this.driverType = driverType;
        this.isHeadless =  Boolean.valueOf(configuration.getConfig().getString("run-headless"));
    }

    public DriverType getDriverType() {
        return driverType;
    }

    public Boolean getIsHeadlessTrue() { return isHeadless; }

}
