package com.silence.ex.bussiness;

import java.util.concurrent.TimeUnit;

/**
 * @auth yang
 * @Description
 * @Date 2020/9/7
 */
public class Join {

    static class Domino implements Runnable{

        private Thread thread;

        public Domino(Thread thread){
            this.thread = thread;
        }

        @Override
        public void run() {

            try {
                thread.join();
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName() + " terminate.");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

}
