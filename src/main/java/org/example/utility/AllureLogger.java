package org.example.utility;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AllureLogger {
    private static final Logger logger = LogManager.getLogger(AllureLogger.class);

    public static void info(String message) {
        logger.info(message);
        attachLogToAllure("INFO: " + message);
    }

    public static void error(String message) {
        logger.error(message);
        attachLogToAllure("ERROR: " + message);
    }

    @Attachment(value = "{logMessage}", type = "text/plain")
    private static String attachLogToAllure(String logMessage) {
        return logMessage;
    }
}