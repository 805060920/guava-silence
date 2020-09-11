package com.silence.ex;

import com.google.common.base.Optional;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @auth yang
 * @Description
 * @Date 2020/8/21
 */
public class SilenceGuava {

    public void testGuava() {

    }


    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]  " + threadInfo.getThreadName());
        }

    }

}
