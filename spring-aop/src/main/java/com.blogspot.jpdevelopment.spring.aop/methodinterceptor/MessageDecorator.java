package com.blogspot.jpdevelopment.spring.aop.methodinterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by jp on 13-06-2015.
 */
public class MessageDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Hello ");
        Object retVal = methodInvocation.proceed();
        System.out.println("!");
        return retVal;
    }
}
