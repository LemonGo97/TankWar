package cn.lemongo97.tankwar;

import java.lang.reflect.InvocationTargetException;

public class ClassUtil {
    private ClassUtil(){}

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (T) Class.forName(className).getDeclaredConstructor().newInstance();
    }

}
