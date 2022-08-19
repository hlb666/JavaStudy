package com.example.studydemo.common.thread.demotest;

public class SynchronizedTest {
    public static void main(String[] args) {


        FooBar solution = new SynchronizedTest().new FooBar(1);

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
        // 标志位，控制执行顺序，true执行printFoo，false执行printBar
        private volatile boolean type = true;
        private final Object foo=  new Object(); // 锁标志



        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {

                synchronized (foo) {
                    while (!type) {
                        foo.wait();
                    }
                    printFoo.run();
                    type = false;
                    foo.notifyAll();

                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (foo) {
                    while(type){
                        foo.wait();
                    }
                    printBar.run();
                    type = true;
                    foo.notifyAll();
                }
            }
        }
    }

}
