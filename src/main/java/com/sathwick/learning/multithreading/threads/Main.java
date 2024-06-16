package com.sathwick.learning.multithreading.threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("We are in thread: " + Thread.currentThread().getName());
            System.out.println("Current thread priority is: " + Thread.currentThread().getPriority());
            throw new RuntimeException("oops");

        });

        thread.setName("New Worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in thread : "+Thread.currentThread().getName()+" before we started a new thread");
        thread.start(); // instruct jvm to create thread
        System.out.println("We are in thread : "+Thread.currentThread().getName()+" after we started a new thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread "+t.getName()+" the error is "+e.getMessage());
            }
        });
    }
}
