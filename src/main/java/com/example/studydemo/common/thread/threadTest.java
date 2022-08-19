package com.example.studydemo.common.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;

public class threadTest {

    private final ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
            new DefaultCustomThreadFactory("study-demo-threadTest-thread"));



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        threadTest threadTest = new threadTest();
        threadTest.ddtest();






    }


    public void ddtest() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("yyyy年MM月dd日 HH时mm分ss秒");

        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.initialize();

        threadPoolTaskScheduler.scheduleWithFixedDelay(new PollingTask(), new Date(),
                    TimeUnit.SECONDS.toMillis(9));
//        ScheduledFuture<?> schedule = scheduledExecutorService.schedul e(new PollingTask(), 2, TimeUnit.SECONDS);
    }

    class PollingTask implements Runnable{


        @Override
        public void run() {
            SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
            sdf.applyPattern("yyyy年MM月dd日 HH时mm分ss秒");
            try {
                System.out.println("task start time: " + sdf.format(System.currentTimeMillis()));
                Thread.sleep(3000L);

            } catch ( Exception e) {
                e.printStackTrace();
            }
            System.out.println("task finish time: " + sdf.format(System.currentTimeMillis()));
        }
    }









}
