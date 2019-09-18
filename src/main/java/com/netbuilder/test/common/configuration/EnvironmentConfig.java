package com.netbuilder.test.common.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class EnvironmentConfig extends com.netbuilder.test.common.configuration.ConfigurationManager {

    private Config config;

    private String baseUrl;
    private String referenceUrl;
    private String reportPath;
    private Set configParamaters;

    public EnvironmentConfig() {
        loadConfigFile();
        loadConfiguration();
    }

    public void loadConfigFile(){
        config = ConfigFactory.load(defaultConfigurationPath).getConfig("Params").resolve();
    }

    /**
     * This method loads all values under "params" from the config file as system properties at runtime.
     * (base & reference url's assigned to variables as well).
     * Must be called after loadConfigFile()
     */
    public void loadConfiguration(){
        baseUrl = config.getString("base-url");
        referenceUrl = config.getString("reference-environment");

        configParamaters = new HashSet<String>();
        configParamaters.addAll(config.entrySet());
        for(Object param: configParamaters){
            String key =  param.toString().split("=")[0];
            System.setProperty(key, config.getString(key));
        }
    }

    /**
     * Gets the (String) application base url for use and combination with url extensions for page navigation.
     * This method includes ternary operator to add "/" to the end of the url to ensure it can be combined with other strings without producing an invalid url
     * @return (String) application base url
     */
    public String getBaseUrl() {
        return baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
    }

    /**
     * Gets the (String) application reference url for use and combination with url extensions for page navigation.
     * This method includes ternary operator to add "/" to the end of the url to ensure it can be combined with other strings without producing an invalid url
     * @return (String) application reference url
     */
    public String getReferenceUrl() {
        return referenceUrl.endsWith("/") ? referenceUrl : referenceUrl + "/";
    }

    public Config getConfig(){
        return config;
    }

}
