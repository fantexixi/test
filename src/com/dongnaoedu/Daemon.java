package com.dongnaoedu;

import com.dongnaoedu.threadstate.SleepUtils;


public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner());
        thread.setDaemon(false);//(false)设置为用户线程,(true)设置为守护线程,设置为true，即主线程结束，thread线程也结束。
        thread.start();
//        SleepUtils.second(Thread.MAX_PRIORITY);
        System.out.println("main  run.");//
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(1);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
