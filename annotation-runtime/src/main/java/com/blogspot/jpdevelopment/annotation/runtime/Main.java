package com.blogspot.jpdevelopment.annotation.runtime;

import com.blogspot.jpdevelopment.annotation.runtime.annotation.AnnotationScanner;

public class Main {

    public static void main(String[] args) {
        AnnotationScanner annotationScanner = new AnnotationScanner();
        annotationScanner.scan();

    }
}
