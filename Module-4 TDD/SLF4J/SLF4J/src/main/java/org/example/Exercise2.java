package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise2 {
    private static final Logger logger = LoggerFactory.getLogger(Exercise2.class);

    public static void main(String[] args) {
        int oldage = 23;
        int newage = 33;

        logger.info("Raj was {} in college. Now he is {}.", oldage, newage);
    }
}
