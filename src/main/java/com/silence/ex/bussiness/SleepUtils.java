package com.silence.ex.bussiness;

import java.util.concurrent.TimeUnit;

/**
 * @auth yang
 * @Description
 * @Date 2020/9/2
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }

}
