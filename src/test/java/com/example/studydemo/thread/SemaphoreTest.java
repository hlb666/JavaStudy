package com.example.studydemo.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    Semaphore eat = new Semaphore(1, true);
    Semaphore sleep = new Semaphore(0, true);

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


    @Test
    public void semTest(){
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        semaphoreTest.sleep();

    }


}
