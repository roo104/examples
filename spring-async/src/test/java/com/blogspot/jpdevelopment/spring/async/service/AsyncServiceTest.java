package com.blogspot.jpdevelopment.spring.async.service;

import static org.junit.Assert.assertTrue;

import com.blogspot.jpdevelopment.spring.async.config.SpringAsyncConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import java.util.concurrent.ExecutionException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringAsyncConfig.class})
public class AsyncServiceTest {

    @Autowired
    private IAsyncService asyncService;

    @Test
    public void testAsyncMethodRunningSerially() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        this.asyncService.asyncMethodWithReturnType().get();
        this.asyncService.asyncMethodWithReturnType().get();

        stopWatch.stop();
        double totalTimeSeconds = stopWatch.getTotalTimeSeconds();

        // Time taken is at least 2x 5000 ms
        assertTrue(10 < totalTimeSeconds);
    }

    @Test
    public void testAsyncMethodRunningParalle() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Thread thread1 = new Thread() {
            public void run(){
                try {
                    AsyncServiceTest.this.asyncService.asyncMethodWithReturnType().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread() {
            public void run(){
                try {
                    AsyncServiceTest.this.asyncService.asyncMethodWithReturnType().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();

        stopWatch.stop();
        double totalTimeSeconds = stopWatch.getTotalTimeSeconds();

        // Time should be less than 2x 5000 ms
        assertTrue(6 > totalTimeSeconds);
    }
}