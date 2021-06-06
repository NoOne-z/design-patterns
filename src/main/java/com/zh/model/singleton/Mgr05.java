package com.zh.model.singleton;

/**
 * @author z
 * @date 2021/5/30
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;
    private Mgr05(){
    }
    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            //妄图减小同步代码块以提高效率，实际不可行
            //原因：当第一个线程判断instance为空后，切换第二个线程判断依然为空，执行同步代码块后，释放锁
            //第一个线程将继续执行，再次new一个对象
            synchronized (Mgr05.class){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
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
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
