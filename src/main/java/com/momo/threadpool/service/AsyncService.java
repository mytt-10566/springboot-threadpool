package com.momo.threadpool.service;

import com.momo.threadpool.controller.AsyncTaskController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class AsyncService {
    private static final Logger LOG = LoggerFactory.getLogger(AsyncService.class);

    @Async("taskExecutor")
    public void execute() {
        try {
            for (int i = 0; i < 2; i++) {
                Thread.sleep(2000);
                LOG.info(Thread.currentThread().getName() + " " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public ListenableFuture<String> executeReturnValue() {
        LOG.info(Thread.currentThread().getName() + " begin...");

        String value = "value is ";
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        AsyncResult<String> stringAsyncResult = new AsyncResult<>(value + System.currentTimeMillis());

        LOG.info(Thread.currentThread().getName() + " end...");
        return stringAsyncResult;
    }
}
