package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Exercise1 {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Exercise1.class);

    public static void main(String[] args) {
        logger.error("This is an Error Message");
        logger.warn("This is a Warning Message");
    }
}
