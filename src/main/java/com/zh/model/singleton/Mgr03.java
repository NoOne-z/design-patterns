package com.zh.model.singleton;

/**
 * @author z
 * @date 2021/5/30
 * 懒汉式
 * 按需初始化，但是线程不安全
 */
public class Mgr03 {
    //final 必须初始化
    private static Mgr03 INSTANCE;
    private Mgr03(){
    }
    public static Mgr03 getInstance(){
        //问题：多线程时，第一个线程判断为空，切换第二个线程判断依然为空，两线程都会new Mgr03()
        if(INSTANCE==null){
            //为测试多线程情况，增睡眠时间
            try {
                //Thread.sleep(0);触发操作系统立刻重新进行一次CPU竞争
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            INSTANCE=new Mgr03();
        }
        return INSTANCE;
    }

    public void m(){
        //业务代码
    }



    public static void main(String[] args) {
        for(int i =0;i<100;i++){
            new Thread(()->{
                //哈希码相同，对象也可能不同。
                //同一个类的不同对象哈希码是不同的
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
