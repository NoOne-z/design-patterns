package com.zh.model.singleton;

/**
 * @author z
 * @date 2021/5/30
 * 现在最完美
 * 静态内部类
 * jvm保证单例
 * 加载外部类时不会加载内部类，实现懒加载
 */
public class Mgr07 {
    private Mgr07(){
    }
    //静态内部类
    private static class Mgr07Holder{
        //初始化外部类对象
        private final static Mgr07 INSTANCE=new Mgr07();
    }
    public static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
    }

    public void m(){
        //业务代码
    }



    public static void main(String[] args) {
        for(int i =0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }
}
