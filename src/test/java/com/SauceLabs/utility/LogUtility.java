package com.SauceLabs.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtility {

   // private static Logger Log = Logger.getLogger(Logger.class.getName());//
   public static Logger Log;
    public static void startTestCase(String sTestCaseName) {
        Log = Logger.getLogger("SauceLabs");
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/configuration/log4j.properties");
        Log.info("****************************************************************************************");
        Log.info("#################                " + sTestCaseName + "          ########################");
        Log.info("****************************************************************************************");
    }

    // This is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName) {
        Log.info("####################            " + "-E---N---D-" + "             #######################");


    }

    // Need to create these methods, so that they can be called
    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }
}
