package com.bootcamp.etl;

public class Config {

    public static String get(String key) {
        String envKey = key.toUpperCase().replace('.', '_');
        String value = System.getenv(envKey);
        if (value != null) return value;

        throw new RuntimeException("Environment variable " + envKey + " not set!");
    }
}