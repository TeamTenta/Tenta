package com.tenta.tentaserver.utils;

import java.util.Map;
import java.util.Objects;

public class StringUtils {

    private StringUtils() {
    }

    public static String replaceAll(String inputString, Map<String, String> map) {
        if (Objects.isNull(map)) {
            return inputString;
        }

        String modifyString = inputString;
        for (Map.Entry<String, String> mapEntry : map.entrySet()) {
            modifyString = modifyString.replaceAll(mapEntry.getKey(), mapEntry.getValue());
        }
        modifyString = modifyString.replaceAll("[{}]", "");
        return modifyString;
    }
}
