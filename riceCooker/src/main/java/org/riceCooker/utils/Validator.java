package org.riceCooker.utils;

import static org.riceCooker.utils.Messages.getMessage;

public class Validator {
    public static void validateNumber(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException(getMessage("error:bad-input-value"));
        }
    }
}