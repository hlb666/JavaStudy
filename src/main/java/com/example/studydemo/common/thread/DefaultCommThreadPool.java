package com.example.studydemo.common.thread;


import java.util.concurrent.*;


/**
 * Description: 全局的共用线程池
 * package:     com.hikvision.pbg.gov.common.thread
 * className:   DefaultCommThreadPool
 *
 * @author qiushi
 * @date 2019/11/15 18:03
 * @since V1.0
 */
public class DefaultCommThreadPool {


    private DefaultCommThreadPool() {
    }

    /**
     * 系统全局线程,一个runable对应一个thead,一旦满了,则单独调用{@link Runnable#run()}
     *
     * @see DefaultCommThreadRejectHandler#rejectedExecution(Runnable, ThreadPoolExecutor)
     */

    private static final ExecutorService EXECUTOR =
            new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2,
                    Runtime.getRuntime().availableProcessors() * 4, 1L, TimeUnit.HOURS, new LinkedBlockingQueue<>(),
                    new DefaultCustomThreadFactory("core" + ".DefaultCommThreadPool"),
                    new DefaultCommThreadRejectHandler());

    public static void execute(Runnable runnable) {
        EXECUTOR.execute(runnable);
    }


    public static Future<?> submit(Runnable runnable) {
        return EXECUTOR.submit(runnable);
    }


    public static <T> Future<T> submit(Callable<T> runnable) {
        return EXECUTOR.submit(runnable);
    }

    /**
     * 对线程池满的情况的处理
     * <p></p>
     *
     * @author <a href="mailto:wangyu9@hikvision.com.cn">wangyu9</a> 2018年1月9日 下午1:22:05
     * @version V1.0
     * @modificationHistory=========================逻辑或功能性重大变更记录
     * @modify by user: {修改人} 2018年1月9日
     * @modify by reason:{方法名}:{原因}
     */
    private static class DefaultCommThreadRejectHandler extends ThreadPoolExecutor.CallerRunsPolicy {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {

            super.rejectedExecution(r, e);
        }

    }
}
