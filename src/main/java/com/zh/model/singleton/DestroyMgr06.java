package com.zh.model.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 *
 * @author z
 * @date 2021/5/30
 * 反射，序列化，克隆三种方式破坏双重检测
 */
public class DestroyMgr06 implements Serializable,Cloneable{
    private static volatile DestroyMgr06 INSTANCE;
    private DestroyMgr06(){
    }
    public static DestroyMgr06 getInstance() {
        //这次判断很有必要
        if (INSTANCE == null) {
            synchronized (DestroyMgr06.class){
                //双重检查
                if(INSTANCE==null){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new DestroyMgr06();
                }
            }
        }
        return INSTANCE;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public static void main(String[] args) throws Exception {
        //通过getInstance()获取
        DestroyMgr06 singleton = DestroyMgr06.getInstance();
        System.out.println("singleton的hashCode:"+singleton.hashCode());
        //通过反射获取
        Constructor<DestroyMgr06> constructor = DestroyMgr06.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        DestroyMgr06 reflex = constructor.newInstance();
        System.out.println("reflex的hashCode:"+reflex.hashCode());
        //通过克隆获取
        DestroyMgr06 clob = (DestroyMgr06) DestroyMgr06.getInstance().clone();
        System.out.println("clob的hashCode:"+clob.hashCode());
        //通过序列化，反序列化获取
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(DestroyMgr06.getInstance());
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        DestroyMgr06 serialize = (DestroyMgr06) ois.readObject();
        if (ois != null) {
            ois.close();
        }
        if (bis != null) {
            bis.close();
        };
        if (oos != null){
            oos.close();
        }
        if (bos != null){
            bos.close();
        }
        System.out.println("serialize的hashCode:"+serialize.hashCode());
    }
}
