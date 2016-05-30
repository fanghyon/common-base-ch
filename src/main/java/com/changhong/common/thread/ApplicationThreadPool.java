package com.changhong.common.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * User: Jack Wang
 * Date: 14-5-7
 * Time: 上午11:03
 */
@Service("applicationThreadPool")
public class ApplicationThreadPool{

    private static ThreadPoolTaskExecutor pool = null;

    static {
        pool = new ThreadPoolTaskExecutor();
        pool.setQueueCapacity(200);
        pool.setCorePoolSize(100);
        pool.setMaxPoolSize(200);
        pool.setKeepAliveSeconds(10000);
        pool.initialize();
    }

    public static void executeThread(Thread thread) {
        pool.execute(thread);
    }

}
