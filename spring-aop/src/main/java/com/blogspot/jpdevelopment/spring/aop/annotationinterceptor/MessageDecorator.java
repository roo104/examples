package com.blogspot.jpdevelopment.spring.aop.annotationinterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by jp on 13-06-2015.
 */
public class MessageDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Hello ");
        Method method = methodInvocation.getMethod();
        String methodName = method.getName();
//        String[] argumentNames = method.getAnnotation(WrapWithSpy.class).argumentNames();
        Object retVal = methodInvocation.proceed();
        System.out.println("!");
        return retVal;
    }
}
