package com.pcm.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class PropertiesUtils {
    private static Properties prop = new Properties();

    static {
        try {
            log.info("load properties ... ");
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("global.properties"));
            log.info("load properties success.");
        } catch (IOException e) {
            log.error("load properties failed.", e);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    public static String getGBKPropertyValue(String key) {
        try {
            String value = prop.getProperty(key);
            value = new String(value.getBytes("ISO8859-1"), "UTF-8");
            return value;
        } catch (Exception e) {
            log.error("com.pcm.util.PropertiesUtils.getGBKPropertyValue Exception", e);
        }

        return null;
    }

    public static String getProperty(String key, String defaultValue) {
        return StringUtils.isEmpty(prop.getProperty(key)) ? defaultValue : prop.getProperty(key);
    }

    public static String getPropertyReplaced(String key, String[] replacements) {
        try {
            return String.format(prop.getProperty(key), replacements);
        } catch (Exception e) {
            log.error("getReplacedValue failed. key={}, replacements={}", key, replacements, e);
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(PropertiesUtils.getProperty("storage_max_size"));
    }
}
