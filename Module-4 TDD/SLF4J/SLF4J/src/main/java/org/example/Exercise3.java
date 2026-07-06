package org.example;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Exercise3 {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Exercise3.class);

    public static void main(String[] args) {
        logger.info("Info");
        logger.warn("Warn");
        logger.trace("Trace");
        logger.debug("Debug");
        logger.error("Error");
    }
}
