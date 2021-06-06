package com.zh.model.singleton;

/**
 * @author z
 * @date 2021/5/30
 * 以前最完美
 * 可被反射，序列化，克隆三种方式破坏
 *
 * 如何防止反射、克隆、序列化对单例模式的破环
 * 1、防止反射破环(虽然构造方法已私有化，但通过反射机制使用newInstance()方法构造方法也是可以被调用):
 * 首先定义一个全局变量开关isFristCreate默认为开启状态
 * 当第一次加载时将其状态更改为关闭状态
 * 2、防止克隆破环
 * 重写clone()，直接返回单例对象
 * 3、防止序列化破环
 * 添加readResolve()，返回Object对象
 */
public class Mgr06 {
    //volatile作用：
    //1.内存可见性；
    //volatile保持内存可见性的特殊规则：read、load、use动作必须连续出现；
    //assign、store、write动作必须连续出现；每次读取前必须先从主内存刷新最新的值；
    //每次写入后必须立即同步回主内存当中。也就是说，volatile关键字修饰的变量看到的随时是自己的最新值。
    //在线程1中对变量v的最新修改，对线程2是可见的。

    // 2.防止指令重排序
    //策略：在每个volatile写操作的前面插入一个StoreStore屏障；
    // 在每个volatile写操作的后面插入一个StoreLoad屏障；
    // 在每个volatile读操作的前面插入一个LoadLoad屏障；
    // 在每个volatile读操作的后面插入一个LoadStore屏障。

    //性能：
    //读性能消耗与普通变量几乎相同，但是写操作稍慢，
    // 因为它需要在本地代码中插入许多内存屏障指令来保证处理器不发生乱序执行。

    //不加volatile，会有指令重排问题，未初始化，即返回对象。
    private static volatile Mgr06 INSTANCE;
    private Mgr06(){
    }
    public static Mgr06 getInstance() {
        //这次判断很有必要
        if (INSTANCE == null) {
            synchronized (Mgr06.class){
                //双重检查
                if(INSTANCE==null){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }
    public void m(){
        //业务代码
    }



    public static void main(String[] args) {
        for(int i =0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
