package com.blogspot.jpdevelopment.spring.aop.annotationinterceptor;

/**
 * Created by jp on 13-06-2015.
 */
public class AnnotationWriter {

    @WrapWithSpy
    public void writeMessage() {
        System.out.print("World");
    }
}
