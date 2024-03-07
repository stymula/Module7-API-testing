package org.example.utility;

import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.service.BoardService;

public class BaseTest {

    protected BoardService boardService = new BoardService();

}

//public class BaseTest {
//
//    protected static RequestSpecification requestSpec;
//    protected static ResponseSpecification responseSpec;

//    public static String readConfigurationFile(String key) {
//        try{
//            properties = new Properties();
//            properties.load(new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH));
//
//        } catch (Exception e){
//            System.out.println("Cannot find key: "+key+" in Config file due to exception : "+e);
//        }
//        return properties.getProperty(key).trim();
//    }
//}
