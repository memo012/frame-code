package com.adminsys.mybatis.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    private static Properties properties = null;

//    static {
////        properties = loadProperty();
////    }

    public PropertiesUtils(String configPath){
        properties = loadProperty(configPath);
    }

    private Properties loadProperty(String configPath) {
        Properties p = new Properties();
        try {
            p.load(getInputStream(configPath));
            if (p == null || p.isEmpty()) {
                System.out.println("The property file cannot be load");
            }
        } catch (IOException e) {
            System.out.println("Exception happened in loadProperty()" + e);
        }

        return p;
    }

    public String getValue(String key) {
        if (properties.containsKey(key)) {
            String value = properties.getProperty(key);
            if (isValue(value)) {
                value = value.trim();
            }
            return value;
        } else {
            return "";
        }
    }

    public boolean isBlank(String str) {
        if (str == null || str.isEmpty() || (str.trim()).isEmpty() || str.equals("") || str.trim().equals("")
                || str.equals("null") || str.trim().equals("null")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValue(String str) {
        return !isBlank(str);
    }

    private InputStream getInputStream(String path)
            throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

        if (is == null) {
            throw new FileNotFoundException(path + " cannot be opened because it does not exist");
        }
        return is;
    }

    public static void main(String[] args) {
    }
}