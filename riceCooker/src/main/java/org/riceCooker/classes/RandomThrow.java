package org.riceCooker.classes;

import java.util.Random;

import static org.riceCooker.utils.Messages.getMessage;

public class RandomThrow {

    private static int getRandom() {
        Random random = new Random();
        return Math.round(random.nextFloat() * 50);
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

}
