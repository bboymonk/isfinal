package com.isfinal;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by wjb on 2019/2/19.
 */
public class ThreadTest {

    public static void main(String[] args) {
        LinkedBlockingQueue<Thread> queue = new LinkedBlockingQueue<Thread>();
        queue.add(new Thread(new Work()));
        queue.add(new Thread(new Work()));
        queue.add(new Thread(new Work()));


        for (int i = 0;i< 3;i++){
            Thread t = null;
            try {
                 t = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.start();
            while (t.isAlive());
        }


    }

    static class Work implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

}
