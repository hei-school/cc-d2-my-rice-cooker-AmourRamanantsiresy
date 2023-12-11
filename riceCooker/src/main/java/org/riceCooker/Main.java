package org.riceCooker;

import org.riceCooker.classes.RiceCooker;

import static org.riceCooker.Handler.handler;
import static org.riceCooker.utils.Console.input;
import static org.riceCooker.utils.Console.show;
import static org.riceCooker.utils.Console.showBanner;
import static org.riceCooker.utils.Constants.getUi;

public class Main {
    public static void main(final String[] args) {

        boolean run = true;

        RiceCooker riceCooker = new RiceCooker();

        while (run) {
            showBanner();

            try {
                handler(riceCooker);
            } catch (Exception e) {
                if (e.getMessage().contains("kill")) {
                    run = false;
                }
                show(
                        getUi("error"),
                        new String[]{e.getMessage()},
                        null
                );
            }
            input("Type enter to continue.");
        }
    }
}
