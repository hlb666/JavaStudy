package com.example.studydemo.common.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    /**
     * objectTypeTransfer
     *
     * @param srcObject
     * @param targetClass
     * @return
     * @throws
     * @author lixiangkun
     * @date 2019/11/18 16:39
     * @see
     * @since 1.0
     **/
    public static <S, T> T objectTypeTransfer(S srcObject, Class<T> targetClass)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        final Method[] declaredMethods = srcObject.getClass().getDeclaredMethods();

        final Constructor<T> defaultTargetClassDeclaredConstructor = targetClass.getDeclaredConstructor();
        defaultTargetClassDeclaredConstructor.setAccessible(true);
        final T t = defaultTargetClassDeclaredConstructor.newInstance();

        for (Method srcMethod : declaredMethods) {

            if (isGetMethod(srcMethod)) {
                final Object srcPropertiesValue = srcMethod.invoke(srcObject);
                final Class<?> srcPropertiesType = srcMethod.getReturnType();

                final String setMethodName = transferGetMethodToSetMethod(srcMethod);
                try {
                    final Method targetSetMethod = targetClass.getDeclaredMethod(setMethodName, srcPropertiesType);
                    targetSetMethod.setAccessible(true);
                    targetSetMethod.invoke(t, srcPropertiesValue);
                } catch (Exception ignored) {
                    //忽略这个错误
                }

            }
        }
        return t;
    }

    /**
     * 将DTO对象转换成DO对象，后续进行数据库操作
     *
     * @param srcObject
     * @param <S>
     * @return
     */
    public <S, T> T transferToDomainDo(S srcObject, Class<T> tClass) {
        if (srcObject == null) {
            return null;
        }
        T t = null;
        try {
            t = BeanUtils.objectTypeTransfer(srcObject, tClass);
        } catch (Exception e) {
            System.out.println(e);
        }
        return t;
    }

    private static boolean isGetMethod(Method srcMethod) {
        return srcMethod.getName().startsWith("get");
    }

    private static String transferGetMethodToSetMethod(Method srcMethod) {
        return "set" + srcMethod.getName().substring(3);
    }

}
