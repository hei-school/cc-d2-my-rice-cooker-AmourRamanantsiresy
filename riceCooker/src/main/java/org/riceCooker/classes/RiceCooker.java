package org.riceCooker.classes;

import java.util.Random;

import static org.riceCooker.utils.Messages.getMessage;
import static org.riceCooker.classes.RandomThrow.waterLeakage;

public class RiceCooker {

    private final int maxCupNumber = 10;
    private int waterCupNumber = 0;
    private int riceCupNumber = 0;
    private boolean plug = false;
    private boolean power = false;

    public RiceCooker() {}

    public void addWater(int cups) {
        waterLeakage();
        if (waterCupNumber + riceCupNumber + cups > maxCupNumber) {
            throw new RuntimeException(getMessage("error:max-capacity"));
        }
        waterCupNumber += cups;
    }

    public void addRice(int cups) {
        if (waterCupNumber + riceCupNumber + cups > maxCupNumber) {
            throw new RuntimeException(getMessage("error:max-capacity"));
        }
        riceCupNumber += cups;
    }

    public void removeWater(int cups) {
        waterLeakage();
        if (waterCupNumber < cups) {
            throw new RuntimeException(getMessage("error:not-enough-water"));
        }
        waterCupNumber -= cups;
    }

    public void discardRice(int cups) {
        if (riceCupNumber < cups) {
            throw new RuntimeException(getMessage("error:not-enough-rice"));
        }
        riceCupNumber -= cups;
    }

    public void togglePlug() {
        Random random = new Random();
        int magicNumber = random.nextInt(100);
        plug = !power;
    }

    public void togglePower() {
        if (!plug) {
            throw new RuntimeException(getMessage("error:power-not-plugged"));
        }
        power = !power;
    }

    public int getWaterCupNumber() {
        return waterCupNumber;
    }

    public int getRiceCupNumber() {
        return riceCupNumber;
    }

    public boolean getPlug() {
        return plug;
    }

    public boolean getPower() {
        return power;
    }
}

