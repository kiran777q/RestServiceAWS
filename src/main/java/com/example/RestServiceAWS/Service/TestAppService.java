package com.example.RestServiceAWS.Service;

import com.example.RestServiceAWS.DTO.NameInt;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class TestAppService implements NameInt {
    String name;
    @Autowired
    @Value("${MY_NAME}")
    String propertyName;
    Properties properties;
    //@Autowired
    //private DataSourceClient dataSourceClient;
    final static Logger logger = LoggerFactory.getLogger(TestAppService.class);

    public TestAppService(@Value("${MY_NAME}") String Name) {

        this.name = Name;
    }

    @PostConstruct
    public void init() {
//        properties = new Properties();
//        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
//            properties.load(inputStream);
//            logger.info("Property file contents: {}", properties);
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        }

        logger.info("Property Name from the property file is : "+propertyName);
    }

    public void setPropertyName(@Value("${MY_NAME}") String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public String MyName() {

        try  {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("local.properties");
            properties = new Properties();
            properties.load(inputStream);
            logger.info("Property file contents: {}", properties);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        //System.out.println("Name from the property file is : "+properties.getProperty("MY_NAME"));
        System.out.println("printing property name : "+properties.getProperty("MY_NAME"));
        System.out.println("Name Before Changing it is : "+name);

        name = "I am Changing My Name to "+properties.getProperty("MY_NAME");
        //dataSourceClient.getConnection();
        return name;
    }
}
