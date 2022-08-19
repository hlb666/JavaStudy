package com.example.studydemo.start;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableScheduling
public class ScheduleTest {

    private volatile Date startTime;
    private volatile Date endTime;
    private Boolean flag = true;

    @Scheduled(cron="*/5 * * * * ?")
    public void task(){
        if (flag) {
            startTime = new Date();
            flag = false;
            System.out.println("关闭所有任务");
        }
        System.out.println(startTime);
        try {
            System.out.println("开启并执行任务");

        }finally {
            endTime = new Date();
            System.out.println(endTime);
            System.out.println(formatDate(startTime,endTime));
            if (formatDate(startTime,endTime)>1) {
                flag = true;
            }
        }


    }


    private int formatDate(Date startTime, Date endTime){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate = df.format(startTime);
        String sqlDate1 = df.format(endTime);
        try {
            startTime = df.parse(newDate);
            endTime = df.parse(sqlDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long time =  startTime.getTime();
        Long time2 =  endTime.getTime();
        int min = (int) ((time2 - time) / (60*1000));

        return min;
    }




}
