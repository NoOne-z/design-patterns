package com.zh.model.singleton;

/**
 * @author z
 * @date 2021/5/30
 * 完美中的完美！
 * effective java作者
 * 不仅解决线程同步问题，还可以防止反序列化,反射，克隆
 *
 * 枚举防止反射，克隆及序列化破环单例模式的原理
 * 克隆：
 * 一个普通的类要是clone必须实现java.lang.Cloneable接口，重写clone()方法；
 * 而enum是不被允许重写clone(),因为Enum类已经将clone()方法定义为final了，
 * 并且Enum在使用clone()时直接抛出异常。
 * 反射和序列化（和普通类和枚举类不同的实现方式有关，枚举类无构造方法）
 * https://www.cnblogs.com/call-me-pengye/p/11214435.html
 */
public enum Mgr08 {
    INSTANCE;
    public void m(){
        //业务代码
    }
    public static void main(String[] args) {
        for(int i =0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }
}
