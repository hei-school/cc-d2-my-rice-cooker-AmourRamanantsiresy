package org.riceCooker.utils;

import static org.riceCooker.utils.Constants.getMessage;

/**
 * validator
 */
public class Validator {
    public static void validateNumber(final String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException(getMessage("error:bad-input-value"));
        }
    }
}
