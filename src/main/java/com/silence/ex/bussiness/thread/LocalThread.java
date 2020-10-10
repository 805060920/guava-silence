package com.silence.ex.bussiness.thread;

import java.util.concurrent.TimeUnit;

/**
 * @auth yang
 * @Description
 * @Date 2020/9/8
 */
public class LocalThread {

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }


    public synchronized Object get(long mills) throws InterruptedException {
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;

        while (remaining > 0){
            wait(remaining);
            remaining = future - System.currentTimeMillis();
        }
        return new Object();
    }





}
