package com.tenta.tentaserver.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Strings {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
