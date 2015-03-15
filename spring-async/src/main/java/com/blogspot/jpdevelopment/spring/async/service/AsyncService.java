package com.blogspot.jpdevelopment.spring.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService implements IAsyncService {

    @Override
    @Async
    public void asyncMethodWithVoidReturnType() {
        System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
    }

    @Override
    @Async
    public Future<String> asyncMethodWithReturnType() {
        AsyncResult<String> asyncResult = null;
        System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            asyncResult = new AsyncResult<String>("hello world!!!");
        } catch (InterruptedException e) {
            //
        }
        return asyncResult;
    }
}
