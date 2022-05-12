package com.pointr.TestUtility;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Log {

        private static Logger Log = LogManager.getLogger(Log.class.getName());

        public static void startTestCase(String startedTestCaseName){
            Log.info("*****************************************************************************************");
            Log.info("$$$ " + startedTestCaseName + " has been started $$$");
            Log.info("*****************************************************************************************");
        }

        public static void endTestCase(String endedTestCaseName){
            Log.info("*****************************************************************************************");
            Log.info("∆∆∆ " + endedTestCaseName + " has been successfully completed ∆∆∆");
            Log.info("*****************************************************************************************");
        }

    public static void info(String message) {
        Log.info(message);
    }

    }
