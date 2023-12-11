package org.riceCooker;

import org.riceCooker.classes.RiceCooker;

import static org.riceCooker.classes.RandomThrow.suddenShutdown;
import static org.riceCooker.utils.Console.input;
import static org.riceCooker.utils.Console.show;
import static org.riceCooker.utils.Messages.getMessage;
import static org.riceCooker.utils.Ui.menu;
import static org.riceCooker.utils.Ui.result;
import static org.riceCooker.utils.Ui.simpleResult;
import static org.riceCooker.utils.Validator.validateNumber;

public class Handler {

    private static void plugHandler(RiceCooker rc) {
        String title = !rc.getPlug() ? "Plug" : "Unplug";
        rc.togglePlug();
        show(result, new String[]{title, "Done"}, title.length());
    }

    private static void powerHandler(RiceCooker rc) {
        String title = !rc.getPower() ? "Power on" : "Power off";
        show(title, new String[]{title});
        rc.togglePower();
        show(result, new String[]{title, "Done"}, title.length());
    }

    private static void addWaterHandler(RiceCooker rc) {
        String title = "Add water cups.";
        show(title, new String[]{title});
        String cups = input("Number of cups of water you want to add : ");
        validateNumber(cups);
        rc.addWater(Integer.parseInt(cups));
        show(simpleResult, new String[]{"Done !"}, title.length());
    }

    private static void addRiceHandler(RiceCooker rc) {
        String title = "Add Rice cups.";
        show(title, new String[]{title});
        String cups = input("Number of cups of rice you want to add : ");
        validateNumber(cups);
        rc.addRice(Integer.parseInt(cups));
        show(simpleResult, new String[]{"Done !"}, title.length());
    }

    private static void removeWaterHandler(RiceCooker rc) {
        String title = "Remove water cups.";
        show(title, new String[]{title});
        String cups = input("Number of cups of water you want to remove : ");
        validateNumber(cups);
        rc.removeWater(Integer.parseInt(cups));
        show(simpleResult, new String[]{"Done !"}, title.length());
    }

    private static void discardRiceHandler(RiceCooker rc) {
        String title = "Discard Rice cups.";
        show(title, new String[]{title});
        String cups = input("Number of cups of rice you want to discard : ");
        validateNumber(cups);
        rc.discardRice(Integer.parseInt(cups));
        show(simpleResult, new String[]{"Done !"}, title.length());
    }

    static void handler(RiceCooker rc) {
        suddenShutdown();
        show(menu, new String[]{
                Integer.toString(rc.getWaterCupNumber()),
                Integer.toString(rc.getRiceCupNumber()),
                rc.getPlug() ? "Plugged" : "Unplugged",
                rc.getPower() ? "On" : "Off"
        });
        String choice = input("=> ");

        switch (choice) {
            case "1":
                plugHandler(rc);
                break;
            case "2":
                powerHandler(rc);
                break;
            case "3":
                addWaterHandler(rc);
                break;
            case "4":
                addRiceHandler(rc);
                break;
            case "5":
                removeWaterHandler(rc);
                break;
            case "6":
                discardRiceHandler(rc);
                break;
            case "7":
                throw new RuntimeException(getMessage("kill:quite"));
            default:
                throw new RuntimeException(getMessage("error:bad-choice"));
        }
    }
}
