package org.riceCooker.utils;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static void show(String toShow, String[] toReplace, Integer toReplaceLength) {
        String replacePattern = "xxx";
        String repeatPattern = "═";
        String content = toShow;

        if (toReplace != null) {
            for (String value : toReplace) {
                content = content.replaceFirst(replacePattern, value);
            }
            content = content.replaceFirst(
                    replacePattern,
                    repeatPattern.repeat(toReplaceLength != null ? toReplaceLength : toReplace[0].length())
            );
        }
        System.out.println(content);
    }


    public static void show(String toShow, String[] toReplace){
        show(toShow, toReplace, null);
    }

    public static void show(String toShow){
        show(toShow, null, null);
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // For Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Unix/Linux/Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showBanner(){
        clearConsole();
        show(Ui.banner, null, null);
    }

    public static String input(String question){
        System.out.println(question);
        return scanner.nextLine();
    }
}
