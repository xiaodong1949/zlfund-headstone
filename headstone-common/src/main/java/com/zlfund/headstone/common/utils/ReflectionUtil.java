package com.zlfund.headstone.common.utils;

import java.lang.reflect.Type;

/**
 * 反射工具类
 * @author Yang Xiaodong
 * @since: 2017年2月24日
 */
public class ReflectionUtil {
    /**
     * 定义class后缀
     */
    private static final String TYPE_NAME_PREFIX = "class ";

    /** 
     * 根据类型获取class name
     * @param type
     * @return
     * @return 
     * @create: 2017年2月24日
     * @author: Yang Xiaodong
     * @history: 
     */
    public static String getClassName(Type type) {
        if (type == null) {
            return "";
        }
        String className = type.toString();
        if (className.startsWith(TYPE_NAME_PREFIX)) {
            className = className.substring(TYPE_NAME_PREFIX.length());
        }
        return className;
    }

    /** 
     * 根据类型获取class
     * @param type
     * @return
     * @throws ClassNotFoundException
     * @return 
     * @create: 2017年2月24日
     * @author: Yang Xiaodong
     * @history: 
     */
    public static Class<?> getClass(Type type) throws ClassNotFoundException {
        String className = getClassName(type);
        if (className == null || className.isEmpty()) {
            return null;
        }
        return Class.forName(className);
    }

    /** 
     * 根据类型获取对象
     * @param type
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @return 
     * @create: 2017年2月24日
     * @author: Yang Xiaodong
     * @history: 
     */
    public static Object newInstance(Type type) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = getClass(type);
        if (clazz == null) {
            return null;
        }
        return clazz.newInstance();
    }
}
