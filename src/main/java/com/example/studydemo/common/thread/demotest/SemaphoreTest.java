package com.example.studydemo.common.thread.demotest;



import java.util.concurrent.Semaphore;


// 信号量的测试
public class SemaphoreTest {

    static Semaphore eat = new Semaphore(1, true);
    static Semaphore sleep = new Semaphore(0, true);

    public void eat(){

            try {
                eat.acquire();
                System.out.println("吃饭");
                sleep.release();
            }catch (Exception e){
                e.printStackTrace();
            }
    }
    public void sleep()  {
            try {
                sleep.acquire();
                System.out.println("睡觉");
                eat.release();
            }catch (Exception e){
                e.printStackTrace();
            }
    }


    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        semaphoreTest.eat();
        semaphoreTest.sleep();

    }

}
