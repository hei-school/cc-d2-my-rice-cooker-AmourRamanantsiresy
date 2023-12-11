package org.riceCooker.utils;

import java.util.Scanner;

import static org.riceCooker.utils.Constants.getUi;

/**
 * Manipulation of console
 */
public class Console {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ReadFromResource RESOURCE_READER =
            new ReadFromResource();

    public static void show(
            final String path,
            final String[] toReplace,
            final Integer toReplaceLength
    ) {
        String replacePattern = "xxx";
        String repeatPattern = "═";
        String content = RESOURCE_READER.read(path);


        if (toReplace != null) {
            for (String value : toReplace) {
                content = content.replaceFirst(replacePattern, value);
            }

            int repetitionLength = toReplaceLength != null
                    ? toReplaceLength
                    : toReplace[0].length();
            content = content.replaceFirst(
                    replacePattern,
                    repeatPattern.repeat(repetitionLength)
            );
        }
        System.out.println(content);
    }


    public static void show(final String toShow, final String[] toReplace) {
        show(toShow, toReplace, null);
    }

    public static void show(final String toShow) {
        show(toShow, null, null);
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // For Windows
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                // For Unix/Linux/Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showBanner() {
        clearConsole();
        show(getUi("banner"), null, null);
    }

    public static String input(final String question) {
        System.out.println(question);
        return SCANNER.nextLine();
    }
}
