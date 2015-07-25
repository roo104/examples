package com.blogspot.jpdevelopment.spring.async.service;

import java.util.concurrent.Future;

public interface IAsyncService {

    void asyncMethodWithVoidReturnType();

    Future<String> asyncMethodWithReturnType();
}
