package com.example.studydemo.common.thread.demotest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {


        FooBar solution = new BlockingQueueTest().new FooBar(1);

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




    class FooBar{

        BlockingQueue<Integer> foo = new LinkedBlockingQueue(1);
        BlockingQueue<Integer> bar = new LinkedBlockingQueue(1);

        private int n;

        public FooBar(int n) {
            this.n = n;
        }
        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                foo.put(i);
                printFoo.run();
                bar.put(i);
            }

        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar.take();
                printBar.run();
                foo.take();
            }

        }


    }

}
