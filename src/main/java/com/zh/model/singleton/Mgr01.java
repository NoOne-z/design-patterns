package com.zh.model.singleton;

/**
 * @author z
 * @date 2021/5/30
 *
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐实用
 * 缺点：不管用不用，都实例化
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE =new Mgr01();
    private Mgr01(){
    };
    public static Mgr01 getInstance(){
        return INSTANCE;
    }
    public void m(){
        //业务代码
    }



    public static void main(String[] args){
        Mgr01 instance = Mgr01.getInstance();
        Mgr01 instance1 = Mgr01.getInstance();
        System.err.println(instance==instance1);
    }

}
