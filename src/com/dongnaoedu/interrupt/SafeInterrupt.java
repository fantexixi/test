package com.dongnaoedu.interrupt;

/**
 * 安全的中断线程
 */
public class SafeInterrupt implements Runnable {

    private volatile boolean on = true;
    private long i =0;

    @Override
    public void run() {
        while(on&&Thread.currentThread().isInterrupted()){
            i++;
        }
        System.out.println("TestRunable is runing :"+i);
    }

    public void cancel(){
        on = false;
        Thread.currentThread().interrupt();
    }
}
