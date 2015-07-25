package com.blogspot.jpdevelopment.spring.aop.methodinterceptor;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by jp on 13-06-2015.
 */
public class MethodInterceptorExample {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        // create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);
        MessageWriter proxy = (MessageWriter) pf.getProxy();
        // write the messages target.writeMessage();
        target.writeMessage();
        System.out.println("");
        proxy.writeMessage();
    }
}
