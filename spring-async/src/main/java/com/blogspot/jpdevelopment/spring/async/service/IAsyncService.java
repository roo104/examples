package com.blogspot.jpdevelopment.spring.async.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

public interface IAsyncService {

    void asyncMethodWithVoidReturnType();

    Future<String> asyncMethodWithReturnType();
}
