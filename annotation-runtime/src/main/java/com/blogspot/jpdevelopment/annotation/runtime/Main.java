package com.blogspot.jpdevelopment.annotation.runtime;

import com.blogspot.jpdevelopment.annotation.runtime.annotation.AnnotationScanner;
import com.blogspot.jpdevelopment.annotation.runtime.annotation.MessageKey;

public class Main {

    @MessageKey(numberOfArguments = 2, text = "")
    private static String key;

    public static void main(String[] args) {
        AnnotationScanner annotationScanner = new AnnotationScanner();
        annotationScanner.scan();

    }
}
