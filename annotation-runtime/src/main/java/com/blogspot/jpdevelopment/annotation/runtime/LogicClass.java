package com.blogspot.jpdevelopment.annotation.runtime;

import com.blogspot.jpdevelopment.annotation.runtime.annotation.BootstrapExecute;
import com.blogspot.jpdevelopment.annotation.runtime.annotation.LogicRegister;

@LogicRegister
public class LogicClass {

    @BootstrapExecute
    public void setup() {
        System.out.println("Executed!");
    }
}
