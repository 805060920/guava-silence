package com.silence.ex.bussiness.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auth yang
 * @Description
 * @Date 2020/9/11
 */
public class ConnectionPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);

    //保证所有线程同时开始
    static CountDownLatch start = new CountDownLatch(1);

    //main线程在所有线程执行完毕之后重新开始执行
    static CountDownLatch end;

    public static void main(String[] args) {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);

    }

    static class ConnectionRunner implements Runnable {

        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
            }
            while (count > 0) {

            }

        }
    }
}
