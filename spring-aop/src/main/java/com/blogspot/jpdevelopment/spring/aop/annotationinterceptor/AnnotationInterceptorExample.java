package com.blogspot.jpdevelopment.spring.aop.annotationinterceptor;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by jp on 13-06-2015.
 */
public class AnnotationInterceptorExample {

    public static void main(String[] args) {
        AnnotationWriter target = new AnnotationWriter();
        // create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);
        AnnotationWriter proxy = (AnnotationWriter) pf.getProxy();
        // write the messages target.writeMessage();
        target.writeMessage();
        System.out.println("");
        proxy.writeMessage();
    }
}
