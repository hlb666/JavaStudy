package com.example.studydemo.common.thread.demotest;

import kotlin.jvm.Volatile;

public class ThreadYield {


    public static void main(String[] args) {
       FooBar solution = new ThreadYield().new FooBar(1);

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

        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        volatile Boolean permitFoo = true;

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; ) {
                if (permitFoo) {
                    printFoo.run();
                    i++;
                    permitFoo = false;
                }else {
                    Thread.yield();
                }
            }



        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; ) {
                if (!permitFoo) {
                    printBar.run();
                    i++;
                    permitFoo = true;
                }else {
                    Thread.yield();
                }
            }

        }









    }



}
