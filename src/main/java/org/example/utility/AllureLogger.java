package org.example.utility;

import io.qameta.allure.Step;

import java.util.logging.Logger;
import java.util.logging.LogManager;

public class AllureLogger {

    //private static final Logger logger = LogManager.getLogManager().getLogger();

    private AllureLogger() {
        // hide default constructor for this util class
    }

    /**
     * Uses the @Step annotation to log the given log message to Allure.
     *
     * @param message the message to log to the allure report
     */
    @Step("{0}")
    public static void logToAllure(String message) {
        //logger.debug("Logged to allure: " + message);
    }

}