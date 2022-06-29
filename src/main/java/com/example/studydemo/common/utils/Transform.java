package com.example.studydemo.common.utils;

public class Transform {

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
}
