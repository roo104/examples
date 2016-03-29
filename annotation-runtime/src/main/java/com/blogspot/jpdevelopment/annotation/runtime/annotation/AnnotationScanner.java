package com.blogspot.jpdevelopment.annotation.runtime.annotation;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Method;
import java.util.Set;

public class AnnotationScanner {

    private static final Reflections REFLECTIONS = new Reflections(new ConfigurationBuilder()
            .setUrls(ClasspathHelper.forPackage("com.blogspot.jpdevelopment"))
            .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner()));

    public void scan() {
        Set<Class<?>> logicClasses = REFLECTIONS.getTypesAnnotatedWith(LogicRegister.class);

        for (Class<?> clazz : logicClasses) {
            System.out.println("Found logic class: " + clazz.getCanonicalName());
            invokeBootstrapMethod(clazz);
        }

    }

    private void invokeBootstrapMethod(Class<?> clazz) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(clazz.getPackage().getName()))
                .setScanners(new MethodAnnotationsScanner()));

        Set<Method> bootstrapExecuteMethods = reflections.getMethodsAnnotatedWith(BootstrapExecute.class);

        for (Method method : bootstrapExecuteMethods) {
            System.out.println("Execute bootstrap method: " + method.getName());
            try {
                method.invoke(clazz.newInstance(), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
