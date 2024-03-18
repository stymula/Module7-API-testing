package org.example.utility;

import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.response.Response;


public abstract class FrameworkUtility {

    protected static Properties properties;

    public static String readConfigurationFile(String key) {
        try{
            properties = new Properties();
            properties.load(new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH));

        } catch (Exception e){
            System.out.println("Cannot find key: "+key+" in Config file due to exception : "+e);
        }
        return properties.getProperty(key).trim();
    }

    public void logResponseAsString(Response response) {
        AllureLogger.info(response.asString());
        System.out.println(response.asString());
    }
}