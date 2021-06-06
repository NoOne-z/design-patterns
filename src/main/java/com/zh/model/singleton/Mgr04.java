package com.zh.model.singleton;

/**
 * @author z
 * @date 2021/5/30
 * 懒汉式
 * 按需初始化，但是线程不安全,可加锁处理，但是效率降低
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;
    private Mgr04(){
    }
    //Synchronized修饰非静态方法，实际上是对调用该方法的对象加锁，俗称“对象锁”
    //情况1：同一个对象在两个线程中分别访问该对象的两个同步方法
    //结果：会产生互斥。
    //解释：因为锁针对的是对象，当对象调用一个synchronized方法时，
    //其他同步方法需要等待其执行结束并释放锁后才能执行。

    //情况2：不同对象在两个线程中调用同一个同步方法
    //结果：不会产生互斥。
    //解释：因为是两个对象，锁针对的是对象，并不是方法，所以可以并发执行，不会互斥。
    //就是因为我们每个线程在调用方法的时候都是new一个对象，那么就会出现两个空间，两把钥匙

    //Synchronized修饰静态方法，实际上是对该类对象加锁，俗称“类锁”。
    //情况1：用类直接在两个线程中调用两个不同的同步方法
    //结果：会产生互斥。
    //解释：因为对静态对象加锁实际上对类（.class）加锁，类对象只有一个，
    //可以理解为任何时候都只有一个空间，里面有N个房间，一把锁，因此房间（同步方法）之间一定是互斥的。

    //情况2：用一个类的静态对象在两个线程中调用静态方法或非静态方法
    //结果：会产生互斥。
    //解释：因为是一个对象调用，同上。

    //情况3：一个对象在两个线程中分别调用一个静态同步方法和一个非静态同步方法
    //结果：不会产生互斥。
    //解释：因为虽然是一个对象调用，但是两个方法的锁类型不同，调用的静态方法实际上是类对象在调用，
    //即这两个方法产生的并不是同一个对象锁，因此不会互斥，会并发执行。
    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }
    public void m(){
        //业务代码
    }



    public static void main(String[] args) {
        for(int i =0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
