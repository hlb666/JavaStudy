package com.example.studydemo.common.thread.demotest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        FooBar solution = new ReentrantLockTest().new FooBar(1);

//        FooBar fooBar = new FooBar(20);

        Thread t1 = new Thread(() -> {
            try {
                solution.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("foo");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                solution.bar(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("bar");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }



    class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }
        Lock lock = new ReentrantLock(true);
        private final Condition foo = lock.newCondition();
        volatile boolean flag = true;
        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {

                    while (!flag){
                        foo.wait();
                    }
                    printFoo.run();
                    flag = false;
                    foo.signal();
                } catch (Exception e) {
                }finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n;i++) {
                lock.lock();
                try {
                    while(flag) {
                        foo.await();
                    }
                    printBar.run();
                    flag = true;
                    foo.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }


}
