package com.zh.model.singleton;

/**
 * @author z
 * @date 2021/5/30
 * 与01意思一样
 *
 */
public class Mgr02 {
    private static final Mgr02 INSTANCE;
    static {
        INSTANCE=new Mgr02();
    }
    private Mgr02(){
    }
    public static Mgr02 getInstance(){
        return INSTANCE;
    }

    public void m(){
        //业务代码
    }



    public static void main(String[] args){
        Mgr02 instance = Mgr02.getInstance();
        Mgr02 instance1 = Mgr02.getInstance();
        System.err.println(instance==instance1);
    }

}
