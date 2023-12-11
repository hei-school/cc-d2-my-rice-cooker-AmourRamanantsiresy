package org.riceCooker.classes;

import java.util.Random;

import static org.riceCooker.utils.Constants.getMessage;

public final class RandomThrow {
    private static final int MAX_RANDOM_NUMBER = 50;

    private static int getRandom() {
        Random random = new Random();
        return Math.round(random.nextFloat() * MAX_RANDOM_NUMBER);
    }

    private static boolean shouldThrow() {
        return getRandom() == getRandom();
    }

    public static void waterLeakage() {
        if (shouldThrow()) {
            throw new RuntimeException(getMessage("error:water-leakage"));
        }
    }

    public static void suddenShutdown() {
        if (shouldThrow()) {
            throw new RuntimeException(getMessage("error:no-electricity"));
        }
    }

    private RandomThrow() {
    }
}
