package com.netbuilder.test.common.configuration;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public abstract class ConfigurationManager{

    protected final String defaultConfigurationPath = "config/environment.conf";

    public abstract void loadConfiguration();

    public File getConfigFile() {

        String configEnvironmentVariable = System.getenv("TEST_CONFIG");

        if (configEnvironmentVariable == null) {
            try {
                File config = new File(Thread.currentThread().getContextClassLoader().getResource(defaultConfigurationPath).getFile());
                return config;
            } catch (Exception fileNotFound) {
                fileNotFound.printStackTrace();

            }
        }
        else{
            try {
                File customConfig = new File(configEnvironmentVariable + "/environment.conf");
                return customConfig;
            }
            catch (Exception fileNotFound){
                fileNotFound.printStackTrace();
            }
        }
        return null;
    }


}
