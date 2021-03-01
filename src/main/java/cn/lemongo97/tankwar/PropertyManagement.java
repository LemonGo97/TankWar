package cn.lemongo97.tankwar;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManagement {
    static Properties properties = new Properties();

    static {
        try {
            InputStream resourceAsStream = PropertyManagement.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (properties == null) return null;
        return properties.get(key);
    }

    public static void main(String[] args) {
        System.out.println(get("tanksNum"));
    }
}
