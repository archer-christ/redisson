package org.redisson.executor;

import org.redisson.api.RedissonClient;
import org.redisson.api.annotation.RInject;

public class IncrementRunnableTask implements Runnable {

    private String counterName;
    
    @RInject
    private RedissonClient redisson;

    public IncrementRunnableTask() {
    }
    
    public IncrementRunnableTask(String counterName) {
        super();
        this.counterName = counterName;
    }

    @Override
    public void run() {
        redisson.getAtomicLong(counterName).incrementAndGet();
    }

}
