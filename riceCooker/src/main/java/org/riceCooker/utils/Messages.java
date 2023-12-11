package org.riceCooker.utils;

import java.util.HashMap;
import java.util.Map;

public class Messages {

    private static final Map<String, String> messages = new HashMap<>();

    static {
        messages.put("error:max-capacity", "Error : Maximum capacity exceeded.");
        messages.put("error:not-enough-water", "Error : You didn't put in enough water.");
        messages.put("error:not-enough-rice", "Error : You didn't put in enough rice.");
        messages.put("error:power-not-plugged", "Error : Cannot power on, plug and retry.");
        messages.put("error:plug-explosion", "Error : There was a big error so the rice cooker expose.");
        messages.put("error:bad-input-value", "Error : Bad input value.");
        messages.put("error:bad-choice", "Error : The specified choice do not exist.");
        messages.put("error:no-electricity", "kill : The electricity was cut off and the appliance stopped.");
        messages.put("error:water-leakage", "kill : There was a water leak, and the appliance stopped.");
        messages.put("kill:quite", "kill");
    }

    public static String getMessage(String key){
        return messages.get(key);
    }
}
