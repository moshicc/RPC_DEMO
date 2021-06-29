package com.zcc.zccrpc.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
// ctrl +shift + t  生成测试方法
/**
 * 反射工具类
 */
public class ReflectionUtils {
    /**
     * 根据Class 创建对象
     * @param clazz
     * @param <T>
     * @return 创建好的对象
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    /**
     * 根据class获取所有公共方法
     * @param clazz
     * @return
     */
    public static Method[] getPublicMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pmethods = Arrays.stream(methods)
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .collect(Collectors.toList());
        return pmethods.toArray(new Method[0]);
    }

    /**
     * 调用指定对象的指定方法
     * @param object 被调用方法的对象
     * @param method 被调用的方法
     * @param args 方法的参数
     * @return 返回结果
     */
    public static Object invoke(Object object, Method method, Object... args) {
        try {
            //当方法为静态方法时，object为null，因为静态方法存在于类上，而非随对象产生
            return method.invoke(object, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
}
