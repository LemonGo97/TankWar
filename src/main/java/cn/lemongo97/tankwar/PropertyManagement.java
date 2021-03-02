package cn.lemongo97.tankwar;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManagement {
    private static final Properties properties = new Properties();

    private PropertyManagement(){}

    static {
        try {
            InputStream resourceAsStream = PropertyManagement.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        return properties.get(key);
    }

    public static Integer getInt(String key) {
        return Integer.parseInt((String)properties.get(key));
    }

    public static String getString(String key) {
        return (String)properties.get(key);
    }

    public static void main(String[] args) {
        System.out.println(get("tanksNum"));
    }
}
