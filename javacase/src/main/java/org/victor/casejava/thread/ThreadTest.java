package org.victor.casejava.thread;

import org.junit.Test;

/**
 * Created by zhengcunwen on 2016/8/22.
 */
public class ThreadTest {

    public static void main(String[] args) {
        createTest();
    }

    /** 一般方法创建线程 **/
    public static void createTest(){
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                while (true){

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("thread1:"+ Thread.currentThread().getName());
                }
            }
        };

        // 实现接口方式
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread2:"+ Thread.currentThread().getName());
            }
        });

        thread1.start();
        thread2.start();
    }
}
