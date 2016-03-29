package com.blogspot.jpdevelopment.annotation.runtime.annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BootstrapExecute {
}
