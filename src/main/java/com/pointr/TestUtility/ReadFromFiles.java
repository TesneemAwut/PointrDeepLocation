package com.pointr.TestUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadFromFiles {

    public static String readConfigProperties(String key) {
        Properties properties = new Properties();
        String value;
        String workingDir = System.getProperty("user.dir");
        try {
            properties.load(new FileInputStream(workingDir + File.separator + "config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        value = properties.getProperty(key);
        return value;
    }

    public static Map<String, Integer> getHashMapWithProperties() {
        HashMap<String, Integer> map = new HashMap<>();
        Properties prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("result.properties");
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some issue finding or loading file....!!! " + e.getMessage());
        }
        for (String key : prop.stringPropertyNames()) {
            String value = prop.getProperty(key);
            map.put(key, Integer.valueOf(value));
        }
        return map;
    }

}