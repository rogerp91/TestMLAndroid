package com.github.rogerp91.ml.domain.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolThreadExecutor implements Executor {

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>();

    private ThreadPoolExecutor threadPoolexecutor;

    public PoolThreadExecutor() {
        threadPoolexecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    public PoolThreadExecutor(final int corePoolSize, final int maxPoolSize, final int keepAliveTime, final TimeUnit timeUnit) {
        threadPoolexecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, WORK_QUEUE);
    }

    @Override
    public void run(final Interactor interactor) {
        if (interactor == null) {
            throw new IllegalArgumentException("Interactor to execute can't be null");
        }
        threadPoolexecutor.submit(interactor);
    }

}
