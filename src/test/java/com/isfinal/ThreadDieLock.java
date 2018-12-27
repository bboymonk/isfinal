package com.isfinal;

/**
 * Created by wjb on 2018/12/20.
 */
public class ThreadDieLock {

    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) {
        new Thread("a"){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println(Thread.currentThread().getName());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.println(Thread.currentThread().getName());
                    }
                    System.out.println("a线程结束");
                }
            }
        }.start();


        new Thread("b"){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println(Thread.currentThread().getName());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.println(Thread.currentThread().getName());
                    }
                    System.out.println("b线程结束");
                }
            }
        }.start();


    }

}
