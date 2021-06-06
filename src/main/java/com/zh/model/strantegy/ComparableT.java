package com.zh.model.strantegy;

/**
 * @author z
 * @date 2021/5/30
 * 与自定义的Comparable相比，添加泛型
 */
public interface ComparableT<T> {
    int compareTo(T t);
}
