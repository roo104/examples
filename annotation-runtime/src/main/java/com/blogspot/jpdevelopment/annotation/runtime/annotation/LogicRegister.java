package com.blogspot.jpdevelopment.annotation.runtime.annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LogicRegister {
}
