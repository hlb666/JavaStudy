package com.example.studydemo.common.thread;



import javax.validation.constraints.NotNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Description: 自定义的默认线程池的工厂，方便以后维护是查看线程池的名称 如：-jstack 中显示需要的名称
 * package:     com.hikvision.pbg.gov.common.thread
 * className:   DefaultCustomThreadFactory
 *
 * @author qiushi
 * @date 2019/11/15 18:04
 * @since V1.0
 */
public class DefaultCustomThreadFactory implements ThreadFactory {

    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    /**
     * 线程池的前缀
     */
    private final String namePrefix;

    public DefaultCustomThreadFactory(String namePreFix) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = namePreFix + "-pool-thread-";
    }


    @Override
    public Thread newThread( Runnable r) {
        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
