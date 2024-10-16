package Reports;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

public class LoggerSingleton {  
    private static LoggerSingleton instance;  
    private Logger logger;  

    // Private constructor to prevent instantiation  
    private LoggerSingleton() {  
        logger = Logger.getLogger("SeleniumLogger");  
        try {  
            FileHandler fileHandler = new FileHandler("selenium.log",true);  
            fileHandler.setFormatter(new SimpleFormatter()); 
            //logger.addAppender(addHandler(fileHandler););
            //logger.addHandler(fileHandler);  
            
            logger.addAppender((Appender) fileHandler);
        } catch (Exception e) {  
            logger.warn("Failed to set up logger: " + e.getMessage());  
        }  
    }  

    // Public method to provide access to the instance  
    public static LoggerSingleton getInstance() {  
        if (instance == null) {  
            instance = new LoggerSingleton();  
        }  
        return instance;  
    }  

    public void info(String message) {  
        logger.info(message);  
    }  

    public void warning(String message) {  
        logger.warn(message);  
    }  

    public void severe(String message) {  
        logger.error(message);  
    }  

    // Additional logging methods can be added as needed  
}  