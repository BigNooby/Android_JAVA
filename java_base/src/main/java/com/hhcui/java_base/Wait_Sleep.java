package com.hhcui.java_base;

/**
 * @ClassName: Wait_Sleep
 * @Description:
 * @Author: hhcui
 * @CreateDate: 2019/12/13 9:54
 * @UpdateDate: 2019/12/13 9:54
 * @Version: 1.0
 */
public class Wait_Sleep {
    private final static Object mLock = new Object();

    public static void main(String[] args){

     String[] threadNames =    {"线程1","线程2"};
     for (String name :threadNames){
         new Thread(name){
             @Override
             public void run() {
                 super.run();
                 Wait_Sleep.testWaitLock();
             }
         }.start();
     }
    }

    /**
     * 线程1正在运行
     * 线程2正在运行
     * 线程1wait over
     * 线程2wait over
     */
    private  static void testWaitLock(){
        synchronized (mLock){
            System.out.println(Thread.currentThread().getName()+"正在运行");
            try {
                mLock.wait(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"wait over");

        }

    }

    private static void testSleepLock(){

    }
}
