package com.silence.ex.bussiness.pool;

import org.checkerframework.checker.units.qual.A;

import java.sql.Connection;
import java.sql.SQLException;
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
                try {
                    //从连接池中获取连接
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {

                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //线程数量
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for(int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot)
                    , "ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection " + notGot);
    }

}
