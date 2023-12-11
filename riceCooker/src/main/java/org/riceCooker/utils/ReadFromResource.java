package org.riceCooker.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ReadFromResource {

    public String read(final String path) {
        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("assets/" + path);
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
    }
}
