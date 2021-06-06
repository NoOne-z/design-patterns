package com.zh.model.strantegy;

/**
 * @author z
 * @date 2021/5/31
 * 模拟jdk 自定义Comparator，要区分jdk的Comparator
 */
public interface Comparator<T> {
    int compare(T t1,T t2);
}
